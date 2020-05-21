package aiss.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import aiss.model.repository.Repository;
import aiss.model.repository.TitanLifeRepository;
import aiss.model.titan.User;

public class Validacion {
	//Expresiones regulares usadas
    private static final String usernameRegexp = "^[a-zA-Z0-9_-]{3,40}$";
    private static final String ageRegexp = "^[0-9]{1,3}$";
    private static final String heightRegexp = "^[0-9]*\\.[0-9]{2}$";
    private static final String weightRegexp = "^[0-9]*\\.[0-9]{2}$";
    private static final String hipRegexp = "^[0-9]*\\.[0-9]{2}$";
    private static final String waistRegexp = "^[0-9]*\\.[0-9]{2}$";
    private static final String emailRegexp = "[^@]+@[^@]+\\.[a-zA-Z]{2,}";
    private static final String passwordRegexp = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
    private static final String sexRegexp= "^[mf]{1}$";
	
	
	public static String validacion(String username,String email,String password,String retype,String age,String height
			,String weight,String hip,String waist,String sex) {
		
		String validaciones="";
        String sexRegexp= "^[mf]{1}$";
        
        Repository repository=TitanLifeRepository.getInstance();
        
        List<String> usernames=new ArrayList<>();
        List<String> emails=new ArrayList<>();
        for(User u:repository.getUsers().values()) {
        	usernames.add(u.getUsername());
        	emails.add(u.getEmail());
        }
        if(usernames.contains(username)) {
        	validaciones+="El username ya existe en la aplicación\n";
        }
        if(emails.contains(email)) {
        	validaciones+="El email ya existe en la aplicación\n";
        }
        if(!Pattern.matches(usernameRegexp,username)) {
        	validaciones += "El username debe contener al menos una mayúscula, minúscula y dígito\n";
        }
        if(!Pattern.matches(emailRegexp,email)) {
        	validaciones += "Formato incorrecto del correo\n";
        }
        if(!Pattern.matches(passwordRegexp,password)) {
        	validaciones += "La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. "
        			+ "Debe contener 8 o más carácteres\n";
        }
        if(!password.equals(retype)) {
        	validaciones += "La contraseña no coincide con la confirmación\n";
        }
        if(!Pattern.matches(ageRegexp,age)) {
       	    validaciones += "Formato incorrecto de la edad\n";
        }
        if(!Pattern.matches(heightRegexp,height)) {
        	validaciones += "Formato incorrecto de la altura\n";
        }
        if(!Pattern.matches(weightRegexp,weight)) {
        	validaciones += "Formato incorrecto del peso\n";
        }
        if(!Pattern.matches(hipRegexp,hip)) {
       	    validaciones += "Formato incorrecto de la cadera\n";
        }
        if(!Pattern.matches(waistRegexp,waist)) {
        	validaciones += "Formato incorrecto de la cintura\n";
        }
        if(!Pattern.matches(sexRegexp,sex)) {
        	validaciones += "Formato incorrecto del sexo\n";
        }
		
		return validaciones;
	}
	public static String validacion2(User us,String username,String email,String password,String age,String height
			,String weight,String hip,String waist,String sex) {
		
		String validaciones="";
        Repository repository=TitanLifeRepository.getInstance();
        
        List<String> usernames=new ArrayList<>();
        List<String> emails=new ArrayList<>();
        for(User u:repository.getUsers().values()) {
        	usernames.add(u.getUsername());
        	emails.add(u.getEmail());
        }
        if(usernames.contains(username)&&us.getUsername()==username) {
        	validaciones+="El username ya existe en la aplicación\n";
        }
        if(emails.contains(email)&&us.getEmail()==email) {
        	validaciones+="El email ya existe en la aplicación\n";
        }
        if(!Pattern.matches(usernameRegexp,username)) {
        	validaciones += "El username debe contener al menos una mayúscula, minúscula y dígito\n";
        }
        if(!Pattern.matches(emailRegexp,email)) {
        	validaciones += "Formato incorrecto del correo\n";
        }
        if(!Pattern.matches(passwordRegexp,password)) {
        	validaciones += "La contraseña debe incluir al menos una mayúscula, una minúscula, un dígito. "
        			+ "Debe contener 8 o más carácteres\n";
        }
        if(!Pattern.matches(ageRegexp,age)) {
       	    validaciones += "Formato incorrecto de la edad\n";
        }
        if(!Pattern.matches(heightRegexp,height)) {
        	validaciones += "Formato incorrecto de la altura\n";
        }
        if(!Pattern.matches(weightRegexp,weight)) {
        	validaciones += "Formato incorrecto del peso\n";
        }
        if(!Pattern.matches(hipRegexp,hip)) {
       	    validaciones += "Formato incorrecto de la cadera\n";
        }
        if(!Pattern.matches(waistRegexp,waist)) {
        	validaciones += "Formato incorrecto de la cintura\n";
        }
        if(!Pattern.matches(sexRegexp,sex)) {
        	validaciones += "Formato incorrecto del sexo\n";
        }
		
		return validaciones;
	}
	
	public static String validacionObjCorp(String peso, String fecha) {
		String validaciones="";
		if(!Pattern.matches(weightRegexp,peso)) {
        	validaciones += "|Formato incorrecto del peso";
        }
		LocalDate hoy=LocalDate.now();
		LocalDate nuevo=LocalDate.now().plusDays(1);
		try {
			 nuevo=LocalDate.parse(fecha);
		}catch(Exception e) {
			validaciones+="|La fecha debe seguir el formato y-m-d";
		}
		if(!hoy.isBefore(nuevo)) {
        	validaciones += "|La fecha debe ser posterior al día de hoy";
        }
		return validaciones;
	}
	
}