package aiss.model.repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import aiss.model.titan.Comida;
import aiss.model.titan.Objetivo;
import aiss.model.titan.User;

public interface Repository {

	void init();

	// Users operations
	Map<Integer, User> getUsers();

	void updateUser(User u);

	User getUser(Integer id);

	User addUser(String username, String email, String password, String retype, String age, String height,
			String weight, String hip, String waist, String sex);

	void deleteUser(Integer id);

	List<Objetivo> getObjetivosAplicacion();

	User findByUsername(String username);

	// Objetives operations
	Objetivo findByObjetiveName(String objetiveName);

	// Foods operations
	void addComida(Comida c);

	Collection<Comida> getComidas();

	Comida getComida(Integer comidaId);

	void updateComida(Comida s);

	void deleteComida(Integer comidaId);

}