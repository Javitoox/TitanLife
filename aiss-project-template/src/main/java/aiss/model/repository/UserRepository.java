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
		return users;
	}

	public void updateContact(User u) {
		users.put(u.getUsername(), u);
	}

	public User getUser(String un) {
		return users.get(un);
	}

	public User addContact(String username, String email, String password, String retype, Integer age, Float height, Float weight, Float hip, Float waist) {
		User c = new User(username,email,password,retype,age,height,weight,hip,waist);
		users.put(username,c);
		return c;
	}

	public void deleteContact(String un) {
		users.remove(un);
	}

}

