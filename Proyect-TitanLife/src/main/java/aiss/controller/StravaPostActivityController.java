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


import aiis.model.resource.StravaResource;
import aiss.model.repository.UserRepository;

import aiss.model.strava.StravaActivityC;
import aiss.model.strava.StravaActivityG;
import aiss.model.titan.User;


public class StravaPostActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StravaPostActivityController.class.getName());
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u=UserRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));

		String accessToken = (String) request.getSession().getAttribute("Strava-token");			
		StravaResource yr=new StravaResource(accessToken);
		String name = request.getParameter("Name");
		String type = request.getParameter("Type");
		String elapsed = request.getParameter("Elapsed");
		String description = request.getParameter("Description");
		String distance = request.getParameter("Distance");
		Date d = StravaResource.fromISO8601UTC();
		
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

		boolean yv=yr.postStravaRoute(name, type, d, Integer.valueOf(elapsed), description, Float.parseFloat(distance),accessToken);
		
		if(yv==true) {
			log.info("Strava route created succesfully");
			StravaActivityG[] sag=yr.getStravaActivity();
			
			List<StravaActivityC> san= new ArrayList<>();

			for(Integer i =0;i<sag.length;i++) {	
				if(i.equals(0)) {
					log.info("El sag"+sag[i].getName());
				}

				san.add(yr.getStravaActivityC(sag[i].getId().toString()));
			}
			
			for(StravaActivityC st :san) {
				st.setStartDateLocal(yr.fromISOtoString(st.getStartDateLocal()));					
			}

			
			u.setActividades(san);
			String res=yr.max(u.getActividades());
			log.info("Max"+res);
			request.setAttribute("res", res);
			request.getRequestDispatcher("/strava.jsp").forward(request, response);
		}else {
			log.warning("Error obtaining strava route");
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}