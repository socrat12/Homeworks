package home16.man;

import getInput.GetBinary;
import getInput.GetInt;

public class Main2 {

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
		if (GetBinary.getBool()) {
		    sortOther(1, 1, 0, assembly.length);
		} else {
		    sortOther(1, -1, assembly.length - 1, -1);
		}
		break;
	    }
	    // сортировка по возрасту
	    case 2: {
		System.out.printf("1. Increase\n2. Decrease\n>>>> ");
		if (GetBinary.getBool()) {
		    sortOther(2, 1, 0, assembly.length);
		} else {
		    sortOther(2, -1, assembly.length - 1, -1);
		}
		break;
	    }
	    // сортировка по весу
	    case 3: {
		System.out.printf("1. Increase\n2. Decrease\n>>>> ");
		if (GetBinary.getBool()) {
		    sortOther(3, 1, 0, assembly.length);
		} else {
		    sortOther(3, -1, assembly.length - 1, -1);
		}
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
	if (GetBinary.getBool()) {
	    sortOther(1, 1, 0, i);
	    sortOther(1, 1, i, assembly.length);
	} else {
	    sortOther(1, -1, assembly.length - 1, i);
	    sortOther(1, -1, i, -1);
	}
    }

    private static void sortOther(int choise, int direction, int start, int end) {
	boolean check = false;
	for (int i = start; i != end - direction; i += direction) {
	    switch (choise) {
	    // choise - 2, для сортировка по имени
	    case 1: {
		if (compare(assembly[i].name, assembly[i + direction].name)) {
		    swap(i, i + direction);
		    check = true;
		}
		break;
	    }
	    // choise - 2, для сортировка по возрасту
	    case 2: {
		if (assembly[i].age > assembly[i + direction].age) {
		    swap(i, i + direction);
		    check = true;
		}
		break;
	    }
	    // choise - 3, для сортировка по весу
	    case 3: {
		if (assembly[i].weigth > assembly[i + direction].weigth) {
		    swap(i, i + direction);
		    check = true;
		}
		break;
	    }
	    case 4: {

	    }
	    }
	}
	// если не произведена ни одна замена за проход - завершить
	if (check) {
	    sortOther(choise, direction, start, end);
	}
    }

    private static void swap(int i, int j) {
	Man change = assembly[i];
	assembly[i] = assembly[j];
	assembly[j] = change;
    }

    private static boolean compare(String string, String string2) {
	// определение минимальной длины из двух строк
	int minLength = Math.min(string.length(), string2.length());
	for (int i = 0; i < minLength; i++) {
	    // если начальная буква или последующие окажуться младше по
	    // алфавиту, нет смысле продолжать сравнение
	    if (string.charAt(i) > string2.charAt(i)) {
		return true;
	    }
	    // если одинаковые - продолжить, для сравнения следующих букв
	    else if (string.charAt(i) == string2.charAt(i)) {
		continue;
	    } else {
		return false;
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