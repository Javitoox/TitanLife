package aiss.api.resources;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiss.api.resource.comparators.ComparatorComidaCalorias;
import aiss.api.resource.comparators.ComparatorComidaCaloriasReverse;
import aiss.api.resource.comparators.ComparatorNombreComida;
import aiss.api.resource.comparators.ComparatorNombreComidaReverse;
import aiss.model.repository.Repository;
import aiss.model.repository.TitanLifeRepository;
import aiss.model.titan.Comida;
import aiss.model.titan.User;
import aiss.utility.CalculatorFatSecret;

@Path("/comidas")
public class ComidasResource {
	
	// Singleton
	private static ComidasResource _instance=null;
	Repository repository;
	
	private ComidasResource() {
		repository=TitanLifeRepository.getInstance();

	}
	
	public static ComidasResource getInstance()
	{
		if(_instance==null)
				_instance=new ComidasResource();
		return _instance;
	}
	
	@GET
	@Produces("application/json")
	public Collection<Comida> getComidas(@QueryParam("order") String order, @QueryParam("q") String q){
		List<Comida> result=new ArrayList<>();
		
		for(Comida comida:repository.getComidas()) {
			if(q==null || comida.getNombre().toLowerCase().contains(q.toLowerCase()))
				result.add(comida);
		}
		
		if(order!=null) {
			if(order.equals("alfabetic"))
				Collections.sort(result, new ComparatorNombreComida());
			else if(order.equals("-alfabetic"))
				Collections.sort(result, new ComparatorNombreComidaReverse());
			else if(order.equals("calories"))
				Collections.sort(result, new ComparatorComidaCalorias());
			else if(order.equals("-calories"))
				Collections.sort(result, new ComparatorComidaCaloriasReverse());
			else
				throw new BadRequestException("The order parameter must be 'alfabetic', '-alfabetic', 'calories' or '-calories'.");  
		}
		
		return result;
	}
	
	@GET
	@Path("/{idComida}")
	@Produces("application/json")
	public Comida getComida(@PathParam("idComida") String idComida) {
		Comida c=repository.getComida(Integer.parseInt(idComida));
		
		if(c==null)
			throw new NotFoundException("Food not found with id: "+idComida+".");
		
		return c;
	}
	
	@POST
	@Path("/{username}/{password}")
	@Consumes("application/json")
	@Produces("application/json")
	public Response createComida(@Context UriInfo uriInfo, Comida comida, @PathParam("username") String username, 
			@PathParam("password") String password) {
		User user =repository.findByUsername(username);
		if(user==null)
			throw new NotFoundException("User not found.");
		if(!user.getPassword().equals(password))
			throw new NotFoundException("Incorrect password.");
		
		if(comida.getDescripcion()==null || comida.getNombre().equals("") || comida.getNombre()==null || 
				comida.getCaloriasPor100().equals("") || comida.getCaloriasPor100()==null)
			throw new BadRequestException("The parameters can´t be null or empty.");
		
		if(!Pattern.matches("^[0-9]+$",comida.getCaloriasPor100()))
			throw new BadRequestException("'caloriasPor100 must be a number'.");
		
		repository.addComida(comida);
		user.getComidasAdd().add(comida.getId());
			
		URI uri = uriInfo.getBaseUriBuilder().path("comidas").path("/"+comida.getId()).build();
		ResponseBuilder resp = Response.created(uri);
		resp.entity(comida);		
		return resp.build();
	}
	
