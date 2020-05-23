package aiss.controller.oauth;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resource.FatSecretResource;

/**
 * Servlet implementation class Oauth1Controller
 */
public class Oauth1Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(Oauth1Controller.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oauth_token;
		String oauth_token_secret;
		String oauth_callback_confirmed;
		
	    try {
			FatSecretResource.authv1();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
