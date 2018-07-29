package com.itStep.home05.simple;
//Task 7: Найти все простые числа <= N.
public class simple7
{

	public static void main(String[] args)
	{
	    int start = 239;
		int N = 239;
		if (N < 2)
		{
			System.err.println("Wrong input");
			System.exit(0);
		}
		int simple = 1;
		boolean flagsimple;
		long time = System.currentTimeMillis();
		//если число не меньше двух, первым простым для него всегда будет двойка
		if (start < 2) System.out.println("Simple " + simple++ + ": " + 2);
		// перебор всех чисел до N включительно, исключая чётные - они все не простые
		for (int i = start; i <= N; i += 2)
		{
			flagsimple = true;
			//перебор всех возможных кратных, исключая чётные до значения корень из i, т.к.
			//числа больше корня из i имеют "пару" из чисел меньше еорня из i. Например:
			//100/50 = 2, 100/25 = 4, 100/20 = 5
			for (int j = 3; j * j < i; j += 2)
			{
				if (i % j == 0)
				{
					flagsimple = false;
				}
			}
			if (flagsimple)
			{
				System.out.println("Simple " + simple + ": " + i);
				simple++;
			}
		}
		System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);
	}
}
