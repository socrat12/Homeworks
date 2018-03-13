//Дана целочисленная прямоугольная матрица. Определить:
//- количество столбцов, содержащих хотя бы один нулевой элемент;
//- номер строки, в которой находится самая длинная серия одинаковых элементов
package home14.sheepSleep;

public class Matrix {
    private static int[][] matrix = new int[5][6];

    public static void main(String[] args) {
	init();
	print();

	findZero();
	findRepeat();
    }

    private static void findRepeat() {
	int max = 1;
	// массив для учёта случаев одинакового количства повторяющихся
	// элементов в строках
	int[] numberLine = new int[matrix.length];
	for (int n = 0; n < matrix[0].length; n++) {
	    numberLine[n] = -1;
	}
	for (int i = 0; i < matrix.length; i++) {
	    int same = 1, maxTemp = 1;
	    for (int j = 1; j < matrix[i].length; j++) {
		same = 1;
		for (int k = j - 1; k >= 0; k--) {
		    if (matrix[i][j] == matrix[i][k]) {
			same++;
		    }
		}
		// максимум для данной строки
		maxTemp = Math.max(maxTemp, same);
	    }
	    if (maxTemp > max) {
		max = maxTemp;
		numberLine[0] = i;
		for (int n = 1; n < 5; n++) {
		    numberLine[n] = -1;
		}
	    } else if (maxTemp == max) {
		for (int n = 1; n < 5; n++) {
		    if (numberLine[n] == -1) {
			numberLine[n] = i;
			break;
		    }
		}
	    }
	}
	if (numberLine[0] == -1) {
	    System.out.println("No repeat in lines");
	} else {
	    System.out.print(max + " repeat in line " + (numberLine[0] + 1));
	    for (int n = 1; n < 5; n++) {
		if (numberLine[n] != -1) {
		    System.out.print(" and line " + (numberLine[n] + 1));
		} else {
		    break;
		}
	    }
	    System.out.println();
	}
    }

    private static void findZero() {
	int zeros = 0;
	for (int i = 0; i < matrix[0].length; i++) {
	    for (int j = 0; j < matrix.length; j++) {
		if (matrix[j][i] == 0) {
		    zeros++;
		    break;
		}
	    }
	}
	System.out.println("column with zero: " + zeros);
    }

    private static void init() {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		matrix[i][j] = (int) (Math.random() * matrix.length);
	    }
	}
    }

    private static void print() {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		System.out.printf("\t%d", matrix[i][j]);
	    }
	    System.out.printf("\n\n");
	}
    }
}
