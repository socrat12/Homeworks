package com.itStep.home17.TamagochiMatrix.matrix;

public class Matrix {
    private int[][] array;

    // конструктор по умолчанию
    public Matrix() {
	array = new int[5][5];
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = (int) (Math.random() * 100 - 50);
	    }
	}
    }

    // конструктор с одним параметром
    public Matrix(int size) {
	array = new int[size][size];
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = (int) (Math.random() * array.length * 10 - array.length * 5);
	    }
	}
    }

    //// конструктор с двумя параметрами
    public Matrix(int size, int values, int sign) {
	array = new int[size][size];
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = (int) (Math.random() * values + sign * values / 2);
	    }
	}
    }

    // вывод массива
    public void print() {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		System.out.print(array[i][j] + "\t");
	    }
	    System.out.print("\n\n");
	}
    }

    // нахождение масимального числа в массиве
    public int max() {
	int max = -2147483648;
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (array[i][j] > max) {
		    max = array[i][j];
		}
	    }
	}
	return max;
    }

    // нахождение минимального числа в массиве
    public int min() {
	int min = 2147483647;
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		if (array[i][j] < min) {
		    min = array[i][j];
		}
	    }
	}
	return min;
    }

    // нахождение среднего арифметического массива
    public double average() {
	double sum = 0;
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		sum += array[i][j];
	    }
	}
	return sum / (array.length * array.length);
    }

    // сумма диагоналей
    public int sumOfDiagonal(int numberOfDiagonal) {
	int sum = 0;
	for (int i = 0; i < array.length; i++) {
	    if (numberOfDiagonal == 1) {
		sum += array[i][i];
	    } else if (numberOfDiagonal == 2) {
		sum += array[i][array.length - i - 1];
	    } else {
		System.err.println("Wrong diagonal!");
	    }
	}
	return sum;
    }

    // вывод основных характеристик массива
    public void analize() {
	print();
	System.out.println("Maximum: " + max());
	System.out.println("Minimum: " + min());
	System.out.printf("Average: %.3f\n", average());
	System.out.println("Sum of first diagonal: " + sumOfDiagonal(1));
	System.out.println("Sum of second diagonal: " + sumOfDiagonal(2));
    }

    // сумма определённой строки
    public void sumOfLine(int numberOfLine) {
	int sum = 0;
	numberOfLine -= 1;
	if (numberOfLine < array.length && numberOfLine >= 0) {
	    for (int j = 0; j < array.length; j++) {
		sum += array[numberOfLine][j];
	    }
	    System.out.println("Sum of line " + (numberOfLine + 1) + " is " + sum);
	} else {
	    System.err.println("Can't find line " + (numberOfLine + 1));
	}
    }

    // сумма определённого столбца
    public int[] takeLine(int numberOfLine) {
	int[] temp = new int[array.length];
	numberOfLine -= 1;
	if (numberOfLine < array.length && numberOfLine >= 0) {
	    for (int j = 0; j < array.length; j++) {
		temp[j] = array[numberOfLine][j];
	    }
	    return temp;
	} else {
	    System.err.println("Can't find line " + (numberOfLine + 1));
	}
	return temp;
    }

    // возвращает двумерный массив из объекта
    public int[][] toArray() {
	return array;
    }

    // сортировка строк
    public void sortLine(int numberOfLine) {
	numberOfLine -= 1;
	if (numberOfLine < array.length && numberOfLine >= 0) {
	    for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < array.length - 1; j++) {
		    if (array[numberOfLine][j] > array[numberOfLine][j + 1]) {
			swap(numberOfLine, j, numberOfLine, j + 1);
		    }
		}
	    }
	} else if (numberOfLine == -1) {
	    for (int i = 0; i < array.length; i++) {
		sortLine(i + 1);
	    }
	} else {
	    System.err.println("Can't find line " + (numberOfLine + 1));
	}
    }

    // сортировка столбцов
    public void sortColumn(int numberOfColumn) {
	numberOfColumn -= 1;
	if (numberOfColumn < array.length && numberOfColumn >= 0) {
	    for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < array.length - 1; j++) {
		    if (array[j][numberOfColumn] > array[j + 1][numberOfColumn]) {
			swap(j, numberOfColumn, j + 1, numberOfColumn);
		    }
		}
	    }
	} else if (numberOfColumn == -1) {
	    for (int i = 0; i < array.length; i++) {
		sortColumn(i + 1);
	    }
	} else {
	    System.err.println("Can't find line " + (numberOfColumn + 1));
	}
    }

    // сортировка всего массива
    public void sort() {
	int[] temp = new int[array.length * array.length];
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		temp[i * 5 + j] = array[i][j];
	    }
	}

	for (int j = 0; j < temp.length; j++) {
	    boolean check = false;
	    for (int i = 0; i < temp.length - 1; i++) {
		if (temp[i] > temp[i + 1]) {
		    int change = temp[i];
		    temp[i] = temp[i + 1];
		    temp[i + 1] = change;
		    check = true;
		}
	    }
	    if (!check)
		break;
	}

	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] = temp[i * 5 + j];
	    }
	}
    }

    private void swap(int i, int j, int k, int m) {
	int change = array[i][j];
	array[i][j] = array[k][m];
	array[k][m] = change;
    }

    // прибавить число к строке
    public void addToLine(int numberOfLine, int n) {
	numberOfLine -= 1;
	for (int j = 0; j < array.length; j++) {
	    array[numberOfLine][j] += n;
	}
    }

    // прибавить массив к массиву
    public void addMatrix(int[][] matrix) {
	for (int i = 0; i < array.length; i++) {
	    for (int j = 0; j < array[i].length; j++) {
		array[i][j] += matrix[i][j];
	    }
	}
    }

    // сложить два массива, результат передать в третий массив
    public int[][] sumOfMatrix(int[][] matrix) {
	int[][] temp = new int[matrix.length][matrix.length];
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		temp[i][j] = array[i][j] + matrix[i][j];
		System.out.print(array[i][j] + "+" + matrix[i][j] + "/" + temp[i][j] + " ");
	    }
	    System.out.println();
	}
	return temp;
    }

    // возващает длину массива объекта
    public int length() {
	return array.length;
    }

    // умножение массивов
    public int[][] multiMatrix(int[][] matrix) {
	int[][] temp = new int[matrix.length][matrix.length];

	if (array[0].length == matrix.length) {
	    for (int i = 0; i < array.length; i++) {
		for (int j = 0; j < matrix[0].length; j++) {
		    for (int k = 0; k < matrix.length; k++) {
			temp[i][j] += array[i][k] * matrix[k][j];
		    }
		}
	    }
	} else {
	    System.out.println("Wrong size");
	}
	return temp;
    }

}
