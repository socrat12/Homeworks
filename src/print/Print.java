package print;

public class Print {
    public static void printArrayInt(int[] array) {
	int count = 0;
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + " ");
	    count++;
	    if (count == 20) {
		System.out.println();
	    }
	}
	System.out.println();
    }

    public static void printArrayChar(char[] array) {
	int count = 0;
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + " ");
	    count++;
	    if (count == 20) {
		System.out.println();
	    }
	}
	System.out.println();
    }

    public static void printIntArray2D(int[][] array) {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		System.out.print(array[i][j] + " ");
	    }
	    System.out.println();
	}
	System.out.println();
    }
}