package home10.privet;

import getInput.GetInt;

//Определить круизную скорость для лошади Энни
public class CruiseControl11 {
    public static void main(String[] args) {
	System.out.print("Input amount of tests: ");
	int loop = GetInt.get();
	while (loop != 0) {
	    System.out.print("Input the destination: ");
	    int destination = GetInt.get();
	    System.out.print("Input amount of horses: ");
	    int k = GetInt.get();

	    int[] horses = new int[k * 2];

	    // массив в котором каждый первый элемент - стартовая позиция i-ой
	    // лошади,
	    // каждый второй - её скорость
	    for (int i = 0; i < horses.length; i += 2) {
		System.out.print("Input position of " + (i / 2 + 1) + " horse: ");
		horses[i] = GetInt.get();
		System.out.print("Input speed of " + (i / 2 + 1) + " horse: ");
		horses[i + 1] = GetInt.get();
	    }
	    // print(horses);

	    // отсортировать постепени близости к финишу, ведь лошади не могут
	    // обгонять друг друга
	    sort(horses);

	    int hours = 0;
	    // пока не приехала самая дальяняя лошадь
	    while (horses[0] < destination) {
		for (int i = horses.length - 2; i >= 0; i -= 2) {
		    // если лошадь пытается обогнать впереди идущую - сравнять
		    // их
		    // скорости и позиции: одна теперь следует шаг в шаг за
		    // другой
		    if (i != horses.length - 2 && horses[i] + horses[i + 1] > horses[i + 2] && horses.length != 2) {
			horses[i + 1] = horses[i + 3];
			horses[i] = horses[i + 2];
		    }
		    // продвинуться вперёд соответственно скорости
		    else {
			horses[i] += horses[i + 1];
		    }

		    // print(horses);
		}
		hours++;
	    }
	    print(horses);
	    double cruiseSpeed = destination / (double) hours;
	    System.out.printf("Cruise speed for Annie: %.3f\n", cruiseSpeed);
	    // System.out.printf("Case #%d: %.3f\n", counter, cruiseSpeed);
	    loop--;
	}

    }

    private static void print(int[] array) {
	for (int k = 0; k < array.length; k++) {
	    System.out.print(array[k] + "|");
	}
	System.out.println();
    }

    private static void sort(int[] array) {
	for (int j = 0; j < array.length; j += 2) {
	    int min = j;
	    for (int i = j; i < array.length; i += 2) {
		if (array[i] < array[min]) {
		    min = i;
		}
	    }
	    if (min != j) {
		swap(min, j, array);
		swap(min + 1, j + 1, array);
	    }
	}
    }

    private static void swap(int i, int j, int[] array) {
	int change = array[i];
	array[i] = array[j];
	array[j] = change;
    }
}
