package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.repository.UserRepository;
import aiss.model.titan.User;

/**
 * Servlet implementation class DeleteFatSecretController
 */
public class DeleteFatSecretController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(DeleteFatSecretController.class.getName());
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=UserRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		if(u==null) {
			request.getRequestDispatcher("/intro.jsp").forward(request, response);
		}else {
			String comidasUsuario[]=request.getParameterValues("comidasUsuario");
			log.info("Eliminaciones para el usuario "+u.getUsername()+": "+comidasUsuario);
			if(comidasUsuario!=null && comidasUsuario.length>0) {
				List<String> f=new ArrayList<>();
				for(String food:comidasUsuario) {
					String trozos[]=food.split("/");
					String calorias=trozos[4];
					log.info("Calorias a sumar: "+calorias);
					u.setCaloriasDiarias(u.getCaloriasDiarias()+Integer.parseInt(calorias));
					f.add(food);
				}
				log.info("Comidas a eliminar: "+f);
				u.getComidasDiarias().removeAll(f);
			}
			request.getRequestDispatcher("/fatSecretCaloriesController").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
