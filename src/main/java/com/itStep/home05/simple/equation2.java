package com.itStep.home05.simple;
//Task 2: Составьте алгоритм решения неравенства Ax^2 + Bx + C < 0; 
public class equation2 {

    public static void main(String[] args) {
	double a = -5, b = 3, c = -2;
	double d = b * b - 4 * a * c;
	double xOne, xTwo;

	if (d == 0 || (a > 0 && d < 0)) {
	    System.out.println("No answer");
	} else if (a < 0 && d < 0) {
	    System.out.println("x can be any real number");
	} else {
	    xOne = ((-b) - Math.sqrt(d)) / (2 * a);
	    xTwo = ((-b) + Math.sqrt(d)) / (2 * a);
	    if (a > 0) {
		System.out.println(xOne + " <= x <= " + xTwo);
	    }
	    if (a < 0) {
		System.out.println("x1 <= " + xOne);
		System.out.println("x2 >= " + xTwo);
	    }
	}
    }

}
