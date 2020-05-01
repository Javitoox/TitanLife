package aiis.model.resource;

import java.util.logging.Logger;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;
import aiss.model.BMI.BMIResult;
import aiss.model.titan.DataBMI;

@SuppressWarnings("unchecked")

public class BMIResource {
	
	private static final Logger log = Logger.getLogger(BMIResource.class.getName());
    private static final String uri = "https://bmi.p.rapidapi.com/";
    private static String KEY = "a650f1acc2msh3fd4d1e6f092f53p171cfdjsn0743500993e5";
    
public static BMIResult getBMI(DataBMI dataBMI) {
	   
	   ClientResource cr = new ClientResource(uri);  
	   addHeader(cr,"x-rapidapi-host", "bmi.p.rapidapi.com");
	   addHeader(cr,"x-rapidapi-key",KEY);


	   
	   BMIResult result=null;
    	
    	try {
    		log.info("Obtaining request from URL:"+ uri);
    		result=cr.post(dataBMI,BMIResult.class);
    		
    	}catch(ResourceException re) {
    		log.warning("Error obtaining a Request from BMIcalculator: " + cr.getResponse().getStatus());
    		log.warning("Uri:"+ uri);
    	}
    	
    	return result;
}

public static void addHeader(ClientResource cr, String headerName, String headerValue) {
  Series<Header> headers = (Series<Header>) cr.getRequest().getAttributes()
      .get(HeaderConstants.ATTRIBUTE_HEADERS);

  if (headers == null) {
    headers = new Series<Header>(Header.class);
   cr.getRequest().getAttributes().put(HeaderConstants.ATTRIBUTE_HEADERS, headers);
  }
	headers.add(headerName, headerValue);
}

}