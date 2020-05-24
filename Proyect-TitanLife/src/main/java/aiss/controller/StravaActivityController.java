package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.repository.TitanLifeRepository;
import aiss.model.resource.StravaResource;
import aiss.model.strava.StravaActivityC;
import aiss.model.strava.StravaActivityG;
import aiss.model.strava.StravaToken;
import aiss.model.titan.User;
import aiss.utility.StravaUtility;


public class StravaActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StravaActivityController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = (String) request.getSession().getAttribute("code");
		User u=TitanLifeRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		if(u==null) {
			request.getRequestDispatcher("/intro.jsp").forward(request, response);
		}else {

			if (code != null && !"".equals(code)) {
				
	        	log.info(code);
				String accessToken = (String) request.getSession().getAttribute("Strava-token");
				
				if (accessToken != null && !"".equals(accessToken)) {
					StravaResource yr=new StravaResource(accessToken);
					StravaActivityG[] sag=yr.getStravaActivity();
					List<StravaActivityC> san= new ArrayList<>();
					
					for(Integer i =0;i<sag.length;i++) {	
						if(i.equals(0)) {
							log.info("El sag ac"+sag[i].getName());
						}
						san.add(yr.getStravaActivityC(sag[i].getId().toString()));
					}
					for(StravaActivityC st :san) {
						st.setStartDateLocal(StravaUtility.fromISOtoString(st.getStartDateLocal()));					
					}
	
	
					u.setActividades(san);
					String res=StravaUtility.max(u.getActividades());
					log.info("Max"+res);
	
					request.setAttribute("res", res);
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
	    		response.sendRedirect("http://www.strava.com/oauth/authorize?client_id=46775&response_type=code&redirect_uri=https://titanlife.appspot.com/stravaActivityController&approval_prompt=force&scope=activity:read,activity:write");
	        	code=request.getParameter("code");
	        	request.getSession().setAttribute("code", code);
	        }
		}
    }	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
