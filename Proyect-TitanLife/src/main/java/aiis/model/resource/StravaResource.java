package aiis.model.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.Logger;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import aiss.model.strava.StravaActivity;
import aiss.model.strava.StravaToken;


public class StravaResource {
		
		private static final Logger log = Logger.getLogger(StravaResource.class.getName());

	    private final String access_token;
	    
	    public StravaResource(String access_token) {
	        this.access_token = access_token;
	    }	    
	    public boolean postStravaRoute(String name,String type, Date start_local_date
	    		, Integer elapsed_time, String description, Float distance,String Stravatoken) {
	    	String url="https://www.strava.com/api/v3/activities"+"?name="+name+"&type="+type+"&start_date_local="+start_local_date
	    			+"&elapsed_time="+elapsed_time+"&description="+description+"&distance="+distance;
	        boolean res=false;
            ClientResource cr = new ClientResource(url);
            ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
            chr.setRawValue(Stravatoken);
            cr.setChallengeResponse(chr);

	    	 try {
	    		cr.post("",StravaActivity.class);
	    		
	         } catch (ResourceException re) {
	             String status = cr.getStatus().toString();
	             if(status.contains("201")) 
	            	 res=true;	             	 
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
	    		log.warning("Error when search Youtube videos: " + cr.getResponse().getStatus());
	            log.warning(url);
	    	}
	    	return st;
	    }
	    public static Date fromISO8601UTC(String dateStr) {
	    	  TimeZone tz = TimeZone.getTimeZone("UTC");
	    	  DateFormat df = new SimpleDateFormat("HH:mm:ss");
	    	  df.setTimeZone(tz);
	    	  
	    	  try {
	    	    return df.parse(dateStr);
	    	  } catch (ParseException e) {
	    	    e.printStackTrace();
	    	  }
	    	  
	    	  return null;
	    	}
	    
  	  @SuppressWarnings("unchecked")
	    public static void addHeader(ClientResource cr, String headerName, String headerValue) {
			Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes().get(HeaderConstants.ATTRIBUTE_HEADERS);

	    	  if (headers == null) {
	    	    headers = new Series<Header>(Header.class);
	    	   cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
	    	  }
	    	    headers.add(headerName, headerValue);
	    	}
	public String getAccess_token() {
		return access_token;
	}
	    
}