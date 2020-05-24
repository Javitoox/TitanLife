package aiss.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.repository.TitanLifeRepository;
import aiss.model.resource.StravaResource;
import aiss.model.strava.StravaActivity;
import aiss.model.strava.StravaActivityC;
import aiss.model.strava.StravaActivityG;
import aiss.model.strava.StravaToken;
import aiss.model.titan.User;
import aiss.utility.CalculatorFatSecret;
import aiss.utility.StravaUtility;


public class StravaPostActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StravaPostActivityController.class.getName());
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = (String) request.getSession().getAttribute("code");

		User u=TitanLifeRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		if(u==null) {
			request.getRequestDispatcher("/intro.jsp").forward(request, response);
		}else {
			if (code != null && !"".equals(code)) {

			String accessToken = (String) request.getSession().getAttribute("Strava-token");

			if (accessToken != null && !"".equals(accessToken)) {

			StravaResource yr=new StravaResource(accessToken);
			String name = request.getParameter("Name");
			String type = request.getParameter("Type");
			String elapsed = request.getParameter("Elapsed");
			String description = request.getParameter("Description");
			String distance = request.getParameter("Distance");
			Date d = StravaUtility.fromISO8601UTC();
			
			String validaciones="";		
			
	        String nameRegexp = "^[a-zA-Z0-9_-]{3,40}$";
	        String elapsedRegexp = "^[0-9]{1,40}$";
	        String descriptionRegexp = "^[a-zA-Z0-9_-]{3,40}$";
	        String distanceRegexp = "^[0-9]{1,40}$";
	    
	        if(!Pattern.matches(nameRegexp, name.replace(" ", ""))) {
	        	validaciones+="Formato incorrecto del nombre";        	
	        }
	        if(!Pattern.matches(elapsedRegexp, elapsed)) {
	        	validaciones+="Formato incorrecto de el tiempo transcurrido";
	        }
	        if(!Pattern.matches(descriptionRegexp, description.replace(" ", ""))) {
	        	validaciones+="Formato incorrecto de la descripción";
	        }
	        if(!Pattern.matches(distanceRegexp, distance)) {
	        	validaciones+="Formato incorrecto de la distancia";
	        }
			if(validaciones!="") {
				request.setAttribute("validaciones", validaciones);
				request.getRequestDispatcher("/strava.jsp").forward(request, response);
		
			}else {
	
			StravaActivity yv=yr.postStravaRoute(name, type, d, Integer.valueOf(elapsed), description, Float.parseFloat(distance),accessToken);
			
			if(yv!=null) {
				log.info("Strava route created succesfully");
				StravaActivityG[] sag=yr.getStravaActivity();
				
				List<StravaActivityC> san= new ArrayList<>();
	
				for(Integer i =0;i<sag.length;i++) {	
					if(i.equals(0)) {
						log.info("El sag"+sag[i].getName());
					}
	
					san.add(yr.getStravaActivityC(sag[i].getId().toString()));
				}
				
				if(u.getBaseCaloriasDiarias()==null) {
					Integer c=CalculatorFatSecret.userBaseCalories(u)+san.get(0).getCalories().intValue();
					u.setBaseCaloriasDiarias(c);
					u.setCaloriasDiarias(c);
					u.setInstanteCalorias(LocalDate.now());
					u.setComidasDiarias(new ArrayList<String>());
				}
				u.setCaloriasDiarias(u.getCaloriasDiarias()+san.get(0).getCalories().intValue());
				log.info("Calories actualized with strava activiy: "+san.get(0).getName());
				
				for(StravaActivityC st :san) {
					st.setStartDateLocal(StravaUtility.fromISOtoString(st.getStartDateLocal()));					
				}
	
				
				u.setActividades(san);
				String res=StravaUtility.max(u.getActividades());
				log.info("Max"+res);
				request.setAttribute("res", res);
				request.getRequestDispatcher("/strava.jsp").forward(request, response);
			}else {
				log.warning("Error obtaining strava route");
				request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
			}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
