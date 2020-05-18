package aiss.model.repository;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import aiss.model.strava.StravaActivityC;
import aiss.model.titan.DataBMI;
import aiss.model.titan.Height;
import aiss.model.titan.Objetivo;
import aiss.model.titan.TipoDesgasteCalorico;
import aiss.model.titan.User;
import aiss.model.titan.Weight;


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
		assertTrue("The list of users is empty ",users.size()>0);
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
		DataBMI dataBMI = u.getDatosBMI();
		String oldHeight=dataBMI.getHeight().getValue().toString();
		String oldWeight=u.getDatosBMI().getWeight().getValue().toString();
		
		List<StravaActivityC> la= new ArrayList<>();
		u.setActividades(la);
		List<StravaActivityC> oldActividades= u.getActividades();


		List<Objetivo> lo =new ArrayList<>();
		u.setObjetivos(lo);
		List<Objetivo> oldObjetivos= u.getObjetivos();

		u.getId();
		
		u.setFechaObj("14-12-2020");
		u.setImc("20.0");
		u.setImcObj("21.0");
		u.setPesoObj("10.00");
		u.setBaseCaloriasDiarias(130);
		u.setCaloriasDiarias(12);
		u.setInstanteCalorias(LocalDate.now());
		List<String> comidasDiarias= new ArrayList<>();
		u.setComidasDiarias(comidasDiarias);
		
		String oldPesoObj=u.getPesoObj();
		String oldFechaObj = u.getFechaObj();
		String oldIMC = u.getImc();
		String oldIMCObj = u.getImcObj();
		String oldHip = u.getDatosBMI().getHip();
		String oldWaist = u.getDatosBMI().getWaist();
		String oldSex = u.getDatosBMI().getSex();
		Integer oldBaseCaloriasDiarias = u.getBaseCaloriasDiarias();
		Integer oldCaloriasDiarias = u.getCaloriasDiarias();
		List<String> oldComidasDiarias = u.getComidasDiarias();
		LocalDate oldInstanteCalorias = u.getInstanteCalorias();
		
		
		
		List<StravaActivityC> las= new ArrayList<>();
		StravaActivityC s = new StravaActivityC();
		las.add(s);
		
		Objetivo o = new Objetivo("Atletismo principiante",TipoDesgasteCalorico.ALTO);
		o.setNombre("Boxeo principiante");
		o.setTipo(TipoDesgasteCalorico.MEDIO);
		List<Objetivo> los =new ArrayList<>();
		los.add(o);
		
		o.getNombre();
		o.getTipo();
		
		Height h = new Height();
		
		h.setUnit("100.00");
		h.setValue("cm");
		
		Weight w = new Weight();
		h.setUnit("100.00");
		h.setValue("kg");
		
		w.getUnit();
		w.getValue();
		h.getUnit();
		h.getValue();

		
		u.setUsername(oldUserName + "Test");
		u.setEmail(oldEmail+"Test");
		u.setPassword(oldPassword+"Test");
		u.setRetype(oldRetype+"Test");
		u.getDatosBMI().setAge("50");
		
		u.getDatosBMI().setHip("30.00");
		u.getDatosBMI().setWaist("30.00");
		u.getDatosBMI().setSex("f");
		u.getDatosBMI().setHeight(h);;
		u.getDatosBMI().setWeight(w);
		
		u.setFechaObj("13-12-2020");
		u.setImc("10.0");
		u.setImcObj("50.0");
		u.setActividades(las);
		u.setPesoObj("90.00");
		u.setObjetivos(los);
		u.setDatosBMI(dataBMI);
		
		u.setBaseCaloriasDiarias(150);
		u.setCaloriasDiarias(15);		
		List<String> comidasDiariass= new ArrayList<>();
		comidasDiariass.add("Huevos fritos");
		u.setComidasDiarias(comidasDiariass);
		u.setInstanteCalorias(LocalDate.now().plusDays(1));
		
		
		repository.updateUser(u);			
		
		assertFalse("The username has not been updated correctly",oldUserName.equals(u.getUsername()));
		assertFalse("The email has not been updated correctly",oldEmail.equals(u.getEmail()));
		assertFalse("The password has not been updated correctly",oldPassword.equals(u.getPassword()));
		assertFalse("The retype has not been updated correctly",oldRetype.equals(u.getRetype()));
		
		assertFalse("The DataBMI has not been updated correctly",oldEdad.equals(u.getDatosBMI().getAge()));
		assertFalse("The DataBMI has not been updated correctly",oldHip.equals(u.getDatosBMI().getHip()));
		assertFalse("The DataBMI has not been updated correctly",oldWaist.equals(u.getDatosBMI().getWaist()));
		assertFalse("The DataBMI has not been updated correctly",oldSex.equals(u.getDatosBMI().getSex()));
		assertFalse("The DataBMI has not been updated correctly",oldHeight.equals(u.getDatosBMI().getHeight().getValue()));
		assertFalse("The DataBMI has not been updated correctly",oldWeight.equals(u.getDatosBMI().getWeight().getValue()));
		
		assertFalse("The objectiveDate has not been updated correctly",oldFechaObj.equals(u.getFechaObj()));
		assertFalse("The IMC has not been updated correctly",oldIMC.equals(u.getImc()));
		assertFalse("The objectiveIMC has not been updated correctly",oldIMCObj.equals(u.getImcObj()));
		assertFalse("The list of activities has not been updated correctly",oldActividades.size()==(u.getActividades().size()));
		assertFalse("The objectiveWeight has not been updated correctly",oldPesoObj.equals(u.getPesoObj()));
		assertFalse("The list of objectives has not been updated correctly",oldObjetivos.equals(u.getObjetivos()));
		
		assertFalse("The username has not been updated correctly",oldBaseCaloriasDiarias.equals(u.getBaseCaloriasDiarias()));
		assertFalse("The email has not been updated correctly",oldCaloriasDiarias.equals(u.getCaloriasDiarias()));
		assertFalse("The password has not been updated correctly",oldComidasDiarias.size()==(u.getComidasDiarias().size()));
		assertFalse("The retype has not been updated correctly",oldInstanteCalorias.equals(u.getInstanteCalorias()));
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
		repository.deleteUser(0);
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
	
	@Test
	public void encontrarObjetivo() {
		assertTrue("Objective not found",repository.findByObjetiveName("Atletismo principiante")!=null);
	}
}


