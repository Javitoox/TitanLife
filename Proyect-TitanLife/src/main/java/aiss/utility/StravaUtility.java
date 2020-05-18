package aiss.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import aiss.model.strava.StravaActivityC;

public class StravaUtility {
	
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
	public static  String fromISOtoString(String r) {
    	String[] s = r.split("T");
    	String[] s1 = s[1].split("Z");
    	String[] s2 = s1[0].split(":");
    	Integer s3 = Integer.valueOf(s2[0])-1;
    	String s4 = (s3.toString()+":"+s2[1]+":"+s2[2]).trim();
	return s4;
    }
	public static String max(List<StravaActivityC> ls) {
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

}
