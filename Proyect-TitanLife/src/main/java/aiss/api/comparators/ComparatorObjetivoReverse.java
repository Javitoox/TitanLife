package aiss.api.comparators;

import java.util.Comparator;

import aiss.model.titan.Objetivo;

public class ComparatorObjetivoReverse implements Comparator<Objetivo>{

	@Override
	public int compare(Objetivo o1, Objetivo o2) {
		// TODO Auto-generated method stub
		return o2.getNombre().compareTo(o1.getNombre());
	}

}
