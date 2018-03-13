package home08.combination;

//10 чисел из 4 комбинаций
public class Combination100 {
    public static void main(String[] args) {
	int array[] = new int[10];

	// Пройдёмся по всему массиву, заполняя его
	for (int i = 0; i < array.length; i++) {
	    array[i] = 0;
	}
	// перебор всех комбинаций
	pick(0, array);
    }

    private static void pick(int i, int[] array) {
	if (i == array.length) {
	    return;
	}
	for (int k = 1; k <= 4; k++) {
	    array[i] = k;
	    pick(i + 1, array);
	    print(array);
	}
    }

    private static void print(int[] array) {
	// количество комбинаций
	for (int k = 0; k < array.length; k++) {
	    System.out.print(array[k] + "|");
	}
	System.out.println();
    }
}
