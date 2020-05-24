package aiss.controller;

import java.io.IOException;
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
import aiss.utility.StravaUtility;

public class StravaUpdateActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StravaUpdateActivityController.class.getName());
   
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
			String newname = request.getParameter("NewName");
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
				int i =0;
				String id=null;
				while(i<u.getActividades().size()) {
					
					if(name.equals(u.getActividades().get(i).getName())) {
						id=String.valueOf(u.getActividades().get(i).getId());
					}
					i++;
				
				}
				
			
				StravaActivity saa = new StravaActivity();
				
				saa.setName(newname);
				saa.setType(type);
				saa.setElapsedTime(Integer.valueOf(elapsed));
				saa.setDescription(description);
				saa.setDistance(Integer.valueOf(distance));
				saa.setStartDateLocal(String.valueOf(d));
					
				
				StravaActivityC yv=yr.uploadStravaActivityC(id,saa);
				
			if(yv==null) {
				log.warning("Error obtaining strava route");
	
				
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}else {
				StravaActivityG[] sag=yr.getStravaActivity();
				List<StravaActivityC> san= new ArrayList<>();
				for(StravaActivityG sa: sag) {
					san.add(yr.getStravaActivityC(sa.getId().toString()));
				}
				for(StravaActivityC st :san) {
					st.setStartDateLocal(StravaUtility.fromISOtoString(st.getStartDateLocal()));					
				}
				log.info("Strava route created succesfully");
				
				u.setActividades(san);
	
				String res=StravaUtility.max(u.getActividades());
				log.info("Max"+res);
				request.setAttribute("res", res);
				request.getRequestDispatcher("/strava.jsp").forward(request, response);
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
