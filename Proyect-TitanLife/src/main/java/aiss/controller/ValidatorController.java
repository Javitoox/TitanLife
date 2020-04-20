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
        Double height =Double.valueOf(request.getParameter("Height"));
        Double weight =Double.valueOf(request.getParameter("Weight"));
        Double hip =Double.valueOf(request.getParameter("Hip"));
        Double waist =Double.valueOf(request.getParameter("Waist"));
        
        //List<String> validaciones = new ArrayList<>();
        String validaciones = "";
        HttpSession session = request.getSession(true);
        String userRegexp = "^[a-zA-Z0-9_-]{3,15}$";
        String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        String passwordRegexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";

        UserRepository singelton = UserRepository.getInstance();
        Map<String, User> users = singelton.getUsers();
        
        if(!Pattern.matches(userRegexp, username)) {
        	//validaciones.add("El nombre de usuario presenta un formato incorrecto.");
        	//validaciones += "El nombre de usuario presenta un formato incorrecto.";
        }
        
        if(users.containsKey(username)) {
        	//validaciones.add("Usuario ya existente");
        	validaciones += "Usuario ya existente";
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
        
        //if(!validaciones.isEmpty()) {
        if(!validaciones.equals("")) {
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
