package aiss.utility;

import java.sql.Timestamp;
import java.util.UUID;

public class Oauth1Utility {
	
	public static String generateTimeStampt() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return String.valueOf(timestamp.getTime());
	}
	
	public static String generateRandomString() {
		String uuid = UUID.randomUUID().toString();
		return uuid;
	}
 
}
