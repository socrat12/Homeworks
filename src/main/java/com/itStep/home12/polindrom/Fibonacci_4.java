//Посчитать n-й член последовательности Фибоначи рекурсивным методом 
package com.itStep.home12.polindrom;

import com.itStep.getInput.GetInt;

public class Fibonacci_4 {
    public static void main(String[] args) {
	long toFib;
	do {
	    System.out.print("Input Fibonacci number: ");
	    toFib = GetInt.get();
	} while (toFib < 0 || toFib > 1476);

	System.out.println(fib2(toFib));
	if (toFib < 45) {
	    System.out.println(fib(toFib));
	}
    }

    private static int fib(long n) {
	if (n < 3) {
	    return 1;
	}
	return fib(n - 1) + fib(n - 2);
    }

    private static double fib2(long n) {
	double sum1 = 0, sum2 = 1;
	for (int i = 1; i <= n; i++) {
	    sum1 += sum2;
	    sum2 = sum1 - sum2;
	}
	return sum1;
    }
}
