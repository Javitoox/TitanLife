package aiss.api.resource.comparators;

import java.util.Comparator;

import aiss.model.titan.Objetivo;

public class ComparatorWearReverse implements Comparator<Objetivo>{

	@Override
	public int compare(Objetivo o1, Objetivo o2) {
		// TODO Auto-generated method stub
		return o2.getTipo().toString().compareTo(o1.getTipo().toString());
	}

}
