package home08.combination;

import getInput.GetInt;

//Построить алгоритм, выдающий без повторений все перестановки N чисел
///Круто всё учтено, даже не думал, что можно таким путём дойти до решения.
///Но несмотря на то, что я говорил, что ограничиться можно тестовыми даныыми до 8,
///хороший алгоритм должен быть корректен для любых данных, ну с парой исключений, 
///и упираться в ограничения скорости железа и объема памяти, а не в алгоритмические самоограничения.
///и не содержать N строчек if (amount == 1..2...N) c новым внутренним циклом на Н++.
///Повезло просто, что факториал очень быстро растет, и больше 8 я не рекмендовал для теста брать.
/// мог бы факториал до 50 дорасти, у тебя б крыша поехала 50-й цикл вкладывать с 50-м ифом.

///попробуй придумать как написать так, чтобы упереться в ограничение int, или даже чуть больше (но с полным лонгом уже точно заснет навечно, миллиардов до 100 операций ещё терпимо). 
///А не перебирать, сколько у нас там чисел (только вывод тогда придется как-то сильно урезать, 
///2млрд комбинаций выводить ни к чему.)
public class BruteForce {

    public static void main(String[] args) {
	int amount;
	do {
	    System.out.print("Enter amount of numbers from 2 to 8: ");
	    // Читаем с клавиатуры размер массива
	    amount = GetInt.get();
	}
	// проверка правильности ввода
	while (amount < 2 || amount > 8);

	// Создаём массив размером size
	int array[] = new int[amount];

	// Пройдёмся по всему массиву, заполняя его
	for (int i = 0; i < amount; i++) {
	    System.out.print("Enter " + (i + 1) + " number: ");
	    array[i] = GetInt.get();
	}
	System.out.println();
	// количество комбинаций
	int sum = 0;

	for (int i = 0; i < amount; i++) {
	    for (int j = 0; j < amount; j++) {
		// пропуск повторов
		if (j == i) {
		    continue;
		}
		// проверка количества чисел
		if (amount == 2) {
		    sum++;
		    System.out.println(sum + ": " + array[i] + "/ " + array[j]);
		    continue;
		}
		for (int k = 0; k < amount; k++) {
		    // пропуск повторов
		    if (k == j || k == i) {
			continue;
		    }
		    // проверка количества чисел
		    if (amount == 3) {
			sum++;
			System.out.println(sum + ": " + array[i] + "/ " + array[j] + "/ " + array[k]);
			continue;
		    }
		    for (int l = 0; l < amount; l++) {
			// пропуск повторов
			if (l == j || l == i || l == k) {
			    continue;
			}
			// проверка количества чисел
			if (amount == 4) {
			    sum++;
			    System.out.println(
				    sum + ": " + array[i] + "/ " + array[j] + "/ " + array[k] + "/ " + array[l]);
			    continue;
			}
			for (int m = 0; m < amount; m++) {
			    // пропуск повторов
			    if (m == j || m == i || m == k || m == l) {
				continue;
			    }
			    // проверка количества чисел
			    if (amount == 5) {
				sum++;
				System.out.println(sum + ": " + array[i] + "/ " + array[j] + "/ " + array[k] + "/ "
					+ array[l] + "/ " + array[m]);
				continue;
			    }
			    for (int n = 0; n < amount; n++) {
				// пропуск повторов
				if (n == j || n == i || n == k || n == l || n == m) {
				    continue;
				}
				// проверка количества чисел
				if (amount == 6) {
				    sum++;
				    System.out.println(sum + ": " + array[i] + "/ " + array[j] + "/ " + array[k] + "/ "
					    + array[l] + "/ " + array[m] + "/ " + array[n]);
				    continue;
				}
				for (int o = 0; o < amount; o++) {
				    // пропуск повторов
				    if (o == j || o == i || o == k || o == l || o == m || o == n) {
					continue;
				    }
				    // проверка количества чисел
				    if (amount == 7) {
					sum++;
					System.out.println(sum + ": " + array[i] + "/ " + array[j] + "/ " + array[k]
						+ "/ " + array[l] + "/ " + array[m] + "/ " + array[n] + "/ "
						+ array[o]);
					continue;
				    }
				    for (int p = 0; p < amount; p++) {
					// пропуск повторов
					if (p == j || p == i || p == k || p == l || p == m || p == n || p == o) {
					    continue;
					}
					// проверка количества чисел
					if (amount == 8) {
					    sum++;
					    System.out.println(sum + ": " + array[i] + "/ " + array[j] + "/ " + array[k]
						    + "/ " + array[l] + "/ " + array[m] + "/ " + array[n] + "/ "
						    + array[o] + "/ " + array[p]);
					    // continue;
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}
    }
}