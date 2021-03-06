package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConexionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(ConexionController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("sesion")!=null && request.getParameter("sesion").equals("0")) {
			log.info("Desconexión del usuario: "+request.getSession().getAttribute("username"));
			request.getSession().invalidate();
		}
			
		if(request.getSession().getAttribute("username")!=null) {
			request.getRequestDispatcher("intro.jsp?sesion=1").forward(request, response);
		}else {
			request.getRequestDispatcher("intro.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
