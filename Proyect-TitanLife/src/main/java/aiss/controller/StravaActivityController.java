package aiss.controller;

import java.io.IOException;

import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import aiis.model.resource.StravaResource;
import aiss.model.strava.StravaToken;


public class StravaActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StravaActivityController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");		
		if (code != null && !"".equals(code)) {
        	log.info(code);
			String accessToken = (String) request.getSession().getAttribute("Strava-token");			
			if (accessToken != null && !"".equals(accessToken)) {
				request.getRequestDispatcher("/strava.jsp").forward(request, response);
	        }else {
	        	log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
	        	StravaToken st= StravaResource.primer(code);
	        	String acesstoken = st.getAccessToken();
	        	request.getSession().setAttribute("Strava-token", acesstoken);
	        	log.info("Accestoken: "+acesstoken);
	        	request.getRequestDispatcher("/stravaActivityController").forward(request, response);
	        }
        }else {
        	log.info("Acces without code");
    		response.sendRedirect("http://www.strava.com/oauth/authorize?client_id=46775&response_type=code&redirect_uri=https://titanlife.appspot.com/stravaActivityController&approval_prompt=force&scope=activity:write");
        	code=request.getParameter("code");
        	request.getSession().setAttribute("code", code);
        }
    }	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
