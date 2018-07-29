package com.itStep.home16.man;

import com.itStep.getInput.GetBinary;
import com.itStep.getInput.GetInt;

public class Main {

    static Man[] assembly = new Man[24];

    public static void main(String[] args) {

	init();

	System.out.println("What kind of sorting do you want?");
	System.out.printf("1. Name\n2. Age\n3. Weidth\n4. Sex\n");
	boolean wrong;
	// делать, пока не добьёшься правильного ввода
	do {
	    System.out.print(">>>>> ");
	    wrong = false;
	    switch (GetInt.get()) {
	    // сортировка по имени всего списка
	    case 1: {
		System.out.printf("1. Increase\n2. Decrease\n>>>> ");
		sortByName(0, assembly.length, GetBinary.getBool());
		break;
	    }
	    // сортировка по возрасту
	    case 2: {
		System.out.printf("1. Increase\n2. Decrease\n>>>> ");
		sortByNumbers(true, GetBinary.getBool());
		break;
	    }
	    // сортировка по весу
	    case 3: {
		System.out.printf("1. Increase\n2. Decrease\n>>>> ");
		sortByNumbers(false, GetBinary.getBool());
		break;
	    }
	    // сортировка по полу, с последующей сортитровкой по имени
	    case 4: {
		System.out.printf("Ho is first?\n1. Men\n2. Women\n>>>> ");
		sortBySex(GetBinary.getBool());
		break;
	    }
	    default: {
		wrong = true;
	    }
	    }
	} while (wrong);

	print();
    }

    private static void init() {
	for (int i = 0; i < assembly.length; i++) {
	    assembly[i] = new Man();
	}
	print();
    }

    private static void sortBySex(boolean man) {
	// если man true - сначала мужчины, затем женщины
	for (int i = 0; i < assembly.length - 1; i++) {
	    // если наткнулся на женщину,
	    if (assembly[i].sex != man) {
		for (int j = i + 1; j < assembly.length; j++) {
		    // поменять с первым втретившимся мужчиной
		    if (assembly[j].sex == man) {
			swap(i, j);
			break;
		    }
		}
	    }
	}
	// место где заканчиваются мужчины и начинаются женщины
	int i = 0;
	for (; i < assembly.length; i++) {
	    if (assembly[i].sex != man) {
		break;
	    }
	}
	System.out.printf("1. Increase\n2. Decrease\n>>>> ");
	boolean increase = GetBinary.getBool();
	// сортировка мужской половины
	sortByName(0, i, increase);
	// сортировка женской половины
	sortByName(i, assembly.length, increase);
    }

    private static void sortByNumbers(boolean choise, boolean increase) {
	boolean check = false;
	// choise - true, для сортировка по возрасту
	if (choise) {
	    for (int i = 0; i < assembly.length - 1; i++) {
		// по возрастанию или по убыванию
		if (increase) {
		    if (assembly[i].age > assembly[i + 1].age) {
			swap(i, i + 1);
			check = true;
		    }
		} else {
		    if (assembly[i].age < assembly[i + 1].age) {
			swap(i, i + 1);
			check = true;
		    }
		}
	    }
	    // choise - false, для сортировка по весу
	} else {
	    for (int i = 0; i < assembly.length - 1; i++) {
		// по возрастанию или по убыванию
		if (increase) {
		    if (assembly[i].weigth > assembly[i + 1].weigth) {
			swap(i, i + 1);
			check = true;
		    }
		} else {
		    if (assembly[i].weigth < assembly[i + 1].weigth) {
			swap(i, i + 1);
			check = true;
		    }
		}
	    }
	}
	// если не произведена ни одна замена за проход - завершить
	if (check) {
	    sortByNumbers(choise, increase);
	}
    }

    private static void sortByName(int start, int end, boolean increase) {
	for (int j = start; j < end - 1; j++) {
	    int min = j;
	    for (int i = j + 1; i < end; i++) {
		// сравнение строковых параметров
		if (compare(assembly[i].name, assembly[min].name, increase)) {
		    min = i;
		}
	    }
	    // если j-ый элемент и так миимальный
	    if (min != j) {
		swap(min, j);
	    }
	}
    }

    private static void swap(int i, int j) {
	Man change = assembly[i];
	assembly[i] = assembly[j];
	assembly[j] = change;
    }

    private static boolean compare(String string, String string2, boolean increase) {
	// определение минимальной длины из двух строк
	int minLength = Math.min(string.length(), string2.length());
	for (int i = 0; i < minLength; i++) {
	    // если начальная буква или последующие окажуться младше по
	    // алфавиту, нет смысле продолжать сравнение
	    if (string.charAt(i) < string2.charAt(i)) {
		// по возрастанию или по убыванию
		if (increase) {
		    return true;
		} else {
		    return false;
		}
	    }
	    // если одинаковые - продолжить, для сравнения следующих букв
	    else if (string.charAt(i) == string2.charAt(i)) {
		continue;
	    } else {
		// по возрастанию или по убыванию
		if (increase) {
		    return false;
		} else {
		    return true;
		}
	    }
	}
	return false;
    }

    private static void print() {
	for (int i = 0; i < assembly.length; i++) {
	    System.out.print(assembly[i].name + "\t- ");
	    System.out.print(assembly[i].age + " ages old, ");
	    System.out.print(assembly[i].weigth + " kilograms weidth, ");
	    if (assembly[i].sex) {
		System.out.println("male");
	    } else {
		System.out.println("female");
	    }
	}
    }
}
