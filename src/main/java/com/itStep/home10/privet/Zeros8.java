package com.itStep.home10.privet;
//В массиве, состоящем из n элементов, вычислить: Сумму элементов массива, расположенных 
//между первым и последним нулевыми элементами. Если таких нулей нет - то ответ 0.
public class Zeros8 {
    private final static int MASSLENGTH = 10;

    public static void main(String[] args) {
	int[] mass = new int[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    mass[i] = (int) (Math.random() * MASSLENGTH * 2 - MASSLENGTH);
	}
	print(mass);

	find(mass);
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

    private static void find(int[] array) {
	int index0 = -1, index1 = -1;
	for (int i = 0; i < MASSLENGTH; i++) {
	    if (array[i] == 0) {
		if (index0 < 0) {
		    index0 = i;
		} else {
		    index1 = i;
		}
	    }
	}
	if (index1 > 0) {
	    sum(index0 + 1, index1, array);
	} else {
	    System.out.println("That array have not pair of zeros");
	    // System.exit(0);
	}
    }

    private static void sum(int k, int m, int[] array) {
	int sum = 0;
	for (int i = k; i < m; i++) {
	    sum += array[i];
	}
	System.out.println("Sum is " + sum);
    }
}
