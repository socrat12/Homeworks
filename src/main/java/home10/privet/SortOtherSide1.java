package home10.privet;
// Переписать сортировку массива так, чтобы он сортировался не слева направо, подставляя соответствующие
// минимальные значения. А справа налево,  подставляя соответствующие максимальные значения.
public class SortOtherSide1 {
    private final static int MASSLENGTH = 30;

    public static void main(String[] args) {
	int[] mass = new int[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    mass[i] = (int) (Math.random() * MASSLENGTH);
	}

	print(mass);

	sort(mass);

	print(mass);
    }

    private static void sort(int[] array) {
	for (int j = MASSLENGTH - 1; j > 0; j--) {
	    int max = j;
	    for (int i = j - 1; i >= 0; i--) {
		if (array[i] > array[max]) {
		    max = i;
		}
	    }
	    if (max != j) {
		swap(max, j, array);
	    }
	}
    }

    private static void print(int[] array) {
	int counter = 0;
	for (int k = 0; k < MASSLENGTH; k++) {
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
