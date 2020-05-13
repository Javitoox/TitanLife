package aiis.model.resource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
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
	    public static Date fromISO8601UTC() {
	    	String dateStr= String.valueOf(LocalDateTime.now());
	    	TimeZone tz = TimeZone.getTimeZone("Europe/Madrid");
	    	DateFormat df = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
	    	String[] r = dateStr.split("T");
	  		String h= r[0]+" "+r[1];
	  		String h2=h.replace(".", "T");
	  		String[] res= h2.split("T");
	    	  df.setTimeZone(tz);
	    	  
	    	  try {
	    	    return df.parse(res[0].trim());
	    	  } catch (ParseException e) {
	    	    e.printStackTrace();
	    	  }
	    	  
	    	  return null;
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
	    		log.warning("Error when search Youtube videos: " + cr.getResponse().getStatus());
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
	    		log.warning("Error when search Youtube videos: " + cr.getResponse().getStatus());
	            log.warning(url);
	    	}
	    	return yv;
	    }
	    public boolean uploadStravaActivityC(String id,String name,String type, Date start_local_date
	    		, Integer elapsed_time, String description, Float distance) {
	    	String url="https://www.strava.com/api/v3/activities/"+id+"?name="+name+"&type="+type+"&start_date_local="+start_local_date
	    			+"&elapsed_time="+elapsed_time+"&description="+description+"&distance="+distance;
	        boolean res=false;

	    	ClientResource cr = new ClientResource(url);
	    	ChallengeResponse chr = new ChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER);
	        chr.setRawValue(access_token);
	        cr.setChallengeResponse(chr);
	        
	    	try {
	    		cr.put("",StravaActivityC.class);
	    	}
	    	catch(ResourceException re) {
	    		 String status = cr.getStatus().toString();
	    		 log.info(status);
	             if(status.contains("200"))
	 	    		cr.put("",StravaActivityC.class);
	             	res=true;
	    		log.warning("Error when search Youtube videos: " + cr.getResponse().getStatus());
	            log.warning(url);
	    	}
	    	return res;
	    }
	    public  String fromISOtoString(String r) {
	    	String[] s = r.split("T");
	    	String[] s1 = s[1].split("Z");
	    	String[] s2 = s1[0].split(":");
	    	Integer s3 = Integer.valueOf(s2[0])-1;
	    	String s4 = (s3.toString()+":"+s2[1]+":"+s2[2]).trim();
		return s4;
	    }
	    public String max(List<StravaActivityC> ls) {
	    	List<String> ll = new ArrayList<>();
	    	ll.add("Ride");
	    	ll.add("Run");
			ll.add("Swim");
			ll.add("Hike");
			ll.add("Walk");
			ll.add("AlpineSki");
			ll.add("BackcountrySki");
			ll.add("Canoeing");
			ll.add("Crossfit");
			ll.add("EBikeRide");
			ll.add("Elliptical");
			ll.add("Handcycle");
			ll.add("IceSkate");
			ll.add("InlineSkate");
			ll.add("Kayaking");
			ll.add("Kitesurf");
			ll.add("NordicSki");
			ll.add("RockClimbing");
			ll.add("RollerSki");
			ll.add("Rowing");
			ll.add("Snowboard");
			ll.add("Snowshoe");
			ll.add("StairStepper");
			ll.add("StandUpPaddling");
			ll.add("Surfing");
			ll.add("Velomobile");
			ll.add("VirtualRide");
			ll.add("VirtualRun");
			ll.add("WeightTraining");
			ll.add("Wheelchair");
			ll.add("Windsurf");
			ll.add("Workout");
			ll.add("Yoga");
			
			int n =0;
			int res=0;
			String resi="";
			
			while(n<ll.size()) {
				int re=0;
				int w=0;
				while(w<ls.size()) {
					
					if(ll.get(n).equals(ls.get(w).getType().toString().trim())) {
						re++;
					}else {
						
					}
					if(re>res) {
						res=re;
						resi=String.valueOf(ll.get(n));
					}
					else {
						
					}		
										
					
					w++;
				}
				
				
				n++;
			}
			return resi;
	    }
	public String getAccess_token() {
		return access_token;
	}
	    
}