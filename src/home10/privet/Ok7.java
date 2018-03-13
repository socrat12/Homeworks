package home10.privet;
//Определить в одномерном числовом массиве A из n элементов типа чар, сколько раз в нем 
//встречается последовательность ‘O’, ‘K’
public class Ok7 {
    private final static int MASSLENGTH = 10000;

    public static void main(String[] args) {
	int[] mass = /* {'O', 'K', 'O', 'K', 'O', 'K', 'L', 'O', 'P','K'} */new int[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    mass[i] = (char) (65 + 32 * (int) (Math.random() * 2) + (int) (Math.random() * 26));
	}
	print(mass);

	findOK(mass);

    }

    private static void print(int[] array) {
	int counter = 0;
	for (int k = 0; k < array.length; k++) {
	    System.out.print((char) array[k] + "|");
	    counter++;
	    if (counter % 25 == 0) {
		System.out.println();
	    }
	}
	System.out.println();
    }

    private static void findOK(int[] array) {
	int amount = 0;
	for (int i = 0; i < array.length - 1; i++) {
	    if (array[i] == 'O' && array[i + 1] == 'K') {
		amount++;
	    }
	}
	System.out.println("The sequence OK is encountered " + amount + " times");
    }
}
