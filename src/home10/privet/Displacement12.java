package home10.privet;

import getInput.GetInt;

//придумать, как сделать наше смещения на К символов вправо намного быстрее,

//чем смещать к раз по 1, без использования второго массива того же размера 
//(но можно использовать второй массив меньшего размера, если найдется такой способ)

public class Displacement12 {
    private final static int MASSLENGTH = 100;

    public static void main(String[] args) {
	int[] mass = new int[MASSLENGTH];

	for (int i = 0; i < MASSLENGTH; i++) {
	    mass[i] = i + 1;
	}
	print(mass);

	System.out.println("What amount of position you want to move?");
	System.out.print(">>> ");
	int k = GetInt.get();

	// нет смысла "гонять" смещение по кругу
	if (k > MASSLENGTH || k < MASSLENGTH) {
	    k = k % MASSLENGTH;
	}
	// сдвинуть на минус k знаков вправо, всё равно что сдвинуть на k знаков
	// влево
	if (k < 0) {
	    k = MASSLENGTH + k;
	}
	// если количество элементов смещения больше половины массива,
	// целесообразнее
	// будет сместить его на длину (массива - смещение) но в другую сторону
	// таким образом, даже в самых "плохих" случаях (при к -> n) второй
	// массив
	// никогда не будет болььше половины длины оригинального массива
	if (k > MASSLENGTH / 2) {
	    k = MASSLENGTH - k;
	    displaceLeft(k, mass);
	} else {
	    displaceRight(k, mass);
	}

	print(mass);
    }

    private static void print(int[] array) {
	int counter = 0;
	for (int k = 0; k < array.length; k++) {
	    System.out.print(array[k] + "|");
	    counter++;
	    if (counter % 25 == 0) {
		System.out.println();
	    }
	}
	System.out.println();
    }

    private static void displaceRight(int k, int[] array) {
	// создаём временный масив, размером со смещение
	int[] temp = new int[k];

	for (int i = MASSLENGTH - 1; i >= 0; i--) {
	    if (i < k) {
		// извлечение отрезка k из temp
		array[i] = temp[k - 1 - i];
		continue;
	    }
	    // записать элементы, которые будут "затёрты" во временный архив (k
	    // элементов от конца архива)
	    if (i > MASSLENGTH - 1 - k) {
		// последний элемент в array становится первым в temp и т.д.
		temp[Math.abs(i + 1 - MASSLENGTH)] = array[i];
	    }
	    // смещаем элементы вправо
	    array[i] = array[i - k];
	}
    }

    private static void displaceLeft(int k, int[] array) {
	// создаём временный масив, размером со смещение
	int[] temp = new int[k];

	for (int i = 0; i < MASSLENGTH; i++) {
	    if (i < k) {
		// записать элементы, которые будут "затёрты" во временный архив
		// (k элементов от начала архива)
		temp[i] = array[i];
		continue;
	    }
	    // смещаем элементы влево
	    array[i - k] = array[i];

	    if (i > MASSLENGTH - 1 - k) {
		// извлечение отрезка k из temp
		array[i] = temp[Math.abs(MASSLENGTH - k - i)];
	    }
	}
    }
}