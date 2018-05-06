package home08.combination;

import getInput.GetInt;

public class Combination2 {
    private static int sum = 0;

    public static void main (String[] args) {
        int amount;
        do {
            System.out.print("Enter amount of numbers: ");
            // Читаем с клавиатуры размер массива
            amount = GetInt.get();
        }
        // проверка правильности ввода
        while (amount < 2);

        System.out.println(amount);
        // Создаём массив размером amount
        int array[] = new int[amount];

        // Пройдёмся по всему массиву, заполняя его
        for (int i = 0; i < amount; i++) {
            System.out.print("Enter " + (i + 1) + " number: ");
            array[i] = GetInt.get();
        }
        System.out.println();
        
        long time = System.currentTimeMillis();
        // сортировка элементов
        sort(0, array);
        // вывод массива
        print(array);
        // перебор всех комбинаций
        pick(0, array);
        System.out.println(System.currentTimeMillis() - time);
    }

    private static void pick (int i, int[] array) {
        // если метод получил последнее число массива - выйти
        if (i == array.length - 1) { return; }
        // комбинации первого числа
        for (; i < array.length; i++) {
            // со всеми последующими
            for (int j = i + 1; j < array.length; j++) {
                // передать следующее число "ниже", для вывод всех его
                // комбинаций
                pick(i + 1, array);
                // сортировка дальше изменённого числа
                sort(i, array);
                // смена мест
                swap(i, j, array);
                sort(i + 1, array);
                print(array);
            }
        }
    }

    private static void sort (int k, int[] array) {
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

    private static void print (int[] array) {
        // количество комбинаций
        sum++;
        System.out.print(sum + ": ");
        for (int k = 0; k < array.length; k++) {
            System.out.print(array[k] + "|");
        }
        System.out.println();
    }

    private static void swap (int i, int j, int[] array) {
        int change = array[i];
        array[i] = array[j];
        array[j] = change;
    }

}
