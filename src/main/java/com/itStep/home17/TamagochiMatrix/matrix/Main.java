/*Создать объект-матрицу целых чисел (квдратную). и методы, которые эту матрицу
анализируют - дают максимальное значение, сумму диагонали, сумму второй диагонали, 
минимальное значение, среднее...).  Выдают информацию -  сумму строк, всю строку с 
номером i как одномерный массив, всю матрицу как двумерный массив.   Видоизменяют - 
сортируют строки как угодно, прибавляют число N к строке номер i.

Усложнение - Матрица должна иметь метод, позволяющий прибавить к ней другую матрицу 
такого же размера (элементы с одинаковыми индексами складываются). При этом 
изменяется первая матрица. (можно дополнительно добавить метод, не изменяющий первую 
матрицу, а создающий внктри себя третью матрицу, и возвращающий её. )
 
Архиусложнение - то же самое, только не сложение, а умножение, по правилам высшей 
математики (гуглим умножение матрицы). Смысл усложнения в том, чтобы разобраться в 
том, что нагуглили, и составить алгоритм на этом основании.*/
package com.itStep.home17.TamagochiMatrix.matrix;

public class Main {
    public static void main(String[] args) {
	Matrix first = new Matrix();
	first.print();

	Matrix square = new Matrix(6);
	square.print();

	Matrix smallPositive = new Matrix(5, 5, 0);
	smallPositive.analize();
	smallPositive.sumOfLine(1);

	int[] line = smallPositive.takeLine(3);
	System.out.println(line[2]);

	int[][] foursquare = smallPositive.toArray();
	System.out.println(foursquare[4][4]);

	first.sortLine(4);
	first.print();
	square.sortColumn(2);
	square.print();
	smallPositive.sort();
	smallPositive.print();
	smallPositive.addToLine(1, 15);
	smallPositive.print();
	System.out.println();
	int[][] matrix = new int[smallPositive.length()][smallPositive.length()];
	init(matrix);

	int[][] newMatrix = new int[smallPositive.length()][smallPositive.length()];
	newMatrix = smallPositive.sumOfMatrix(matrix);
	print(newMatrix);

	smallPositive.addMatrix(matrix);
	System.out.println();
	smallPositive.print();
	System.out.println();
	int[][] multiplication = first.multiMatrix(matrix);
	print(multiplication);

    }

    private static void print(int[][] matrix) {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		System.out.print(matrix[i][j] + "\t");
	    }
	    System.out.print("\n\n");
	}
	System.out.println();
    }

    private static void init(int[][] matrix) {
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix[i].length; j++) {
		matrix[i][j] = (int) (Math.random() * matrix.length);
		System.out.print(matrix[i][j] + "\t");
	    }
	    System.out.print("\n\n");
	}
	System.out.println();
    }

}
