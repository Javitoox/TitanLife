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

import aiss.model.User;
import aiss.model.repository.UserRepository;

public class ValidatorController  extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(ValidatorController.class.getName());

    public ValidatorController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO: Read request parameters
    	
        String username =request.getParameter("Username");
        String email =request.getParameter("Email");
        String password =request.getParameter("Password");
        String retype =request.getParameter("Retype");
        Integer age =Integer.valueOf(request.getParameter("Age"));
        Double height=Double.valueOf(request.getParameter("Height"));        

        
        //Aquí realizamos un checkeo del peso, ya que normalmente se suele poner con coma y, como es un double se debería poner un punto
        //a partir de aquí se lleva a cabo esa transformación
        
        String preweight = request.getParameter("Weight");
        
		if(preweight.contains(",")) {
        String[] dividiendo = preweight.split(",");
        Double parteprimmeradeldouble = Double.valueOf(dividiendo[0].trim());
        Double divisor = Math.pow(10,dividiendo[1].trim().length());
        Double partesegundadeldouble=Double.valueOf(dividiendo[1].trim())/divisor;
        preweight= String.valueOf(parteprimmeradeldouble+partesegundadeldouble);
        }
		
		Double weight=Double.valueOf(preweight);        
        Double hip =Double.valueOf(request.getParameter("Hip"));
        Double waist =Double.valueOf(request.getParameter("Waist"));
        
        //List<String> validaciones = new ArrayList<>();
        String validaciones = "";
        
        //Session
        HttpSession session = request.getSession(true);
        
        //Expresiones regulares usadas
        String userRegexp = "^[a-zA-Z0-9_-]{3,15}$";
        String ageRegexp = "^[0-9]{1,3}$";
        String heightRegexp = "^[0-9]+[,.]{0,1}+[0-9]{1,16}$";
        String weightRegexp = "^[0-9]{1,8}$";
        String hipRegexp = "^[0-9]{1,8}$";
        String waistRegexp = "^[0-9]{1,8}$";
        String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        String passwordRegexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
        
        //Declaración patrón Singelton

        UserRepository singelton = UserRepository.getInstance();
        Map<String, User> users = singelton.getUsers();        
        
        if(username==""||email==""||password==""||retype==""||String.valueOf(age)==""||String.valueOf(height)==""||String.valueOf(weight)==""||String.valueOf(hip)==""||String.valueOf(waist)=="") {
        	validaciones += "Los campos no pueden quedar vacíos";
        }
        
        if(users.containsKey(username)) {
        	//validaciones.add("Usuario ya existente");
        	validaciones += "Usuario ya existente";
       }
        
        if(!Pattern.matches(userRegexp, username)) {
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

        if(!password.equals(retype)) {
        	//validaciones.add("La contraseña no coincide con la confirmación");
        	validaciones += "La contraseña no coincide con la confirmación";
        }
        
        if(!Pattern.matches(ageRegexp, request.getParameter("Age"))) {
        	//validaciones.add("La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres");
        	validaciones += "Formato incorrecto de la edad";
        }
        if(!Pattern.matches(heightRegexp, request.getParameter("Height"))) {
        	//validaciones.add("La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres");
        	validaciones += "Formato incorrecto de la altura";
        }
        if(Pattern.matches(weightRegexp, String.valueOf(weight))) {
        	//validaciones.add("La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres");
        	validaciones += "Formato incorrecto del peso";
        }
        if(!Pattern.matches(hipRegexp, request.getParameter("Hip"))) {
        	//validaciones.add("La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres");
        	validaciones += "Formato incorrecto de la cadera";
        }
        if(!Pattern.matches(waistRegexp, request.getParameter("Waist"))) {
        	//validaciones.add("La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres");
        	validaciones += "Formato incorrecto de la cintura";
        }
        
        //if(!validaciones.isEmpty()) {
        if(!validaciones.equals("")) {
        	
        	request.setAttribute("username", username);
        	request.setAttribute("email", email);
        	request.setAttribute("password", password);
        	request.setAttribute("retype", retype);
        	request.setAttribute("age", age);
        	request.setAttribute("height", height.intValue());
        	request.setAttribute("weight", weight.intValue());
        	request.setAttribute("hip", hip.intValue());
        	request.setAttribute("waist", waist.intValue());
        	
         	request.setAttribute("validaciones", validaciones);
        	
   		    log.log(Level.FINE, "Processing GET request:  "+ "El usuario " + username + " fue registrado incorrectamente.");
   		    
            request.getRequestDispatcher("/Registro.jsp").forward(request, response);
        }
        
        User user = singelton.addUser(username, email, password, retype, age, height, weight, hip, waist);

        session.setAttribute("user", user);
        
	    log.log(Level.FINE, "Processing GET request:  "+ "El usuario " + username + " fue registrado correctamente.");

        request.getRequestDispatcher("/intro2.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
       
    }
}
