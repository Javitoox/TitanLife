package aiss.controller;

import java.io.IOException;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.repository.UserRepository;
import aiss.model.titan.User;

public class InicioSesionController extends HttpServlet{
    private static final long serialVersionUID = 1L;

  private static final Logger log = Logger.getLogger(InicioSesionController.class.getName());

  public InicioSesionController() {
      super();
      // TODO Auto-generated constructor stub
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // TODO: Read request parameters
      String username =request.getParameter("Username");
      String password =request.getParameter("Password");
    
      String validaciones = "";
      HttpSession session = request.getSession(true);
      UserRepository singelton = UserRepository.getInstance();
      Map<Integer, User> users = singelton.getUsers();
      
      if(!users.containsKey(username)) {
    	  validaciones += "Usuario no existente";
     }
      
      else if(!users.get(username).getPassword().equals(password)) {
    	  validaciones += "El usuario y contraseña no coinciden";
      }
     

      if(!validaciones.equals("")) {
    	  
    	request.setAttribute("username", username);
      	request.setAttribute("password", password); 
      	request.setAttribute("validaciones", validaciones);
	    log.log(Level.FINE, "Processing GET request:  "+ "El usuario " + username + " fue loggeado incorrectamente.");
        request.getRequestDispatcher("/InicioSesion.jsp").forward(request, response);
        
      }else {
    	  
    	  User user= singelton.getUser(0);
          
          session.setAttribute("user", user);
          
          log.log(Level.FINE, "Processing GET request:  "+ "El usuario " + username + " fue loggeado correctamente.");

          request.getRequestDispatcher("/intro2.jsp").forward(request, response);  
          
      }

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
     
  }
}
