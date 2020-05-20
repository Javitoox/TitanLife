package aiss.api.resources;

import java.net.URI;

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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.jboss.resteasy.spi.BadRequestException;
import org.jboss.resteasy.spi.NotFoundException;

import aiis.model.resource.BMIResource;
import aiss.model.BMI.BMIResult;
import aiss.model.repository.UserRepository;
import aiss.model.titan.DataBMI;
import aiss.model.titan.Height;
import aiss.model.titan.User;
import aiss.model.titan.UserRegister;
import aiss.model.titan.UserUpdate;
import aiss.model.titan.Weight;
import aiss.utility.Validacion;

@Path("/user")
public class UserResource {
	
	// Singleton
	private static UserResource _instance=null;
	UserRepository repository;
	
	private UserResource() {
		repository=UserRepository.getInstance();

	}
	
	public static UserResource getInstance()
	{
		if(_instance==null)
				_instance=new UserResource();
		return _instance;
	}
	
	@GET
	@Path("/{username}/{password}")
    @Produces("application/json")
	public User getDataUser(@PathParam("username") String username, @PathParam("password") String password) {
		User result =repository.findByUsername(username);
		if(result==null)
			throw new NotFoundException("User not found.");
		if(!result.getPassword().equals(password))
			throw new NotFoundException("Incorrect password.");
		
		return result;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createUser(@Context UriInfo uriInfo, UserRegister u) {
		String validate=Validacion.validacion(u.getUsername(), u.getEmail(), u.getPassword(), u.getRetype(), u.getAge(),
				u.getHeight(), u.getWeight(), u.getHip(), u.getWaist(), u.getSex());
		
		if(!validate.equals(""))
			throw new BadRequestException("(POST) User´s format invalidate: "+validate+".");
		
		User user=repository.addUser(u.getUsername(), u.getEmail(), u.getPassword(), u.getRetype(), u.getAge(),
				u.getHeight(), u.getWeight(), u.getHip(), u.getWaist(), u.getSex());
		
		UriBuilder ub = uriInfo.getAbsolutePathBuilder().path(this.getClass(), "getDataUser");
		URI uri = ub.build(user.getUsername(),user.getPassword());
		ResponseBuilder resp = Response.created(uri);
		resp.entity(user);			
		return resp.build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes("application/json")
	public Response updateUser(UserUpdate u, @PathParam("id") String id, @QueryParam("imc") String imc, 
			@QueryParam("pesoObj") String pesoObj, @QueryParam("fechaObj") String fechaObj) {
		User user=repository.getUser(Integer.parseInt(id));
		if(user==null)
			throw new NotFoundException("Not found user with id: "+id+".");
		
		String validate=Validacion.validacion2(user,u.getUsername(), u.getEmail(), u.getPassword(), u.getAge(),
				u.getHeight(), u.getWeight(), u.getHip(), u.getWaist(), u.getSex());
		
		if(!validate.equals(""))
			throw new BadRequestException("(PUT) User´s format invalidate: "+validate+".");
		
		user.setUsername(u.getUsername());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		DataBMI datosBMI = user.getDatosBMI();
    	Weight weight2 = datosBMI.getWeight();
    	Height height2 = datosBMI.getHeight();
    	height2.setValue(u.getHeight());
       	weight2.setValue(u.getWeight());
    	datosBMI.setHeight(height2);
    	datosBMI.setWeight(weight2);
    	datosBMI.setHip(u.getHip());
    	datosBMI.setWaist(u.getWaist());
    	datosBMI.setAge(u.getAge());
    	datosBMI.setSex(u.getSex());
		user.setDatosBMI(datosBMI);
		
		if(imc!=null) {
			if(imc.equals("true")) {
				BMIResult bmires=BMIResource.getBMI(user.getDatosBMI());
				String bmi= bmires.getBmi().getValue() + " | " + bmires.getBmi().getStatus();
				user.setImc(bmi);
			}else {
                throw new BadRequestException("The imc parameter must be 'true'.");
            }
		}
		
		if(pesoObj!=null || fechaObj!=null) {
			if(!(pesoObj!=null && fechaObj!=null))
				throw new BadRequestException("You must enter both parameters, 'pesoObj' and 'fechaObj', simultaneously.");
			String validacion=Validacion.validacionObjCorp(pesoObj, fechaObj);
			if(!validacion.equals(""))
				throw new BadRequestException("(PUT) User´s format invalidate generating imc objetive: "+validacion+".");
			user.setPesoObj(pesoObj);
			user.setFechaObj(fechaObj);
			String pesoOriginal=user.getDatosBMI().getWeight().getValue();
			user.getDatosBMI().getWeight().setValue(pesoObj);
			BMIResult bmires=BMIResource.getBMI(user.getDatosBMI());
			String bmi= bmires.getBmi().getValue() + " | " + bmires.getBmi().getStatus();
			user.setImcObj(bmi);
			user.getDatosBMI().getWeight().setValue(pesoOriginal);
		}
		
		return Response.noContent().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") String id) {
		User user=repository.getUser(Integer.parseInt(id));
		if(user!=null)
			repository.deleteUser(Integer.parseInt(id));
		
	return Response.noContent().build();
	}

}
