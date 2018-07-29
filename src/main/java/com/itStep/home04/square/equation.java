package com.itStep.home04.square;

//Решить квадратное уравнение методом полного перебора всех чисел от -100000 до +100000 с шагом 0.1. 
public class equation {

    public static void main(String[] args) {
	double a = 2, b = 4, c = 2;
	double d = b * b - 4 * a * c;
	double xOne = (-b) / 2 * a, xTwo = (-b) / 2 * a;

	if (d == 0) {
	    System.out.println("X is " + ((-b) / (2 * a)));
	} else if (d > 0) {
	    xOne = ((-b) + Math.sqrt(d)) / (2 * a);
	    xTwo = ((-b) - Math.sqrt(d)) / (2 * a);
	    System.out.println("x1 is " + xOne);
	    System.out.println("x2 is " + xTwo);
	} else {
	    System.out.println("No answer");
	}
    }

}
