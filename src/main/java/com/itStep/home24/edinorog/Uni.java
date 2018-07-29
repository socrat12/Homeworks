package com.itStep.home24.edinorog;

import java.util.Comparator;

public class Uni implements Comparator<Uni>{
    public int amount;
    public char color;
    
    public Uni(int amount, char color) {
	this.amount = amount;
	this.color = color;
    }
    
    @Override
    public String toString() {
	String string = new String();
	
	string += color + ": ";
	string += amount;
	
	return string;
    }

    @Override
    public int compare(Uni o1, Uni o2) {
	 if (o1.amount < o2.amount) {
		return 1;
	    } else if (o1.amount == o2.amount) {
		return 0;
	    } else {
		return -1;
	    }
    }
}
