package aiss.model.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import aiss.model.User;

public class UserRepository {

	private static final Logger log = Logger.getLogger(UserRepository.class.getName());

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
		Map<String,User> us= users;
//		log.log(Level.INFO, "La lista de usuarios " + us + " fue obtenida");
		return us;
	}

	public void updateUser(User u) {
		users.put(u.getUsername(), u);
		log.log(Level.INFO, "El usuario " + u.getUsername() + " fue actualizado");

	}

	public User getUser(String un) {
		User u =users.get(un);
		log.log(Level.INFO, "El usuario " + u.getUsername() + " fue obtenido");
		return u;
	}

	public User addUser(String username, String email, String password, String retype, Integer age, Float height, Float weight, Float hip, Float waist) {
		User u = new User(username,email,password,retype,age,height,weight,hip,waist);
		users.put(username,u);
//		log.log(Level.INFO, "El usuario " + u.getUsername() + " fue creado");
		return u;
	}

	public void deleteContact(String un) {
		User u=users.get(un);
		users.remove(un);
		log.log(Level.INFO, "El usuario " + u.getUsername() + " fue eliminado");
	}

}

