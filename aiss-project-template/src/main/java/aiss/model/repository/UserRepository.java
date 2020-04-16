package aiss.model.repository;

import java.util.HashMap;
import java.util.Map;

import aiss.model.User;

public class UserRepository {

	private Map<String,User> users;
	private static UserRepository instance=null;
	
	public static UserRepository getInstance() {
		
		if (instance==null) {
			instance = new UserRepository();
			instance.init();
		}
		
		return instance;
	}
	
	public void init() {
		users = new HashMap<String,User>();
	}

	public Map<String,User> getUsers() {
<<<<<<< master
		Map<String,User> us= users;
		log.log(Level.INFO, "La lista de usuarios " + us + " fue obtenida");
		return us;
=======
		return users;
>>>>>>> 307e8d5 HOLA
	}

	public void updateContact(User u) {
		users.put(u.getUsername(), u);
	}

	public User getUser(String un) {
<<<<<<< master
		User u =users.get(un);
		if(u!=null)
			log.log(Level.INFO, "El usuario " + u.getUsername() + " fue obtenido");
		return u;
=======
		return users.get(un);
>>>>>>> 307e8d5 HOLA
	}

<<<<<<< master
	public User addUser(String username, String email, String password, String retype, Integer age, Float height, Float weight, Float hip, Float waist) {
		User u = new User(username,email,password,retype,age,height,weight,hip,waist);
		users.put(username,u);
		log.log(Level.INFO, "El usuario " + u.getUsername() + " fue creado");
		return u;
=======
	public User addContact(String username, String email, String password, String retype, Integer age, Float height, Float weight, Float hip, Float waist) {
		User c = new User(username,email,password,retype,age,height,weight,hip,waist);
		users.put(username,c);
		return c;
>>>>>>> 307e8d5 HOLA
	}

	public void deleteContact(String un) {
		users.remove(un);
	}

}

