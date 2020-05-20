package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiis.model.resource.YoutubeResource;
import aiss.model.repository.UserRepository;
import aiss.model.titan.User;
import aiss.model.youtube.Item4;
import aiss.model.youtube.VideosPlayListResult;

public class SetDeleteYoutubeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(SetDeleteYoutubeController.class.getName());
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u=UserRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		if(u==null) {
			request.getRequestDispatcher("/intro.jsp").forward(request, response);
		}else {
		
			String videoPrincipal=request.getParameter("videoPrincipal");
			String playlistTitanLifeId=request.getParameter("playlistTitanLifeId");
			String idVideoPlaylist=request.getParameter("idVideoPlaylist");
			String boton=request.getParameter("boton");
			
			String accessToken = (String) request.getSession().getAttribute("Youtube-token");
			YoutubeResource yr=new YoutubeResource(accessToken);
			
			if (accessToken != null && !"".equals(accessToken)) {
				if(boton!=null && boton.equals("Añadir a la playlist TitanLife")) {
					Boolean result=yr.insertVideoInPlaylist(playlistTitanLifeId, videoPrincipal);
					if(result) {
						log.info("Video inserted in the playlist: "+videoPrincipal);
						request.setAttribute("videoPrincipalEnPlaylist", "1");
					}
					else
						request.getRequestDispatcher("/error.jsp").forward(request, response);
				}else if(boton!=null && boton.equals("Eliminar de la playlist TitanLife")) {
					if(idVideoPlaylist==null || idVideoPlaylist.equals("")) {
						//Ocurrirá en caso de añadir y eliminar sucesivamente
						log.info("Id playlist in delete: "+playlistTitanLifeId);
						VideosPlayListResult vp=yr.getVideosOfPlayList(playlistTitanLifeId);
						log.info("Comprueba items: "+vp.getItems());
						if(vp!=null && vp.getItems().size()>=0) {
							log.info("Searching videos in playlist for the user "+u.getUsername());
							log.info("Video principal in delete: "+videoPrincipal);
							for(Item4 item:vp.getItems()) {
								log.info("Id video: "+item.getSnippet().getResourceId().getVideoId());
								if(item.getSnippet().getResourceId().getVideoId().equals(videoPrincipal)) {
									idVideoPlaylist=item.getId();
									break;
								}
							}
						}
					}
					if(idVideoPlaylist!=null && !idVideoPlaylist.equals("")) {
						Boolean result=yr.deletVideoInPlaylist(idVideoPlaylist);
						if(result) {
							log.info("Video deleted in the playlist: "+videoPrincipal);
							request.setAttribute("videoPrincipalEnPlaylist", "0");
						}
						else {
							log.info("Video not deleted in the playlist: "+videoPrincipal);
							request.setAttribute("videoPrincipalEnPlaylist", "1");
						}
					}else {
						log.info("Video not deleted in the playlist: "+videoPrincipal);
						request.setAttribute("videoPrincipalEnPlaylist", "1");
					}
				    }
				request.getRequestDispatcher("/youtubeVideosController").forward(request, response);
			}else {
	        	log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
	            request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
