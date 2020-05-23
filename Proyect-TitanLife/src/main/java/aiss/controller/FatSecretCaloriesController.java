package aiss.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;

import aiss.model.repository.TitanLifeRepository;
import aiss.model.resource.FatSecretResource;
import aiss.model.titan.User;
import aiss.utility.CalculatorFatSecret;

public class FatSecretCaloriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(FatSecretCaloriesController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final User u=TitanLifeRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		if(u==null) {
			request.getRequestDispatcher("/intro.jsp").forward(request, response);
		}else {
			Integer caloriesUser=CalculatorFatSecret.userBaseCalories(u);
			// Reseteamos por completo las calorías si todavía no se ha entrado a la vista de Mis Comidas, si hemos pasado de día
			if(u.getBaseCaloriasDiarias()==null || !u.getInstanteCalorias().equals(LocalDate.now())) {
				u.setBaseCaloriasDiarias(caloriesUser);
				u.setCaloriasDiarias(caloriesUser);
				u.setInstanteCalorias(LocalDate.now());
				u.setComidasDiarias(new ArrayList<String>());
				log.info("Reset data calories for user: "+u.getUsername());
			// Hacemos los calculos necesarios por si han cambiado las calorías del usuario por motivos ajenos a las comidas
			}else {
				Integer restadas=u.getBaseCaloriasDiarias()-u.getCaloriasDiarias();
				u.setBaseCaloriasDiarias(caloriesUser);
				u.setCaloriasDiarias(caloriesUser-restadas);
			}
			log.info(u.getUsername()+" base calories: "+u.getBaseCaloriasDiarias());
			log.info(u.getUsername()+" calories: "+u.getCaloriasDiarias());
			// Sugerencias de comidas
			Random rand = new Random();
			List<String> letrasAleatorias=new ArrayList<>();
			while(letrasAleatorias.size()<3) {
				char c = (char) (rand.nextInt(26) + 'a');
				letrasAleatorias.add(String.valueOf(c));
			}
			List<Food> sugerencias=new ArrayList<>();
			for(String a:letrasAleatorias) {
				List<CompactFood> lc=FatSecretResource.searchFood(a);
				if(lc!=null && lc.size()>0) {
					Integer i=0;
					while(i<10) {
						Food s=FatSecretResource.detaliedFood(lc.get(rand.nextInt(lc.size())).getId());
						if(s!=null && s.getServings().get(0).getMetricServingAmount()!=null) {
							sugerencias.add(s);
						}
						i++;
					}
				}
			}
			Collections.sort(sugerencias, new Comparator<Food>() {
			    @Override
			    public int compare(Food o1, Food o2) {
			        return ((Integer)Math.abs(u.getCaloriasDiarias()-CalculatorFatSecret.caloriesPer100(o1)))
			        		.compareTo(Math.abs(u.getCaloriasDiarias()-CalculatorFatSecret.caloriesPer100(o2)));
			    }
			});
			log.info("Recommendation algoritmic: "+(sugerencias!=null && sugerencias.size()>0));
			
			request.setAttribute("sugerencias", sugerencias);
			request.getRequestDispatcher("/misComidas.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
