package aiss.api.comparators;

import java.util.Comparator;

import aiss.model.titan.Comida;

public class ComparatorComidaCaloriasReverse implements Comparator<Comida>{

	@Override
	public int compare(Comida o1, Comida o2) {
		// TODO Auto-generated method stub
		return ((Integer)Integer.parseInt(o2.getCaloriasPor100())).compareTo(Integer.parseInt(o1.getCaloriasPor100()));
	}

}
