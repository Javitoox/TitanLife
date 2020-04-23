package aiss.controller;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.repository.UserRepository;
import aiss.model.titan.User;

public class PerfilController extends HttpServlet {
	
    private static final Logger log = Logger.getLogger(PerfilController.class.getName());

	
    private static final long serialVersionUID = 1L;

	public PerfilController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//	    	String username =request.getParameter("Username");
//	        String email =request.getParameter("Email");
//	        String password =request.getParameter("Password");
//	        Integer age =Integer.valueOf(request.getParameter("Age"));
//	        Double height=Double.valueOf(request.getParameter("Height"));        
//
//	        
//	        //Aquí realizamos un checkeo del peso, ya que normalmente se suele poner con coma y, como es un double se debería poner un punto
//	        //a partir de aquí se lleva a cabo esa transformación
//	        
//	        String preweight = request.getParameter("Weight");
//	        
//			if(preweight.contains(",")) {
//	        String[] dividiendo = preweight.split(",");
//	        Double parteprimmeradeldouble = Double.valueOf(dividiendo[0].trim());
//	        Double divisor = Math.pow(10,dividiendo[1].trim().length());
//	        Double partesegundadeldouble=Double.valueOf(dividiendo[1].trim())/divisor;
//	        preweight= String.valueOf(parteprimmeradeldouble+partesegundadeldouble);
//	        }
//			
//			Double weight=Double.valueOf(preweight);        
//	        Double hip =Double.valueOf(request.getParameter("Hip"));
//	        Double waist =Double.valueOf(request.getParameter("Waist"));
//	        
//	        String validaciones = "";
//	        
//	        
//	        //Expresiones regulares usadas
//	        String userRegexp = "^[a-zA-Z0-9_-]{3,15}$";
//	        String ageRegexp = "^[0-9]{1,3}$";
//	        String heightRegexp = "^[0-9]+[,.]{0,1}+[0-9]{1,16}$";
//	        String weightRegexp = "^[0-9]{1,8}$";
//	        String hipRegexp = "^[0-9]{1,8}$";
//	        String waistRegexp = "^[0-9]{1,8}$";
//	        String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
//	        String passwordRegexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
//	        
//	        //Declaración patrón Singelton
//	        UserRepository singelton = UserRepository.getInstance();
//	        Map<Integer, User> users = singelton.getUsers(); 
//	        
//	        //Session
//	        
//	    	HttpSession misession= (HttpSession) request.getSession(true);   	 
//
//	    	//Obtención datos de usuario en sesión
//	    	 
//	    	User user= (User) misession.getAttribute("user");	    	
//	        
//	        
//	    	if(users.containsKey(username)) {
//	        	validaciones += "Usuario ya existente\n";
//	        }
//	        
//	        if(!Pattern.matches(userRegexp, username)) {
//	        	validaciones += "El nombre de usuario presenta un formato incorrecto\n";
//	        }
//	        
//	        if(!Pattern.matches(emailRegexp, email)) {
//	        	//validaciones.add("Formato incorrecto del correo");
//	        	validaciones += "Formato incorrecto del correo\n";
//	        }
//	        
//	        if(!Pattern.matches(passwordRegexp, password)) {
//	        	validaciones += "La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres\n";
//	        }
//
//	       	        
//	        if(!Pattern.matches(ageRegexp, request.getParameter("Age"))) {
//	        	validaciones += "Formato incorrecto de la edad\n";
//	        }
//	        
//	        if(!Pattern.matches(heightRegexp, request.getParameter("Height"))) {
//	        	validaciones += "Formato incorrecto de la altura\n";
//	        }
//	        
//	        if(!Pattern.matches(weightRegexp, request.getParameter("Weight"))) {
//	        	validaciones += "Formato incorrecto del peso\n";
//	        }
//	        
//	        if(!Pattern.matches(hipRegexp, request.getParameter("Hip"))) {
//	        	validaciones += "Formato incorrecto de la cadera\n";
//	        }
//	        
//	        if(!Pattern.matches(waistRegexp, request.getParameter("Waist"))) {
//	        	validaciones += "Formato incorrecto de la cintura\n";
//	        }
//    	
//	        if(!validaciones.equals("")) {
//	        	
//	         	request.setAttribute("validaciones", validaciones);
//	        	
//	   		    log.log(Level.FINE, "Processing GET request:  "+ "El usuario " + username + " fue actualizado incorrectamente.");
//	   		    
//	        }else {
//	        	
//	        	user.setUsername(username);
//		    	user.setEmail(email);
//		    	user.setPassword(password);
//		    	user.setRetype(password);
//		    	
//	         	singelton.updateUser(user);	
//		     	
//	   		    log.log(Level.FINE, "Processing GET request:  "+ "El usuario " + username + " se ha podido actualizar correctamente.");
//	   		    
//	        }
//	        
//	        misession.setAttribute("user", user);
//	        request.getRequestDispatcher("/Perfil.jsp").forward(request, response);
	    
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        doGet(request, response);
	       
	    }
	}