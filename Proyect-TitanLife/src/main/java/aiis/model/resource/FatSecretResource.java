package aiis.model.resource;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.utility.Oauth1Utility;

public class FatSecretResource {
	
	private static final Logger log = Logger.getLogger(FatSecretResource.class.getName());
	
	public static void authv1() throws InvalidKeyException, NoSuchAlgorithmException, 
	UnsupportedEncodingException, URISyntaxException {
		String uri = Oauth1Utility.generateRequest();
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
