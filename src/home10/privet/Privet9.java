package home10.privet;

//Определить в одномерном числовом массиве A из n элементов типа чар, сколько раз в нем встречается последовательность ‘p’, ‘r’,’i’,’v’,’e’,’t’
//Усложнение - в любом регистре, сохранив при этом оригинальный массив неизменным
//Усложнение 2 - в любом регистре, сохранив при этом оригинальный массив неизменным, и не используя другого массива длинной более 6.
public class Privet9 {
    private final static int MASSLENGTH = 300000;

    public static void main(String[] args) {
	char[] mass = new char[MASSLENGTH];
	boolean found = false;

	// не завершать программу, пока не найдёт
	while (!found) {
	    for (int i = 0; i < MASSLENGTH; i++) {
		// случайные большие и маленькие буквы
		mass[i] = (char) (65 + 32 * (int) (Math.random() * 2) + (int) (Math.random() * 26));
	    }
	    print(mass);
	    long time = System.currentTimeMillis();
	    findOK(mass);
	    System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0);
	}
    }

    private static void print(char[] array) {
	int counter = 0;
	for (int k = 0; k < MASSLENGTH; k++) {
	    System.out.print(array[k] + "|");
	    counter++;
	    if (counter % 25 == 0) {
		System.out.println();
	    }
	}
	System.out.println();
    }

    private static boolean findOK(char[] mass) {
	// количество последовательностей privet
	int amount = 0;
	for (int i = 0; i < MASSLENGTH - 5; i++) {
	    if ((mass[i] == 'P' || mass[i] == 'p') && (mass[i + 1] == 'R' || mass[i + 1] == 'r')
		    && (mass[i + 2] == 'I' || mass[i + 2] == 'i') && (mass[i + 3] == 'V' || mass[i + 3] == 'v')
		    && (mass[i + 4] == 'E' || mass[i + 4] == 'e') && (mass[i + 5] == 'T' || mass[i + 5] == 't')) {
		System.out.println((char) mass[i] + " " + (char) mass[i + 1] + " " + (char) mass[i + 2] + " "
			+ (char) mass[i + 3] + " " + (char) mass[i + 4] + " " + (char) mass[i + 5]);
		amount++;
	    }
	}
	System.out.println("The sequence privet is encountered " + amount + " times");
	if (amount != 0) {
	    return true;
	}
	return false;
    }
}
