package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.repository.Repository;
import aiss.model.repository.TitanLifeRepository;
import aiss.utility.Validacion;

public class ValidatorController  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ValidatorController.class.getName());
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	if(request.getParameter("username")==null) {
    		log.info("Usuario todavía no registrado");
    		request.getRequestDispatcher("registro.jsp").forward(request, response);
    	}else {
    		String username=request.getParameter("username");
            String email=request.getParameter("email");
            String password=request.getParameter("password");
            String retype=request.getParameter("retype");
            String age=request.getParameter("age");
            String height=request.getParameter("height");
            String weight=request.getParameter("weight");
            String hip=request.getParameter("hip");
            String waist=request.getParameter("waist");
            String sex=request.getParameter("sex");
            
            Repository repository=TitanLifeRepository.getInstance();
            String validaciones = Validacion.validacion(username, email, password, retype, age, height, weight, hip, waist, sex);
           
            if(validaciones=="") {
            	log.info("Validación de usuario "+username+" correcta");
            	repository.addUser(username,email,password,retype,age,height,weight,hip,waist,sex);            
            	HttpSession sesion=request.getSession(true);
            	sesion.setAttribute("username", username);

            	request.getRequestDispatcher("/conexionController").forward(request, response);
            }else {
            	log.info("Validación de usuario incorrecta");
            	request.setAttribute("validaciones", validaciones);
            	request.setAttribute("username", username);
            	request.setAttribute("email", email);
            	request.setAttribute("password", password);
            	request.setAttribute("retype", retype);
            	request.setAttribute("age", age);
            	request.setAttribute("height", height);
            	request.setAttribute("weight", weight);
            	request.setAttribute("hip", hip);
            	request.setAttribute("waist", waist);
            	request.setAttribute("sex", sex);
            	request.getRequestDispatcher("/registro.jsp").forward(request, response);
            }
    	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
