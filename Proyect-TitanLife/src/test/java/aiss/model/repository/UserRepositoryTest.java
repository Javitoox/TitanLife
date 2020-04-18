package aiss.model.repository;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import aiss.model.User;


public class UserRepositoryTest {

private UserRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository=UserRepository.getInstance();
		repository.init();
		repository.addUser("almafe2510", "almafe2510@gmail.com", "aLMAFe2510", "aLMAFe2510", 20, 17, 59, 23, 12);
		repository.addUser("maribelrb", "maribelrb@gmail.com", "mARIBElRB", "mARIBElRB", 19, 16, 53, 24, 13);
		repository.addUser("danifdez", "danifdez@gmail.com", "aLMAFe2510", "aLMAFe2510", 20, 18, 60, 25, 14);
		
	}

	@Test
	public void testGetUsers() {
		Map<String,User> users=repository.getUsers();
		assertNotNull("The list of users is null",users);
		assertTrue("The list of users is empty",users.size()>=3);
	}
	
	@Test
	public void testGetUser() {
		User u = repository.getUser("almafe2510");
		assertNotNull("The user is null",u);
	}
	@Test
	public void testUserNull() {
		User u = repository.getUser("Hola");
		assertNull("The username is null",u);
}

	@Test
	public void testUpdateUser() {
		String username = "almafe2510"; 
		User u = repository.getUser(username);			
		String oldUserName = u.getUsername();
		String oldEmail = u.getEmail();
		String oldPassword = u.getPassword();
		String oldRetype= u.getRetype();
		Integer oldAge=u.getAge();
		Integer oldHeight=u.getHeight();
		Integer oldWeight=u.getWeight();
		Integer oldHip=u.getHip();
		Integer oldWaist=u.getWaist();

		
		u.setUsername(oldUserName + "Test");
		u.setEmail(oldEmail+"Test");
		u.setPassword(oldPassword+"Test");
		u.setRetype(oldRetype+"Test");
		u.setAge(oldAge+3);
		u.setHeight(oldHeight+1);
		u.setWeight(oldWeight+1);
		u.setHip(oldHip+1);
		u.setWaist(oldWaist+1);

		repository.updateUser(u);
		
		u = repository.getUser(username);			
		
		assertFalse("The username has not been updated correctly",oldUserName.equals(u.getUsername()));
		assertFalse("The email has not been updated correctly",oldEmail.equals(u.getEmail()));
		assertFalse("The password has not been updated correctly",oldPassword.equals(u.getPassword()));
		assertFalse("The retype has not been updated correctly",oldRetype.equals(u.getRetype()));
		assertFalse("The age has not been updated correctly",oldAge.equals(u.getAge()));
		assertFalse("The height has not been updated correctly",oldHeight.equals(u.getHeight()));
		assertFalse("The weight has not been updated correctly",oldWeight.equals(u.getWeight()));
		assertFalse("The hip(cm) has not been updated correctly",oldHip.equals(u.getHip()));
		assertFalse("The waist(cm) has not been updated correctly",oldWaist.equals(u.getWaist()));

	}

	@Test
	public void testAddUser() {
		int numberUsers=repository.getUsers().size();
		repository.addUser("rarapture", "rarapture@gmail.com", "beatrix", "beatrix", 19, 17, 51, 21, 12);
		int newNumberUsers=repository.getUsers().size();
		
		assertTrue("The contact has not been added correctly", newNumberUsers==numberUsers+1);
	}

	@Test
	public void testDeleteUser() {
		String username = "danifdez";
		int numberUsers=repository.getUsers().size();
		repository.deleteContact(username);
		int newNumberUsers=repository.getUsers().size();
		
		User u=repository.getUser(username);
		
		assertNull("The user has not been deleted", u);
		assertTrue("The user has not been delected correctly", newNumberUsers==numberUsers-1);
	}
}


