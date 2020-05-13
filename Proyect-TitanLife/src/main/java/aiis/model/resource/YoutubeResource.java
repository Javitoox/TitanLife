package aiis.model.resource;

import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.InsertVideo;
import aiss.model.youtube.PlayListNew;
import aiss.model.youtube.PlayListsResult;
import aiss.model.youtube.ResourceIdInsert;
import aiss.model.youtube.Snippet2;
import aiss.model.youtube.SnippetInsert;
import aiss.model.youtube.VideosPlayListResult;
import aiss.model.youtube.YoutubeVideo;

public class YoutubeResource {
	
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());

    private final String access_token;
    private final String uriPlayList = "https://www.googleapis.com/youtube/v3/playlists";
    private final String uriSearch = "https://www.googleapis.com/youtube/v3/search";
    private final String uriPlayListItems = "https://www.googleapis.com/youtube/v3/playlistItems";
    
    public YoutubeResource(String access_token) {
        this.access_token = access_token;
    }
    
    public YoutubeVideo getSearchVideos(String search) {
    	String url=uriSearch+"?part=id&maxResults=35&type=video&q="+search;
    	ClientResource cr = new ClientResource(url);
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        
    	YoutubeVideo yv = null;
    	try {
    		yv = cr.get(YoutubeVideo.class);
    	}
    	catch(ResourceException re) {
    		log.warning("Error when search Youtube videos: " + cr.getResponse().getStatus());
            log.warning(url);
    	}
    	return yv;
    }
    
    public PlayListsResult getPlayLists() {
    	String url = uriPlayList+"?part=snippet&mine=true";
    	ClientResource cr = new ClientResource(url);
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        
        PlayListsResult pr = null;
        try {
        	pr=cr.get(PlayListsResult.class);
        }catch(ResourceException re) {
        	log.warning("Error when search Youtube playlists: "+cr.getResponse().getStatus());
        	log.warning(url);
        }
    	return pr;
    }
    
    public Boolean createPlayListTitanLife() {
    	String url=uriPlayList+"?part=snippet";
    	ClientResource cr = new ClientResource(url);
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        
        PlayListNew pn = new PlayListNew();
        Snippet2 sn = new Snippet2();
        sn.setTitle("TitanLife");
        sn.setDescription("Playlist in which the user can add their favorite videos");
        pn.setSnippet(sn);
        log.info("Creating TitanLife playlist...");
       
        try {
        	cr.post(pn, MediaType.APPLICATION_ALL_JSON);
        	return true;
        }catch(ResourceException re) {
        	log.warning("Error creating TitanLife playlist: "+cr.getResponse().getStatus());
        	log.warning(url);
        	return false;
        }
    }
    
    public VideosPlayListResult getVideosOfPlayList(String playlistId) {
    	String url=uriPlayListItems+"?part=snippet&playlistId="+playlistId;
    	ClientResource cr = new ClientResource(url);
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        
        VideosPlayListResult vp = null;
        try {
        	vp = cr.get(VideosPlayListResult.class);
        }catch(ResourceException re) {
        	log.warning("Error listing videos of a playlist with id "+playlistId+": "+cr.getResponse().getStatus());
        	log.warning(url);
        }
        return vp;
    }
    
    public Boolean insertVideoInPlaylist(String playlistId, String videoId) {
    	String url=uriPlayListItems+"?part=snippet";
    	ClientResource cr = new ClientResource(url);
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        
        InsertVideo iv=new InsertVideo();
        SnippetInsert si=new SnippetInsert();
        ResourceIdInsert ri=new ResourceIdInsert();
        ri.setVideoId(videoId);
        ri.setKind("youtube#video");
        si.setResourceId(ri);
        si.setPlaylistId(playlistId);
        iv.setSnippet(si);
        log.info("Inserting video...");
        try {
        	log.info("Video: "+videoId+" ; Playlist: "+playlistId);
        	cr.post(iv, MediaType.APPLICATION_ALL_JSON);
        	return true;
        }catch(ResourceException re) {
        	log.warning("Error inserting video in TitanLife playlist: "+cr.getResponse().getStatus());
        	log.warning(url);
        	return false;
        }
    }
    
    public Boolean deletVideoInPlaylist(String id) {
    	String url=uriPlayListItems+"?id="+id;
    	ClientResource cr = new ClientResource(url);
    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
        chr.setRawValue(access_token);
        cr.setChallengeResponse(chr);
        
        log.info("Deleting video...");
        try {
        	cr.delete(MediaType.APPLICATION_ALL_JSON);
        	return true;
        }catch(ResourceException re) {
        	log.warning("Error deleting video in TitanLife playlist: "+cr.getResponse().getStatus());
        	log.warning(url);
        	return false;
        }
    }
    
}
