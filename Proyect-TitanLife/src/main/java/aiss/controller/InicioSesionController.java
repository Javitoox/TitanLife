package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.User;
import aiss.model.repository.UserRepository;

public class InicioSesionController extends HttpServlet{
    private static final long serialVersionUID = 1L;

//  private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());

  public InicioSesionController() {
      super();
      // TODO Auto-generated constructor stub
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      // TODO: Read request parameters
      String username =request.getParameter("Username");
      String password =request.getParameter("Password");
     
      List<String> validaciones = new ArrayList<>();
//      HttpSession session = request.getSession();
    

      UserRepository singelton = UserRepository.getInstance();
      Map<String, User> users = singelton.getUsers();
      
      if(!users.containsKey(username)) {
      	validaciones.add("Usuario no existente");
     }
      
      if(!users.get(username).getPassword().equals(password)) {
    	  validaciones.add("El usuario y contraseña no coinciden");
      }
     

      if(!validaciones.isEmpty()) {
      	request.setAttribute("validaciones", validaciones);
          request.getRequestDispatcher("/InicioSesion.jsp").forward(request, response);
      }

      request.getRequestDispatcher("/intro2.jsp").forward(request, response);
      

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
     
  }
}
