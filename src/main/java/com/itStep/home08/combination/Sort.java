package com.itStep.home08.combination;

import com.itStep.getInput.GetInt;

public class Sort {

    public static void main(String[] args) {
	int amount;
	do {
	    System.out.print("Enter amount of numbers from 2 to 8: ");
	    // Читаем с клавиатуры размер массива
	    amount = GetInt.get();
	}
	// проверка правильности ввода
	while (amount < 2 || amount > 8);
	// Создаём массив размером amount
	int array[] = new int[amount];

	// Пройдёмся по всему массиву, заполняя его
	for (int i = 0; i < amount; i++) {
	    System.out.print("Enter " + (i + 1) + " number: ");
	    array[i] = GetInt.get();
	}
	System.out.println();
	print(amount, array);

	sort(0, amount, array);
	print(amount, array);
    }

    private static void sort(int k, int amount, int[] array) {
	for (int i = k + 1; i < amount; i++) {
	    int j = i - 1;
	    int buff = array[i];
	    while (j >= k && buff < array[j]) {
		array[j + 1] = array[j];
		j--;
	    }
	    array[j + 1] = buff;
	}
    }

    private static void print(int amount, int[] array) {
	for (int k = 0; k < amount; k++) {
	    System.out.print(array[k] + "|");
	}
	System.out.println();
    }
}
