package aiss.api.comparators;

import java.util.Comparator;

import aiss.model.titan.Objetivo;

public class ComparatorWear implements Comparator<Objetivo>{

	@Override
	public int compare(Objetivo o1, Objetivo o2) {
		// TODO Auto-generated method stub
		return o1.getTipo().toString().compareTo(o2.getTipo().toString());
	}

}
