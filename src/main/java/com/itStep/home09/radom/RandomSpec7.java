package com.itStep.home09.radom;
//Заполнить массив из 10 чисел типа int случайными значениями от 10 до 20. 
//(использовать Math.random(), математически преобразовав его результаты)

public class RandomSpec7 {

    public static void main(String[] args) {
	int[] mass = new int[10];

	for (int i = 0; i < mass.length; i++) {
	    mass[i] = (int) (10*(Math.random())  + 10);
	}

	print(mass);
    }

    private static void print(int[] mass) {
	for (int k = 0; k < mass.length; k++) {
	    System.out.print(mass[k] + "|");
	}
	System.out.println();
    }
}
