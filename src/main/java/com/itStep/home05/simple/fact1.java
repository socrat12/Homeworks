package com.itStep.home05.simple;
//Task 1: Написать программу, которая считает факториал числа. 
//Это важное ДЗ, в четверг будет 2 продолжения этой задачи. 
public class fact1 {
    public static void main(String[] args) {
	long factorial = 1;
	int number = 14;

	for (int i = 1; i <= number; i++) {
	    factorial *= i;
	}
	System.out.println("Factorial " + number + " is " + factorial);
    }

}
