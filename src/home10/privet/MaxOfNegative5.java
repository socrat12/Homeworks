package home10.privet;
//В одномерном массиве,состоящем из n элементов, найти максимальный элемент среди
//отрицательных элементов массива
public class MaxOfNegative5 {
    private final static int MASSLENGTH = 10;

    public static void main(String[] args) {
	int[] mass = new int[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    mass[i] = (int) (Math.random() * MASSLENGTH * 2 - MASSLENGTH);
	}
	print(mass);

	maxOfNegative(mass);
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

    private static void maxOfNegative(int[] array) {
	int max = 0;

	for (int i = 0; i < MASSLENGTH; i++) {
	    if (array[i] < 0) {
		if (max == 0) {
		    max = array[i];
		}
		if (array[i] > max) {
		    max = array[i];
		}
	    }
	}
	if (max == 0) {
	    System.out.println("No negative number in array");
	} else {
	    System.out.println("Max of negative numbers: " + max);
	}
    }
}
