package com.itStep.home08.combination;
//Упорядочить массив случайных чисел по возрастанию. 
public class SortSelection {
    private final static int MASSLENGTH = 1000;

    public static void main(String[] args) {
	int[] mass = new int[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    mass[i] = (int) (Math.random() * MASSLENGTH);
	}

	print(mass);
	sort(0, mass);
	System.out.println();
	print(mass);
    }

    private static void sort(int j, int[] array) {
	if (j == array.length - 1) {
	    return;
	}
	int min = j;
	for (int i = j; i < array.length; i++) {
	    if (array[i] < array[min]) {
		min = i;
	    }
	}
	swap(min, j, array);
	sort(j + 1, array);
    }

    private static void print(int[] array) {
	int counter = 0;
	for (int k = 0; k < array.length; k++) {
	    System.out.print(array[k] + "|");
	    counter++;
	    if (counter % 25 == 0) {
		System.out.println();
	    }
	}
	System.out.println();
    }

    private static void swap(int i, int j, int[] array) {
	int change = array[i];
	array[i] = array[j];
	array[j] = change;
    }
}
