package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

//    private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());

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
        Integer height =Integer.valueOf(request.getParameter("Height"));
        Integer weight =Integer.valueOf(request.getParameter("Weight"));
        Integer hip =Integer.valueOf(request.getParameter("Hip"));
        Integer waist =Integer.valueOf(request.getParameter("Waist"));
        
        List<String> validaciones = new ArrayList<>();
//        HttpSession session = request.getSession();
        
//        String passwordRegexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

        
        String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
        String passwordRegexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";

        UserRepository singelton = UserRepository.getInstance();
        Map<String, User> users = singelton.getUsers();
        
        if(users.containsKey(username)) {
        	validaciones.add("Usuario ya existente");
       }
        
        if(!Pattern.matches(emailRegexp, email)) {
        	validaciones.add("Formato incorrecto del correo");
        }
        

        if(!Pattern.matches(passwordRegexp, password)) {
        	validaciones.add("La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. Debe contener 8 o más carácteres");

        }
//        validaciones="\n\n\n";

        if(!password.equals(retype)) {
        	validaciones.add("La contraseña no coincide con la confirmación");
        }
//        validaciones="\n\n\n";

        
        if(!validaciones.isEmpty()) {
        	request.setAttribute("validaciones", validaciones);
            request.getRequestDispatcher("/Registro.jsp").forward(request, response);
        }
// TODO: Create contact in the repository
        UserRepository.getInstance().addUser(username, email, password, retype, age, height, weight, hip, waist);


        // TODO: Forward to contact list view
        //request.setAttribute("message", "User created successfully");
        request.getRequestDispatcher("/intro.jsp").forward(request, response);
//        String s = request.getRequestedSessionId();
        

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
       
    }
}
