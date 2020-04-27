package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FatSecretCaloriesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(FatSecretCaloriesController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oauth_token = (String) request.getSession().getAttribute("FatSecret-token");
		String oauth_token_secret = (String) request.getSession().getAttribute("FatSecret-token-secret");
		if(oauth_token !=null && oauth_token_secret!=null && !oauth_token.equals("") && !oauth_token_secret.equals("")) {
			
		}else {
			log.info("Trying to access FatSecret without an access token, redirecting to OAuth servlet");
            request.getRequestDispatcher("/oauth1Controller/FatSecret").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
