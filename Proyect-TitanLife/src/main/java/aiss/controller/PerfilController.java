package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.User;
import aiss.model.repository.UserRepository;

public class PerfilController extends HttpServlet {
	
    private static final Logger log = Logger.getLogger(PerfilController.class.getName());

	
    private static final long serialVersionUID = 1L;

	public PerfilController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        // TODO: Read request parameters
	    	 String uname =request.getParameter("Username");
	         String email =request.getParameter("Email");
	         String password =request.getParameter("Password");
	         Integer age =Integer.valueOf(request.getParameter("Age"));
	         Double height =Double.valueOf(request.getParameter("Height"));
	         Double weight =Double.valueOf(request.getParameter("Weight"));
	         Double hip =Double.valueOf(request.getParameter("Hip"));
	         Double waist =Double.valueOf(request.getParameter("Waist"));


	        UserRepository singelton = UserRepository.getInstance();

	    	HttpSession misession= (HttpSession) request.getSession(true);
	    	 
	    	User user= (User) misession.getAttribute("user");
	    	
	        String validaciones = "";
	        String userRegexp = "^[a-zA-Z0-9_-]{3,15}$";
	        String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
	        String passwordRegexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
	        
	        if(!Pattern.matches(userRegexp, uname)) {
	        	//validaciones.add("El nombre de usuario presenta un formato incorrecto.");
	        	validaciones += "El nombre de usuario presenta un formato incorrecto.";
	        }
	        
			if(!Pattern.matches(emailRegexp, email)) {
			   //validaciones.add("Formato incorrecto del correo");
				validaciones += "Formato incorrecto del correo";
			}
	         

	        if(!Pattern.matches(passwordRegexp, password)) {
	         	//validaciones.add("La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres");
	         	validaciones += "La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres";
	        }
	
	        if(!validaciones.equals("")) {
	         	request.setAttribute("validaciones", validaciones);
	   		    log.log(Level.FINE, "Processing GET request:  "+ "El usuario " + uname + " no ha podido actualizarse correctamente.");
	            request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
	        }
    	
	    	user.setUsername(uname);
	    	user.setEmail(email);
	    	user.setPassword(password);
	    	user.setRetype(password);
	    	user.setAge(age);
	    	user.setHeight(height);
	    	user.setWeight(weight);
	    	user.setHip(hip);
	    	user.setWaist(waist);
	    	
         	singelton.updateUser(user);	
         	
	     	misession.setAttribute("user", user);
	     	
   		    log.log(Level.FINE, "Processing GET request:  "+ "El usuario " + uname + " se ha podido actualizar correctamente.");
   		    
	        request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        doGet(request, response);
	       
	    }
	}