package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;

import aiss.model.repository.TitanLifeRepository;
import aiss.model.resource.FatSecretResource;
import aiss.model.titan.User;

/**
 * Servlet implementation class FoodsFatSecretController
 */
public class FoodsFatSecretController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(FoodsFatSecretController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=TitanLifeRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		if(u==null) {
			request.getRequestDispatcher("/intro.jsp").forward(request, response);
		}else {
			String botonComidas=request.getParameter("botonComidas");
			if(botonComidas.equals("Buscar comida")) {
				log.info("Búsqueda de comidas iniciada para el usuario: "+u.getUsername());
				String search=request.getParameter("search");
				if(Pattern.matches("^[a-zA-Z]+[a-zA-Z ]*$",search)) {
					List<CompactFood> searchs=FatSecretResource.searchFood(search);
					if(searchs!=null && searchs.size()>0) {
						List<Food> foods=new ArrayList<>();
						Random rand = new Random();
						Integer i=0;
						while(i<20) {
							Food fd=FatSecretResource.detaliedFood(searchs.get(rand.nextInt(searchs.size())).getId());
							if(fd!=null && fd.getServings().get(0).getMetricServingAmount()!=null) {
								foods.add(fd);
							}
							i++;
						}
						log.info("Comidas encontradas para el usuario: "+u.getUsername());
						request.setAttribute("sugerencias", foods);
					}
				}else {
					request.setAttribute("validaciones", "Formato de búsqueda incorrecto");
				}
				request.getRequestDispatcher("/misComidas.jsp").forward(request, response);
			}else if(botonComidas.equals("Añadir comida")) {
				log.info("Añadiendo comida para el usuario: "+u.getUsername());
				String cantidad=request.getParameter("cantidad");
				String comidas=request.getParameter("comidas");
				String caloriasOcultas=request.getParameter("caloriasOcultas");
				log.info(comidas+"/"+cantidad+"/"+caloriasOcultas+" for user "+u.getUsername());
				if(Pattern.matches("^[0-9]+$",cantidad) && comidas!=null && !comidas.equals("") && 
						caloriasOcultas!=null && !caloriasOcultas.equals("")) {
					u.setCaloriasDiarias(u.getCaloriasDiarias()-Integer.parseInt(caloriasOcultas));
					u.getComidasDiarias().add(comidas+"/"+cantidad+"/"+caloriasOcultas);
					log.info(u.getUsername()+"´foods actualized");
					request.getRequestDispatcher("/fatSecretCaloriesController").forward(request, response);
				}else {
					request.setAttribute("validaciones", "Formato de cantidad inadecuado");
					request.getRequestDispatcher("/misComidas.jsp").forward(request, response);
				}
			}else {
				log.info("Error in select buttom of foods");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
