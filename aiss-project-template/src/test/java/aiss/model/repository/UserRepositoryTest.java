package aiss.model.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.security.InvalidParameterException;
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
		repository.addContact("almafe2510", "almafe2510@gmail.com", "aLMAFe2510", "aLMAFe2510", 20, 1.7f, 59.7f, 23.5f, 12.4f);
		repository.addContact("maribelrb", "maribelrb@gmail.com", "mARIBElRB", "mARIBElRB", 19, 1.6f, 53.7f, 24.5f, 13.4f);
		repository.addContact("danifdez", "danifdez@gmail.com", "aLMAFe2510", "aLMAFe2510", 20, 1.8f, 60.7f, 25.5f, 14.4f);
		
	}

	@Test
	public void testGetUsers() {
		Map<String,User> contacts=repository.getUsers();
		assertNotNull("The list of users is null",contacts);
		assertTrue("The list of users is empty",contacts.size()>=3);
	}
	
	@Test
	public void testGetUser() {
		User u = repository.getUser("");
		assertNotNull("The user is null",u);
	}
	@Test
	public void testUserNull() {
		User u = repository.getUser("Hola");
		assertNull("The username is null",u);
}
	@Test (expected = InvalidParameterException.class)
	public void testSameUserName() {
		repository.addContact("almafe2510", "almafe2510@gmail.com", "aLMAFe2510", "aLMAFe2510", 20, 1.7f, 59.7f, 23.5f, 12.4f);
}
	@Test
	public void testUpdateUser() {
		String username = "almafe2510"; 
		User u = repository.getUser(username);			
		String oldUserName = u.getUsername();
		String oldEmail = u.getEmail();
		
		u.setUsername(oldUserName + "Test");
		u.setEmail(oldEmail+"Test");
		repository.updateContact(u);
		
		u = repository.getUser(username);			
		
		assertFalse("The username has not been updated correctly",oldUserName.equals(u.getUsername()));
		assertFalse("The email has not been updated correctly",oldEmail.equals(u.getEmail()));
	}

	@Test
	public void testAddUser() {
		int numberUsers=repository.getUsers().size();
		repository.addContact("rarapture", "rarapture@gmail.com", "beatrix", "beatrix", 19, 1.7f, 51.7f, 21.5f, 12.4f);
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

