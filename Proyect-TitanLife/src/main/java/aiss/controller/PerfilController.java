package aiss.controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aiss.model.repository.UserRepository;

public class PerfilController extends HttpServlet {
	 /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

	public PerfilController() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        // TODO: Read request parameters
	        
	        HttpSession session = request.getSession();
	        Object user = session.getAttribute("Username");
	        session.setAttribute("user", user);


	        

	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // TODO Auto-generated method stub
	        doGet(request, response);
	       
	    }
	}



