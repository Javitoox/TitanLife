package aiss.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import aiss.model.titan.Objetivo;
import aiss.model.titan.TipoDesgasteCalorico;
import aiss.model.titan.User;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.IdentityType;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class UserRepository {
    private static final Logger log = Logger.getLogger(UserRepository.class.getName());

    private Map<Integer,User> users;
    private static UserRepository instance=null;
    private Integer index=0; //Identificador único de usuarios
    private List<Objetivo> objetivosAplicacion=new ArrayList<>();

    public static UserRepository getInstance() {

        if (instance==null) {
            instance = new UserRepository();
            instance.init();
        }

        return instance;
    }

    public void init() {
        users = new HashMap<Integer,User>();
        //Añadimos al repositorio los objetivos que tendrá nuestra aplicación
        objetivosAplicacion.add(new Objetivo("Fuerza general",TipoDesgasteCalorico.BAJO));
        objetivosAplicacion.add(new Objetivo("Resistencia general",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Cardio general",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Calistenia",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Corredor avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Corredor medio",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Powerlifting",TipoDesgasteCalorico.BAJO));
        log.info("Cargados los objetivos de la aplicación");
    }

    public Map<Integer,User> getUsers() {
        Map<Integer,User> us= users;
        log.log(Level.INFO, "Los usuarios fueron obtenidos: "+us);
        return us;
    }

    public void updateUser(User u) {
        users.put(u.getId(), u);
        log.log(Level.INFO, "El usuario " + u.getUsername() + " fue actualizado");

    }

    public User getUser(Integer id) {
        User u =users.get(id);
        if(u!=null)
            log.log(Level.INFO, "El usuario " + u.getUsername() + " fue obtenido");
        return u;
    }

    public User addUser(String username, String email, String password, String retype, String age,
    		String height, String weight, String hip, String waist, String sex) {
        User u = new User(index,username,email,password,retype,age,height,weight,hip,waist,sex);
        users.put(index,u);
        index++;
        log.log(Level.INFO, "El usuario " + u.getUsername() + " fue creado");
        return u;
    }

    public void deleteContact(Integer id) {
        User u=users.get(id);
        users.remove(id);
        log.log(Level.INFO, "El usuario " + u.getUsername() + " fue eliminado");
    }
    
    public List<Objetivo> getObjetivosAplicacion() {
    	log.info("Objetivos de la aplicación volcados");
    	return objetivosAplicacion;
    }
    
    public User findByUsername(String username){
		User result=null;
		for(User u:users.values()){
			if(u.getUsername().equals(username)){
				result=u;
				log.info(username+" encontrado en el repositorio de la aplicación");
				break;
			}
		}
		return result;
	}

}
