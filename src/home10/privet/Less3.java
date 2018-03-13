package home10.privet;

import getInput.GetInt;

//заданы два массива А(5) и В(5). Подсчитать в них количество элементов, меньших значения
//t и первым на печать вывести массив, имеющий наибольшее их количество. 
public class Less3 {
	
    private final static int MASSLENGTH = 5;

    public static void main(String[] args) {
	int[] A = new int[MASSLENGTH];
	int[] B = new int[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    A[i] = (int) (Math.random() * 20);
	    B[i] = (int) (Math.random() * 20);
	}

	System.out.println("Please, input number");
	System.out.print(">>> ");
	int t = GetInt.get();

	score(t, A, B);
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

    private static void score(int t, int[] array0, int[] array1) {
	int counter0 = 0, counter1 = 0;
	for (int i = 0; i < MASSLENGTH; i++) {
	    if (array0[i] < t) {
		counter0++;
	    }
	    if (array1[i] < t) {
		counter1++;
	    }
	}

	if (counter0 < counter1) {
	    print(array1);
	    print(array0);
	} else if (counter1 < counter0) {
	    print(array0);
	    print(array1);
	} else {
	    System.out.println("Amount of elements less than " + t + " is the same");
	    print(array0);
	    print(array1);
	}
    }
}
