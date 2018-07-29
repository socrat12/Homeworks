package com.itStep.home04.square;

//13.	Определить, имеется ли среди трёх чисел
//a, b и c хотя бы одна  пара равных между собой чисел.
public class Task13 {

    public static void main(String[] args) {
	int a = 1, b = 16, c = 16;
	if (a == b || b == c || a == c) {
	    System.out.println("Yes");
	} else {
	    System.out.println("No");
	}
    }

}
