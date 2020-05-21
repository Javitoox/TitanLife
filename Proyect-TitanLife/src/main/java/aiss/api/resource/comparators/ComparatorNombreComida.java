package aiss.api.resource.comparators;

import java.util.Comparator;

import aiss.model.titan.Comida;

public class ComparatorNombreComida implements Comparator<Comida>{

	@Override
	public int compare(Comida o1, Comida o2) {
		// TODO Auto-generated method stub
		return o1.getNombre().compareTo(o2.getNombre());
	}

}
