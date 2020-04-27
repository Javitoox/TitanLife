package aiis.model.resource;

import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.youtube.YoutubeVideo;

public class YoutubeResource {
	
	private static final Logger log = Logger.getLogger(YoutubeResource.class.getName());

    private final String access_token;
    //private final String uri = "https://www.googleapis.com/youtube/v3";
    private final String uriSearch = "https://www.googleapis.com/youtube/v3/search";
    
    public YoutubeResource(String access_token) {
        this.access_token = access_token;
    }
    
    public YoutubeVideo getSearchVideos(String search) {
    	String url=uriSearch+"?part=id&order=date&maxResults=20&type=video&q="+search;
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
    
}
