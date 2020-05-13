package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiis.model.resource.YoutubeResource;
import aiss.model.repository.UserRepository;
import aiss.model.titan.Objetivo;
import aiss.model.titan.User;
import aiss.model.youtube.Item2;
import aiss.model.youtube.Item4;
import aiss.model.youtube.PlayListsResult;
import aiss.model.youtube.VideosPlayListResult;
import aiss.model.youtube.YoutubeVideo;

public class YoutubeVideosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(YoutubeVideosController.class.getName());

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accessToken = (String) request.getSession().getAttribute("Youtube-token");
		User u=UserRepository.getInstance().findByUsername((String)request.getSession().getAttribute("username"));
		if(u.getObjetivos()!=null && u.getObjetivos().size()>0) {
			if (accessToken != null && !"".equals(accessToken)) {
				log.info("Youtube-token: "+accessToken);
				YoutubeResource yr=new YoutubeResource(accessToken);
				PlayListsResult pr=yr.getPlayLists();
				Boolean existePlayList = false;
				String playlistTitanLifeId="";
				//Comprobación de existencia de la playlist de TitanLife y creación de la misma en caso de que no exista
				if(pr!=null) {
					log.info("PlayLists search succes, checking TitanLife playList... "+pr);
					for(Item2 item: pr.getItems()) {
						if(item.getSnippet().getTitle().equals("TitanLife")) {
							existePlayList = true;
							playlistTitanLifeId=item.getId();
							log.info("Playlist id found");
							break;
						}
					}
					if(!existePlayList) {
						Boolean result=yr.createPlayListTitanLife();
						if(result) {
							log.info("TitanLife playlist create");
							for(Item2 item: pr.getItems()) {
								if(item.getSnippet().getTitle().equals("TitanLife")) {
									playlistTitanLifeId=item.getId();
									log.info("Playlist id found for first time");
									break;
								}
							}
						}
						else
							request.getRequestDispatcher("/error.jsp").forward(request, response);
					}else
						log.info("TitanLife playlist exists with the user "+u.getUsername());
						
				}else {
					log.warning("Playlists not found, redirecting error page");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
				
				//Búsqueda personalizada según los objetivos del usuario
				List<Objetivo> objetivos=u.getObjetivos();
				List<Objetivo> copia=new ArrayList<>(objetivos);
				Collections.shuffle(copia);
				YoutubeVideo yv=yr.getSearchVideos(copia.get(0).getNombre());
				if(yv !=null && yv.getItems().size()>0) {
					String videoPrincipal=request.getParameter("videoPrincipal");
					log.info("Video principal: "+videoPrincipal);
					//Comprobamos si el usuario a elegido un video y lo mostramos en el formato de video
					if(videoPrincipal!=null && !videoPrincipal.equals("")) {
						VideosPlayListResult vp=yr.getVideosOfPlayList(playlistTitanLifeId);
						log.info("Comprueba items: "+vp.getItems());
						if(vp!=null && vp.getItems().size()>=0) {
							log.info("Searching videos in playlist for the user "+u.getUsername());
							String videoPrincipalEnPlaylist="0";
							String controlVideo=(String)request.getAttribute("videoPrincipalEnPlaylist");
							log.info("Control video: "+controlVideo);
							if(controlVideo!=null && !controlVideo.equals(""))
								videoPrincipalEnPlaylist=controlVideo;
							else {
								for(Item4 item:vp.getItems()) {
									if(item.getSnippet().getResourceId().getVideoId().equals(videoPrincipal)) {
										videoPrincipalEnPlaylist="1";
										request.setAttribute("idVideoPlaylist", item.getId());
										break;
									}
								}
							}
							log.info("Principal Video in playlist: "+videoPrincipalEnPlaylist);
							//Aquí sabemos ya si el video elegido está en la playlist o no
							request.setAttribute("videoPrincipalEnPlaylist", videoPrincipalEnPlaylist);
							request.setAttribute("playlistTitanLifeId", playlistTitanLifeId);
							request.setAttribute("videoPrincipal", videoPrincipal);
						}else {
							log.warning("Error in principal video");
							request.getRequestDispatcher("/error.jsp").forward(request, response);
						}
					}
					request.setAttribute("videos", yv.getItems());
					log.info("Videos cargados a la vista");
					request.getRequestDispatcher("/videos.jsp").forward(request, response);
				}else {
					log.warning("Videos not found, redirecting error page");
					request.getRequestDispatcher("/error.jsp").forward(request, response);
				}
	        }else {
	        	log.info("Trying to access Youtube without an access token, redirecting to OAuth servlet");
	            request.getRequestDispatcher("/AuthController/Youtube").forward(request, response);
	        }
		}else {
			log.info("No objetives for the user "+u.getUsername());
			request.setAttribute("mensajeYoutube", "Antes de acceder a Youtube debe seleccionar sus objetivos deportivos");
			request.getRequestDispatcher("objetivos.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
