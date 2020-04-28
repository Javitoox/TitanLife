package aiis.model.resource;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.utility.Oauth1Utility;

public class FatSecretResource {
	
	private static final Logger log = Logger.getLogger(FatSecretResource.class.getName());
	private final static String tokenURL = "https://www.fatsecret.com/oauth/request_token";
	
	public static void authv1() {
		String[] p=Oauth1Utility.generateOauthParams();
		String params=Oauth1Utility.paramify(p);
		String sign="";
		try {
			sign = "oauth_signature="+Oauth1Utility.sign("GET", tokenURL, p);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String uri=tokenURL+"?"+params+"&"+sign;
		ClientResource cr = new ClientResource(uri);
		try {
			log.info("Obtaining Request Token of FastSecret... Uri:"+uri);
    		cr.get();
    	}
    	catch(ResourceException re) {
    		log.warning("Error obtaining a Request Token of FastSecret: " + cr.getResponse().getStatus());
    		log.warning("Uri:"+uri);
    	}
	}
}
