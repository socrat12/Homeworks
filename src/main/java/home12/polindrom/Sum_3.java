//3 Задача на рекурсию простая: посчитать сумму чисел от нуля до 10 рекурсивным методом. 
package home12.polindrom;

public class Sum_3 {
    public static void main(String[] args) {
	int n = 10;
	System.out.println(sumLessOf(n));
    }

    private static int sumLessOf(int n) {
	if (n == 0) {
	    return 0;
	}
	return n + sumLessOf(n - 1);
    }
}
