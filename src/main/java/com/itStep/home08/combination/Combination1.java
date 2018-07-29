//Построить алгоритм, выдающий без повторений все перестановки N чисел
package com.itStep.home08.combination;

import com.itStep.getInput.GetInt;

public class Combination1 {
    private static int count = 0;

    public static void main(String[] args) {
	int amount;
	do {
	    System.out.print("Enter amount of numbers: ");
	    // Читаем с клавиатуры размер массива
	    amount = GetInt.get();
	}
	// проверка правильности ввода
	while (amount < 2);
	// Создаём массив размером size
	int array[] = new int[amount];

	// Пройдёмся по всему массиву, заполняя его
	for (int i = 0; i < amount; i++) {
	    System.out.print("Enter " + (i + 1) + " number: ");
	    array[i] = GetInt.get();
	}
	System.out.println();

	// сортировка элементов
	sort(0, array);
	// вывод массива
	print(array);
	// перебор всех комбинаций
	while (pick(array))
	    ;
    }

    private static boolean pick(int[] array) {
	int i, j;
	for (i = array.length - 1; i > 0 && array[i - 1] >= array[i]; i--)
	    ;

	if (i == 0) {
	    return false;
	}

	for (j = array.length - 1; array[i - 1] >= array[j]; j--)
	    ;

	swap(i - 1, j, array);
	sort(i, array);
	print(array);

	return true;
    }

    private static void sort(int k, int[] array) {
	for (int i = k + 1; i < array.length; i++) {
	    int j = i - 1;
	    int buff = array[i];
	    while (j >= k && buff < array[j]) {
		array[j + 1] = array[j];
		j--;
	    }
	    array[j + 1] = buff;
	}
    }

    private static void print(int[] array) {
	// количество комбинаций
	count++;
	System.out.print(count + ": ");
	for (int k = 0; k < array.length; k++) {
	    System.out.print(array[k] + "|");
	}
	System.out.println();
    }

    private static void swap(int i, int j, int[] array) {
	int change = array[i];
	array[i] = array[j];
	array[j] = change;
    }

}
