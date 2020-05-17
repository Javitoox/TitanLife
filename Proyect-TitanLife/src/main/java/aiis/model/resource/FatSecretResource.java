package aiis.model.resource;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import com.fatsecret.platform.model.CompactFood;
import com.fatsecret.platform.model.Food;
import com.fatsecret.platform.services.FatsecretService;
import com.fatsecret.platform.services.Response;

import aiss.utility.Oauth1Utility;

public class FatSecretResource {
	
	private static final Logger log = Logger.getLogger(FatSecretResource.class.getName());
	private static final String key = "6f5db4f8911e45adb1fdc22b4a879d9b";
	private static final String secret = "1fb3621313824e6ab2f9604be9f7fbff";
	
	public static List<CompactFood> searchFood(String query) {
		List<CompactFood> result = new ArrayList<>();
		FatsecretService service = new FatsecretService(key, secret);
		Response<CompactFood> response = service.searchFoods(query);
		if(response!=null) {
			log.info("Search food succes: "+query);
			result = response.getResults();
		}
		else
			log.warning("Not food results for: "+query);
		return result;
	}
	
	public static Food detaliedFood(Long id) {
		FatsecretService service = new FatsecretService(key, secret);
		Food result = service.getFood(id);
		if(result!=null)
			log.info("Succes food details for id: "+id);
		else
			log.warning("Error food details for id: "+id);
		return result;
	}
	
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
