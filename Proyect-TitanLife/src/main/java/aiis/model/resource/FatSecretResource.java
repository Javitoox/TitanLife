package aiis.model.resource;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class FatSecretResource {
	
	private static final Logger log = Logger.getLogger(FatSecretResource.class.getName());
	
	public static void authv1(String uri) {
		ClientResource cr = new ClientResource(uri);
		try {
    		cr.post("");
    		log.info("Obtaining Request Token of FastSecret..."+uri);
    	}
    	catch(ResourceException re) {
    		log.warning("Error obtaining a Request Token of FastSecret: " + cr.getResponse().getStatus());
    		log.warning(uri);
    	}
	}
}
