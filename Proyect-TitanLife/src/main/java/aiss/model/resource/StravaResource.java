package aiss.model.resource;



import java.util.Date;

import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.strava.StravaActivity;
import aiss.model.strava.StravaActivityC;
import aiss.model.strava.StravaActivityG;
import aiss.model.strava.StravaToken;

public class StravaResource {
		
		private static final Logger log = Logger.getLogger(StravaResource.class.getName());

	    private final String access_token;
	    
	    public StravaResource(String access_token) {
	        this.access_token = access_token;
	    }	    
	    public StravaActivity postStravaRoute(String name,String type, Date start_local_date
	    		, Integer elapsed_time, String description, Float distance,String ac) {
	    	String url="https://www.strava.com/api/v3/activities"+"?name="+name+"&type="+type+"&start_date_local="+start_local_date
	    			+"&elapsed_time="+elapsed_time+"&description="+description+"&distance="+distance;
	    	StravaActivity res=new StravaActivity();
            ClientResource cr = new ClientResource(url);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(access_token);
            cr.setChallengeResponse(chr);

	    	 try {
	    		res= cr.post("",StravaActivity.class);
	    		 
	         } catch (ResourceException re) {
	             String status = cr.getStatus().toString();
	             if(status.contains("201")) 
	            	 res=cr.post("",StravaActivity.class);
	             log.warning("Status: "+cr.getStatus());
	         }
	    	return res;
	    }
	    public static StravaToken primer(String code) {
	    	String url="https://www.strava.com/oauth/token?client_id=46775&client_secret=0c7ac138b754e1af780c376faaa6c0ada549553c&code="+code+"&grant_type=authorization_code";
	    	ClientResource cr = new ClientResource(url);
	    	StravaToken st= new StravaToken();
	    	try {
		    	 st= cr.post("", StravaToken.class);
	    	}
	    	catch(ResourceException re) {
	    		log.warning("Error strava token: " + cr.getResponse().getStatus());
		    	 st= cr.post("", StravaToken.class);

	            log.warning(url);
	    	}
	    	return st;
	    }
	    
	    public StravaActivityG[] getStravaActivity() {
	    	String url="https://www.strava.com/api/v3/athlete/activities?per_page=30";
	    	ClientResource cr = new ClientResource(url);
	    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	        
	    	StravaActivityG[] yv = null;
	    	try {
	    		yv = cr.get(StravaActivityG[].class);
	    	}
	    	catch(ResourceException re) {
	    		 String status = cr.getStatus().toString();
	             if(status.contains("200"))
	            	 yv= cr.get(StravaActivityG[].class);
	    		log.warning("Error getting activities: " + cr.getResponse().getStatus());
	            log.warning(url);
	    	}
	    	return yv;
	    }
	    public StravaActivityC getStravaActivityC(String id) {
	    	String url="https://www.strava.com/api/v3/activities/"+id;
	    	ClientResource cr = new ClientResource(url);
	    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	        
	    	StravaActivityC yv = null;
	    	try {
	    		yv = cr.get(StravaActivityC.class);
	    	}
	    	catch(ResourceException re) {
	    		 String status = cr.getStatus().toString();
	             if(status.contains("200"))
	            	 yv= cr.get(StravaActivityC.class);
	    		log.warning("Error getting activity: " + cr.getResponse().getStatus());
	            log.warning(url);
	    	}
	    	return yv;
	    }
	    public StravaActivityC uploadStravaActivityC(String id,StravaActivity sa) {
	    	String url="https://www.strava.com/api/v3/activities/"+id+"?name="+sa.getName()+"&type="+sa.getType()+"&start_date_local="+sa.getStartDateLocal()
	    			+"&elapsed_time="+sa.getElapsedTime()+"&description="+sa.getDescription()+"&distance="+sa.getDistance();
	    	StravaActivityC res=new StravaActivityC();

	    	ClientResource cr = new ClientResource(url);
	    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	        
	    	try {
	    		res=cr.put("",StravaActivityC.class);
	    	}
	    	catch(ResourceException re) {
	    		 String status = cr.getStatus().toString();
	    		 log.info(status);
	             if(status.contains("200"))
	 	    		cr.put("",StravaActivityC.class);
	             	res=cr.put("",StravaActivityC.class);
	    		log.warning("Error uploading activity: " + cr.getResponse().getStatus());
	            log.warning(url);
	    	}
	    	return res;
	    }
	    	    
	public String getAccess_token() {
		return access_token;
	}
	    
}