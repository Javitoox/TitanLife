package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiis.model.resource.YoutubeResource;
import aiss.model.youtube.YoutubeVideo;

public class YoutubeVideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(YoutubeVideosController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Llamada a la api de prueba, más tarde tendremos que implementar su funcionalidad con objetivos y demás
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		if (accessToken != null && !"".equals(accessToken)) {
			YoutubeResource yr=new YoutubeResource(accessToken);
			//Próximamente controlaremos la realización de búsquedas mediante los objetivos del usuario
			YoutubeVideo yv=yr.getSearchVideos("Ejercicios calistenia");
			if(yv !=null && yv.getItems().size()>0) {
				request.setAttribute("videos", yv.getItems());
				request.getRequestDispatcher("/videos.jsp").forward(request, response);
			}else {
				log.warning("Videos not found, redirecting to initial page");
				request.getRequestDispatcher("/conexionController").forward(request, response);
			}
        }else {
        	log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
            request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
