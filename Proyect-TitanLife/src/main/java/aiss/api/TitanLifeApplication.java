package aiss.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import aiss.api.resources.ObjetivosDeportivosResource;
import aiss.api.resources.UserResource;


public class TitanLifeApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public TitanLifeApplication() {
		singletons.add(UserResource.getInstance());
		singletons.add(ObjetivosDeportivosResource.getInstance());
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
