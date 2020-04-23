package aiss.model.repository;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import aiss.model.titan.User;


public class UserRepositoryTest {

private UserRepository repository;
	
	@Before
	public void setUp() throws Exception {
		repository=UserRepository.getInstance();
		repository.addUser("almafe2510", "almafe2510@gmail.com", "aLMAFe2510", "aLMAFe2510", "20", "170.00", "59.00",
				"80.00","80.00","m");
		repository.addUser("maribelrb", "maribelrb@gmail.com", "mARIBElRB", "mARIBElRB",  "19", "160.00", "49.00",
				"60.00","60.00","f");
		repository.addUser("danifdez", "danifdez@gmail.com", "aLMAFe2510", "aLMAFe2510",  "20", "175.00", "73.00",
				"80.00","80.00","m");
	}

	@Test
	public void testGetUsers() {
		Map<Integer,User> users=repository.getUsers();
		assertNotNull("The list of users is null",users);
		assertTrue("The list of users is empty",users.size()>0);
	}
	
	@Test
	public void testGetUser() {
		User u = repository.getUser(0);
		assertNotNull("The user is null",u);
	}
	@Test
	public void testUserNull() {
		User u = repository.getUser(100);
		assertNull("The username is not null",u);
    }

	@Test
	public void testUpdateUser() {
		User u = repository.getUser(0);			
		String oldUserName = u.getUsername();
		String oldEmail = u.getEmail();
		String oldPassword = u.getPassword();
		String oldRetype= u.getRetype();
		String oldEdad=u.getDatosBMI().getAge();

		u.setUsername(oldUserName + "Test");
		u.setEmail(oldEmail+"Test");
		u.setPassword(oldPassword+"Test");
		u.setRetype(oldRetype+"Test");
		u.getDatosBMI().setAge("50");

		repository.updateUser(u);			
		
		assertFalse("The username has not been updated correctly",oldUserName.equals(u.getUsername()));
		assertFalse("The email has not been updated correctly",oldEmail.equals(u.getEmail()));
		assertFalse("The password has not been updated correctly",oldPassword.equals(u.getPassword()));
		assertFalse("The retype has not been updated correctly",oldRetype.equals(u.getRetype()));
		assertFalse("The DataBMI has not been updated correctly",oldEdad.equals(u.getDatosBMI().getAge()));

	}

	@Test
	public void testAddUser() {
		int numberUsers=repository.getUsers().size();
		repository.addUser("rarapture", "rarapture@gmail.com", "beatrix", "beatrix", "19", "160.00", "49.00",
				"60.00","60.00","f");
		int newNumberUsers=repository.getUsers().size();
		
		assertTrue("The contact has not been added correctly", newNumberUsers==numberUsers+1);
	}

	@Test
	public void testDeleteUser() {
		int numberUsers=repository.getUsers().size();
		repository.deleteContact(0);
		int newNumberUsers=repository.getUsers().size();
		
		User u=repository.getUser(0);
		
		assertNull("The user has not been deleted", u);
		assertTrue("The user has not been delected correctly", newNumberUsers==numberUsers-1);
	}
	
	@Test
	public void testGetObjetivosAplicacion() {
		assertNotNull("Objetives not load correctly",repository.getObjetivosAplicacion());
	}
	
	@Test (expected=NullPointerException.class)
	public void inicioObjetivosUsuario() {
		repository.getUser(1).getObjetivos().remove(0);
	}
	
	@Test
	public void encontrarUsuario() {
		assertTrue("User not found",repository.findByUsername("almafe2510")!=null);
	}
}


