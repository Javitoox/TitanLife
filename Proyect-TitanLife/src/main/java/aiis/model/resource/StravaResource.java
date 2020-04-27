package aiis.model.resource;

import java.util.Date;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.strava.StravaActivity;


public class StravaResource {
		
		private static final Logger log = Logger.getLogger(StravaResource.class.getName());

	    private final String access_token;
	    //private final String uri = "https://www.googleapis.com/youtube/v3";
	    private final String uriSearch = "https://www.strava.com/api/v3/activities";
	    
	    public StravaResource(String access_token) {
	        this.access_token = access_token;
	    }
	    
	    public boolean postStravaRoute(String name,String type, Date start_local_date
	    		, Integer elapsed_time, String description, Float distance, Integer trainer, Integer commute) {
	    	String url=uriSearch+"?name="+name+"&type="+type+"&start_date_local="+start_local_date
	    			+"&elapsed_time="+elapsed_time
	    		+"&description="+description+"&distance="+distance+"&trainer="+trainer+"&commute="+commute;
	    	ClientResource cr = new ClientResource(url);
	    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	        boolean res=true;
	    	try {
	    	 cr.post(StravaActivity.class);
	    	}
	    	catch(ResourceException re) {
	    		log.warning("Error when search Youtube videos: " + cr.getResponse().getStatus());
	            log.warning(url);
	            res=false;
	    	}
	    	return res;
	    }
	    
	}



