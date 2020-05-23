package aiss.model.resource;

import java.util.logging.Logger;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import aiss.model.BMI.BMIResult;
import aiss.model.titan.DataBMI;
import aiss.utility.AddHeader;


public class BMIResource {
	
	private static final Logger log = Logger.getLogger(BMIResource.class.getName());
    private static final String uri = "https://bmi.p.rapidapi.com/";
    private static String KEY = "a650f1acc2msh3fd4d1e6f092f53p171cfdjsn0743500993e5";
    
public static BMIResult getBMI(DataBMI dataBMI) {
	   
	   ClientResource cr = new ClientResource(uri);  
	   AddHeader.addHeader(cr,"x-rapidapi-host", "bmi.p.rapidapi.com");
	   AddHeader.addHeader(cr,"x-rapidapi-key",KEY);


	   
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



}