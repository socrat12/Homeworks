package home10.privet;
//Подсчитайте, сколько раз встречается в одномерном массиве А, состоявшемся из n элементов,
//максимальное по величине число 
public class MaxOften6 {
    private final static int MASSLENGTH = 10;

    public static void main(String[] args) {
	int[] mass = new int[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    mass[i] = (int) (Math.random() * MASSLENGTH);
	}
	print(mass);

	maxFind(mass);

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

    private static void maxFind(int[] array) {
	int amount = 1, max = array[0];
	for (int i = 1; i < MASSLENGTH; i++) {
	    if (array[i] == max) {
		amount++;
	    }
	    if (array[i] > max) {
		max = array[i];
		amount = 1;
	    }
	}
	System.out.println("Max number occurs in an array " + amount + " times");
    }
}
