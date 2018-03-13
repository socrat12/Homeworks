package home10.privet;
//Создать двухмерный массив прямоугольный массив. Посчитать сумму его цифр
public class Rectangle10 {
    private final static int MASSLINE = 3;
    private final static int MASSCOLUMN = 5;

    public static void main(String[] args) {
	int[][] mass = new int[MASSLINE][MASSCOLUMN];
	for (int i = 0; i < MASSLINE; i++) {
	    for (int j = 0; j < MASSCOLUMN; j++) {
		mass[i][j] = (int) (Math.random() * MASSCOLUMN);
	    }
	}

	print(mass);
	sum(mass);
    }

    private static void sum(int[][] array) {
	int sum = 0;
	for (int i = 0; i < MASSLINE; i++) {
	    for (int j = 0; j < MASSCOLUMN; j++) {
		sum += array[i][j];
	    }
	}
	System.out.println("Sum is " + sum);
    }

    private static void print(int[][] array) {
	for (int k = 0; k < MASSLINE; k++) {
	    for (int j = 0; j < MASSCOLUMN; j++) {
		if (j == 0) {
		    System.out.println();
		}
		System.out.print(array[k][j] + "|");
	    }
	}
	System.out.println();
    }
}
