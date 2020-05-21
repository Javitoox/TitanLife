package aiss.model.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import aiss.model.titan.Comida;
import aiss.model.titan.Objetivo;
import aiss.model.titan.TipoDesgasteCalorico;
import aiss.model.titan.User;

public class TitanLifeRepository implements Repository {
    private static final Logger log = Logger.getLogger(TitanLifeRepository.class.getName());

    private Map<Integer,User> users;
    private Map<Integer,Comida> comidas;
    private static Repository instance=null;
    private Integer index=0; //Identificador único para usuarios
    private Integer index2=0; //Identiidicar único para comidas
    private List<Objetivo> objetivosAplicacion=new ArrayList<>();

    public static Repository getInstance() {

        if (instance==null) {
            instance = new TitanLifeRepository();
            instance.init();
        }

        return instance;
    }

    public void init() {
        users = new HashMap<Integer,User>();
        comidas = new HashMap<Integer,Comida>();
        //Añadimos al repositorio las comidas que tendrá por defecto nuestra aplicación
        Comida c1=new Comida();
        c1.setNombre("Pollo asado");
        c1.setCaloriasPor100("140");
        c1.setDescripcion("Tradicional plato cargado de proteínas");
        addComida(c1);
        
        Comida c2=new Comida();
        c2.setNombre("Trucha");
        c2.setCaloriasPor100("50");
        c2.setDescripcion("Pescado bajo en calorías");
        addComida(c2);
        
        Comida c3=new Comida();
        c3.setNombre("Huevo");
        c3.setCaloriasPor100("155");
        c3.setDescripcion("Huevo de codorniz");
        addComida(c3);
        
        Comida c4=new Comida();
        c4.setNombre("Fideos cocidos");
        c4.setCaloriasPor100("142");
        c4.setDescripcion("Clásico de pasta");
        addComida(c4);
        
        Comida c5=new Comida();
        c5.setNombre("Pan de pita");
        c5.setCaloriasPor100("290");
        c5.setDescripcion("Pan altamente rico en hidratos");
        addComida(c5);
        
        Comida c6=new Comida();
        c6.setNombre("Pan integral");
        c6.setCaloriasPor100("244");
        c6.setDescripcion("Pan altamente rico en fibra");
        addComida(c6);
        
        Comida c7=new Comida();
        c7.setNombre("Hamburguesa con queso");
        c7.setCaloriasPor100("250");
        c7.setDescripcion("Comida rápida no excesivamente calórica");
        addComida(c7);
        
        Comida c8=new Comida();
        c8.setNombre("Hamburguesa con queso");
        c8.setCaloriasPor100("250");
        c8.setDescripcion("Comida rápida no excesivamente calórica");
        addComida(c8);
        
        Comida c9=new Comida();
        c9.setNombre("Pechuga de pavo");
        c9.setCaloriasPor100("111");
        c9.setDescripcion("Carne altamente rica en creatina");
        addComida(c9);
        
        Comida c10=new Comida();
        c10.setNombre("Boniato");
        c10.setCaloriasPor100("77");
        c10.setDescripcion("Verdura muy utilizada por deportistas");
        addComida(c10);
        
        //Añadimos al repositorio los objetivos que tendrá nuestra aplicación
        objetivosAplicacion.add(new Objetivo("Atletismo principiante",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Atletismo medio",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Boxeo principiante",TipoDesgasteCalorico.BAJO));
        objetivosAplicacion.add(new Objetivo("Boxeo medio",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Boxeo avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Crossfit principiante",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Crossfit medio",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Crossfit avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Cardio general",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Cardio avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Calistenia principiante",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Calistenia nivel medio",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Calistenia avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Corredor avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Corredor medio",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Corredor principiante",TipoDesgasteCalorico.BAJO));
        objetivosAplicacion.add(new Objetivo("Fuerza general",TipoDesgasteCalorico.BAJO));
        objetivosAplicacion.add(new Objetivo("Fuerza bruta",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Resistencia general",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Resistencia avanzada",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Powerlifting principiante",TipoDesgasteCalorico.BAJO));
        objetivosAplicacion.add(new Objetivo("Powerlifting medio",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Powerlifting avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Natación principiante",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Natación medio",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Natación avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Ciclismo principiante",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Ciclismo medio",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Ciclismo avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Hits baja intensidad",TipoDesgasteCalorico.BAJO));
        objetivosAplicacion.add(new Objetivo("Hits media intensidad",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Hits alta intensidad",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Powerbuilding principiante",TipoDesgasteCalorico.BAJO));
        objetivosAplicacion.add(new Objetivo("Powerbuilding medio",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Powerbuilding avanzado",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Halterofilia principiante",TipoDesgasteCalorico.BAJO));
        objetivosAplicacion.add(new Objetivo("Halterofilia media",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Halterofilia avanzada",TipoDesgasteCalorico.ALTO));
        objetivosAplicacion.add(new Objetivo("Senderismo general",TipoDesgasteCalorico.MEDIO));
        objetivosAplicacion.add(new Objetivo("Senderismo alta intensidad",TipoDesgasteCalorico.ALTO));
        Collections.sort(objetivosAplicacion);
        log.info("Cargados los datos de la aplicación");
    }

    // Users operations
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

    public void deleteUser(Integer id) {
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
    
    // Objetives operations
    public Objetivo findByObjetiveName(String objetiveName){
    	Objetivo result=null;
		for(Objetivo o:objetivosAplicacion){
			if(o.getNombre().equals(objetiveName)){
				result=o;
				log.info(objetiveName+" encontrado en el repositorio de la aplicación de los objetivos");
				break;
			}
		}
		return result;
	}
    
    // Foods operations
    public void addComida(Comida c) {
    	comidas.put(index2, c);
    	c.setId(index2);
    	index2--; //Ponemos índices negativos para que no solapen nuestras comidas con las de FatSecret
    }
    
    public Collection<Comida> getComidas() {
		return comidas.values();
    }
    
    public Comida getComida(Integer comidaId) {
		return comidas.get(comidaId);
	}
    
    public void updateComida(Comida s) {
		Comida comida = comidas.get(s.getId());
		comida.setCaloriasPor100(s.getCaloriasPor100());
		comida.setDescripcion(s.getDescripcion());
		comida.setNombre(s.getNombre());
	}
    
    public void deleteComida(Integer comidaId) {
		comidas.remove(comidaId);
	}

}
