package aiis.model.resource;

import java.util.logging.Logger;

import org.restlet.resource.ClientResource;

import aiss.model.BMI.BMIResult;
import aiss.model.titan.DataBMI;

public class BMIResource {
	
	private static final Logger log = Logger.getLogger(BMIResource.class.getName());
    private final String uri = "https://bmi.p.rapidapi.com";
    private static String KEY = "396811fec9mshb29bec5fb9776cdp16c325jsn93fd9105bd7d";
    
//    public BMIResult getBMI(DataBMI datos) {
//    	ClientResource cr=null;
//    	BMIResult r=null;
//    	try {
//    		cr= new ClientResource()
//    		
//    	}catch() {
//    		
//    	}
//    	
//    	return r;
//    }
    

}
