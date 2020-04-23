package aiss.controller;

import java.io.IOException;

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

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //La sesión aquí siempre estará desconectada
	  if(request.getParameter("username")==null) {
		  request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
	  }else {
		  String username=request.getParameter("username");
		  String password=request.getParameter("password");
		  UserRepository repository=UserRepository.getInstance();
		  User u=repository.findByUsername(username);
		  if(u!=null && u.getPassword().equals(password)) {
			  HttpSession sesion=request.getSession(true);
			  sesion.setAttribute("user", u);
			  log.info("Usuario "+username+" logueado");
			  request.getRequestDispatcher("/conexionController?sesion=1").forward(request, response);
		  }else {
			  request.setAttribute("validaciones", "Usuario o contraseña no existentes");
			  request.setAttribute("username", username);
			  request.setAttribute("password", password);
			  request.getRequestDispatcher("inicioSesion.jsp").forward(request, response);
		  }
	  }

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
  }
}
