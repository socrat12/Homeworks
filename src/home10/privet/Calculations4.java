package home10.privet;
//В одномерном массиве,состоящем из n вещественных элементов, вычислить: 
//- сумму отрицательных элементов массива;
//- произведение элементов массива расположнных между максимальным и минимальным элементами
public class Calculations4 {
    private final static int MASSLENGTH = 10;

    public static void main(String[] args) {
	double[] mass = new double[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    mass[i] = (Math.random() * MASSLENGTH * 2 - MASSLENGTH);
	}
	print(mass);

	sum(mass);

	comp(mass);
    }

    private static void print(double[] array) {
	int counter = 0;
	for (int k = 0; k < array.length; k++) {
	    System.out.printf("%.2f|", array[k]);
	    counter++;
	    if (counter % 25 == 0) {
		System.out.println();
	    }
	}
	System.out.println();
    }

    private static void comp(double[] array) {
	int minIndex = 0, maxIndex = 0;
	double comp = 1;

	for (int i = 0; i < MASSLENGTH; i++) {
	    if (array[i] < array[minIndex]) {
		minIndex = i;
	    }
	    if (array[i] >= array[maxIndex]) {
		maxIndex = i;
	    }
	}

	boolean check = false;
	if (minIndex < maxIndex) {
	    for (int i = minIndex + 1; i < maxIndex; i++) {
		comp *= array[i];
		check = true;
	    }
	} else {
	    for (int i = maxIndex + 1; i < minIndex; i++) {
		comp *= array[i];
		check = true;
	    }
	}
	if (!check) {
	    System.out.println("No elements beetween min and max");
	} else {
	    System.out.printf("Composition is %.2f\n", comp);
	}
    }

    private static void sum(double[] array) {
	double sum = 0;
	for (int i = 0; i < MASSLENGTH; i++) {
	    if (array[i] < 0) {
		sum += array[i];
	    }
	}
	System.out.printf("Sum is %.2f\n", sum);
    }
}
