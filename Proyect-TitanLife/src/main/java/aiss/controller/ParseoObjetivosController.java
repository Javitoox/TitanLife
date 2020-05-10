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
import aiss.model.titan.Objetivo;
import aiss.model.titan.User;

public class ParseoObjetivosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ParseoObjetivosController.class.getName());
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=UserRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		UserRepository r=UserRepository.getInstance();
		
		// Control de la asignación de objetivos del usuario
		String objetivos[]=request.getParameterValues("opDep");
		if(objetivos!=null && objetivos.length>0) {
			List<Objetivo> ob=new ArrayList<>();
			for(String objetivo: objetivos) {
				ob.add(r.findByObjetiveName(objetivo));
			}
			u.setObjetivos(ob);
			request.getSession().setAttribute("user", u);
			log.info("Asignados los objetivos correspondientes al usuario "+u.getUsername());
			request.getRequestDispatcher("/objetivos.jsp").forward(request, response);
		}else {
			log.info("No se ha seleccionado ningún objetivo");
			request.getRequestDispatcher("/objetivos.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
