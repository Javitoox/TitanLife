package aiss.api.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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

import aiss.api.resource.comparators.ComparatorObjetivoReverse;
import aiss.api.resource.comparators.ComparatorWear;
import aiss.api.resource.comparators.ComparatorWearReverse;
import aiss.model.repository.UserRepository;
import aiss.model.titan.Objetivo;
import aiss.model.titan.User;

@Path("/objetivosDeportivos")
public class ObjetivosDeportivosResource {
	
	// Singleton
		private static ObjetivosDeportivosResource _instance=null;
		UserRepository repository;
		
		private ObjetivosDeportivosResource() {
			repository=UserRepository.getInstance();

		}
		
		public static ObjetivosDeportivosResource getInstance()
		{
			if(_instance==null)
					_instance=new ObjetivosDeportivosResource();
			return _instance;
		}
		
		@GET
		@Produces("application/json")
		public Collection<Objetivo> getAll(@QueryParam("order") String order, @QueryParam("q") String q){
			List<Objetivo> result=new ArrayList<>();
			
			for(Objetivo obj:repository.getObjetivosAplicacion()) {
				if(q==null || obj.getNombre().toLowerCase().contains(q.toLowerCase()))
					result.add(obj);
			}
			
			if(order!=null) {
				if(order.equals("-alfabetic"))
					Collections.sort(result, new ComparatorObjetivoReverse());
				else if(order.equals("wear"))
					Collections.sort(result, new ComparatorWear());
				else if(order.equals("-wear"))
					Collections.sort(result, new ComparatorWearReverse());
				else
					throw new BadRequestException("The order parameter must be '-alfabetic', 'wear' or '-wear'.");
			}
			
			return result;
		}
		
		@GET
		@Path("/{id}")
		@Produces("application/json")
		public Collection<Objetivo> getObjetivesFor(@PathParam("id") String id, @QueryParam("order") String order, 
				@QueryParam("q") String q){
			
			User u=repository.getUser(Integer.parseInt(id));
			
			if(u==null)
				throw new NotFoundException("User not found.");

			List<Objetivo> result=new ArrayList<>();
			List<Objetivo> objetivos=u.getObjetivos();
			
			if(objetivos==null) {
				return result;
			}else {
				for(Objetivo obj: objetivos) {
					if(q==null || obj.getNombre().toLowerCase().contains(q.toLowerCase()))
						result.add(obj);
				}
				
				if(order!=null) {
					if(order.equals("-alfabetic"))
						Collections.sort(result, new ComparatorObjetivoReverse());
					else if(order.equals("wear"))
						Collections.sort(result, new ComparatorWear());
					else if(order.equals("-wear"))
						Collections.sort(result, new ComparatorWearReverse());
					else
						throw new BadRequestException("The order parameter must be '-alfabetic', 'wear' or '-wear'.");
				}
				
				return result;
			}
		}
		
		@PUT
		@Path("/{id}")
		@Consumes("application/json")
		@Produces("application/json")
		public Response updateObjetives(@Context UriInfo uriInfo, @PathParam("id") String id, Collection<Objetivo> objetivos,
				@QueryParam("type") String type) {
			
		    User u=repository.getUser(Integer.parseInt(id));
			if(u==null)
				throw new NotFoundException("User not found.");
			
			if(type==null || (!type.equals("set") && !type.equals("unset")))
				throw new BadRequestException("The required type parameter must be 'set' or 'unset'.");
			
			if(u.getObjetivos()==null)
				u.setObjetivos(new ArrayList<Objetivo>());
			List<Objetivo> obj=u.getObjetivos();
			
			for(Objetivo o:objetivos) {
				Objetivo o1=repository.findByObjetiveName(o.getNombre());
				if(o1==null || !o1.getTipo().equals(o.getTipo()))
					throw new NotFoundException("Objetives not found in the application.");
				if(type.equals("set")) {
					if(!obj.contains(o1))
						obj.add(o1);
				}else {
					obj.remove(o1);
				}
			}
			
			URI uri = uriInfo.getAbsolutePath();
			ResponseBuilder resp = Response.created(uri);
			resp.entity(obj);
			return resp.build();
		}

}
