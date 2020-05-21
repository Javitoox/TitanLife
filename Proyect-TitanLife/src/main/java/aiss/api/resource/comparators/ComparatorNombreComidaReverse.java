package aiss.api.resource.comparators;

import java.util.Comparator;

import aiss.model.titan.Comida;

public class ComparatorNombreComidaReverse implements Comparator<Comida>{

	@Override
	public int compare(Comida o1, Comida o2) {
		// TODO Auto-generated method stub
		return o2.getNombre().compareTo(o1.getNombre());
	}

}