	@PUT
	@Path("/{username}/{password}")
	@Consumes("application/json")
	public Response updateComida(Comida comida, @PathParam("username") String username, @PathParam("password") String password) {
		User user =repository.findByUsername(username);
		if(user==null)
			throw new NotFoundException("User not found.");
		if(!user.getPassword().equals(password))
			throw new NotFoundException("Incorrect password.");
		
		if(comida.getDescripcion()==null || comida.getNombre().equals("") || comida.getNombre()==null || 
				comida.getCaloriasPor100().equals("") || comida.getCaloriasPor100()==null)
			throw new BadRequestException("The parameters can´t be null or empty.");
		
		if(!Pattern.matches("^[0-9]+$",comida.getCaloriasPor100()))
			throw new BadRequestException("'caloriasPor100 must be a number'.");
		
		if(repository.getComida(comida.getId())==null)
			throw new NotFoundException("Food not found in the application.");
		
		if(!user.getComidasAdd().contains(comida.getId()))
			throw new NotFoundException("Food not added by the user.");
		
		repository.updateComida(comida);
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{idComida}/{username}/{password}")
	public Response deleteComida(@PathParam("idComida") String idComida, @PathParam("username") String username, 
			@PathParam("password") String password) {
		User user =repository.findByUsername(username);
		if(user==null)
			throw new NotFoundException("User not found.");
		if(!user.getPassword().equals(password))
			throw new NotFoundException("Incorrect password.");
		
		Integer id=Integer.parseInt(idComida);
		
		if(!user.getComidasAdd().contains(id))
			throw new NotFoundException("Food not added by the user.");
		
		repository.deleteComida(id);
		
		return Response.noContent().build();
	}
	
	@GET
	@Path("/{username}/{password}")
	@Produces("application/json")
	public Collection<Comida> getComidasCreadas(@PathParam("username") String username, @PathParam("password") String password, 
			@QueryParam("order") String order, @QueryParam("q") String q){
		User user =repository.findByUsername(username);
		if(user==null)
			throw new NotFoundException("User not found.");
		if(!user.getPassword().equals(password))
			throw new NotFoundException("Incorrect password.");
		
		List<Comida> result=new ArrayList<>();
		
		for(Integer id:user.getComidasAdd()) {
			Comida comida=repository.getComida(id);
			if(comida!=null) {
				if(q==null || comida.getNombre().toLowerCase().contains(q.toLowerCase()))
					result.add(comida);
			}
		}
		
		if(order!=null) {
			if(order.equals("alfabetic"))
				Collections.sort(result, new ComparatorNombreComida());
			else if(order.equals("-alfabetic"))
				Collections.sort(result, new ComparatorNombreComidaReverse());
			else if(order.equals("calories"))
				Collections.sort(result, new ComparatorComidaCalorias());
			else if(order.equals("-calories"))
				Collections.sort(result, new ComparatorComidaCaloriasReverse());
			else
				throw new BadRequestException("The order parameter must be 'alfabetic', '-alfabetic', 'calories' or '-calories'.");  
		}
		
		return result;
	}
	
	@PUT
	@Path("/user/{id}/{idComida}/{type}")
	public Response updateComidasUsuario(@PathParam("id") String id, @PathParam("type") String type,
			@PathParam("idComida") String idComida, @QueryParam("gramos") String gramos) {
		User u=repository.getUser(Integer.parseInt(id));
		if(u==null)
			throw new NotFoundException("Not found user with id: "+id+".");
		
		if(!type.equals("add") && !type.equals("delete"))
			throw new BadRequestException("'type' parameter must be 'add' or 'delete'.");
		
		Comida comida=repository.getComida(Integer.parseInt(idComida));
		if(comida==null)
			throw new NotFoundException("Food not found in the application.");
		
		Integer caloriesUser=CalculatorFatSecret.userBaseCalories(u);
		// Reseteamos por completo las calorías si todavía no se han generado las calorñias o si hemos pasado de día
		if(u.getBaseCaloriasDiarias()==null || !u.getInstanteCalorias().equals(LocalDate.now())) {
			u.setBaseCaloriasDiarias(caloriesUser);
			u.setCaloriasDiarias(caloriesUser);
			u.setInstanteCalorias(LocalDate.now());
			u.setComidasDiarias(new ArrayList<String>());
		}
		
		if(type.equals("add")) {
			if(gramos==null || !Pattern.matches("^[0-9]+$",gramos))
				throw new BadRequestException("For add 'gramos' parameter must be in a numeric format.");
			String format=comida.getNombre()+"/"+comida.getId()+"/"+comida.getCaloriasPor100()+"/"+gramos+"/";
			String caloriasXGramos=((Integer)((Integer.parseInt(gramos)*Integer.parseInt(comida.getCaloriasPor100()))/100))
					.toString();
			format+=caloriasXGramos;
			u.setCaloriasDiarias(u.getCaloriasDiarias()-Integer.parseInt(caloriasXGramos));
			u.getComidasDiarias().add(format);
		}else {
			for(String s:new ArrayList<>(u.getComidasDiarias())) {
				Integer i=Integer.parseInt(s.split("/")[1]);
				if(comida.getId().equals(i)) {
					u.setCaloriasDiarias(u.getCaloriasDiarias()+Integer.parseInt(s.split("/")[4]));
					u.getComidasDiarias().remove(s);
				}
			}
		}
		
		// Hacemos los calculos necesarios por si han cambiado las calorías del usuario por motivos ajenos a las comidas
		Integer restadas=u.getBaseCaloriasDiarias()-u.getCaloriasDiarias();
		u.setBaseCaloriasDiarias(caloriesUser);
		u.setCaloriasDiarias(caloriesUser-restadas);
		
		return Response.noContent().build();
	}

}
