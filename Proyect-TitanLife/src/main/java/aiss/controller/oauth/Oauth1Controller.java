package aiss.controller.oauth;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiis.model.resource.FatSecretResource;
import aiss.controller.YoutubeVideosController;
import aiss.utility.Oauth1Utility;

/**
 * Servlet implementation class Oauth1Controller
 */
public class Oauth1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Oauth1Controller.class.getName());
	private final String tokenURL="https://www.fatsecret.com/oauth/request_token";
	private final String key="6f5db4f8911e45adb1fdc22b4a879d9b";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oauth_token;
		String oauth_token_secret;
		String oauth_callback_confirmed;
		
		FatSecretResource.authv1();
		
		oauth_token=request.getParameter("oauth_token");
		oauth_token_secret=request.getParameter("oauth_token_secret");
		oauth_callback_confirmed=request.getParameter("oauth_callback_confirmed");
		
		if(oauth_callback_confirmed.equals("true")) {
			request.getRequestDispatcher("/misComidas.jsp?session=1").forward(request, response);
		}else {
			log.warning("Request Token for FastSecret not found, redirecting to error page");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
