package aiss.controller;

import java.io.IOException;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import aiis.model.resource.StravaResource;


public class StravaActivityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(StravaActivityController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Llamada a la api de prueba, más tarde tendremos que implementar su funcionalidad con objetivos y demás
		String accessToken = (String) request.getSession().getAttribute("Strava-token");
		String name = request.getParameter("Name");
		String type = request.getParameter("Type");
		String date = request.getParameter("Date");
		String elapsed = request.getParameter("Elapsed");
		String description = request.getParameter("Description");
		String distance = request.getParameter("Distance");
		String trainer = request.getParameter("Trainer");
		String commute = request.getParameter("Commute");
		    TemporalAccessor ta = DateTimeFormatter.ISO_INSTANT.parse(date);
		    Instant i = Instant.from(ta);
		    Date d = Date.from(i);
		if (accessToken != null && !"".equals(accessToken)) {
			StravaResource yr=new StravaResource(accessToken);
			//Próximamente controlaremos la realización de búsquedas mediante los objetivos del usuario
//			Date.newBuilderForType("2018-06-24T09:54:13-07:00");
			boolean yv=yr.postStravaRoute(name, type, d, Integer.valueOf(elapsed), description, Float.parseFloat(distance), Integer.valueOf(trainer), Integer.valueOf(commute));
			if(yv==true) {
//					yv.getItems().size()>0) {
//				request.setAttribute("videos", yv.getItems());
				request.getRequestDispatcher("/strava.jsp").forward(request, response);
			}else {
				log.warning("Videos not found, redirecting to initial page");
				request.getRequestDispatcher("/conexionController").forward(request, response);
			}
        }else {
        	log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
            request.getRequestDispatcher("/AuthController/Strava").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
