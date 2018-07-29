package com.itStep.home11.pancakes;

public class RevengeOfThePancakes
{
	private static int counter = 0;

	public static void main(String[] args)
	{
		String pancakes = "-------++++---+++--++--";

		char[] pancake = pancakes.toCharArray();
		happy(pancake);

	}

	private static int happy(char[] pancake)
	{
		System.out.println(pancake);
		for (int i = 1; i < pancake.length; i++)
		{
			// если следующий блин другой, превернуть стоку блинов от верха до
			// расхождения
			if (pancake[i] != pancake[i - 1])
			{
				for (int j = 0; j < i; j++)
				{
					flip(pancake, j);
				}
				System.out.println(pancake);
				counter++;
			}
		}
		if (pancake[0] != '+')
		{
			for (int i = 0; i < pancake.length; i++)
			{
				flip(pancake, i);
			}
			counter++;
		}
		System.out.println(pancake);
		System.out.println();
		return counter;
	}

	private static void flip(char[] pancake, int i)
	{
		if (pancake[i] == '-')
		{
			pancake[i] = '+';
		}
		else
		{
			pancake[i] = '-';
		}
	}
}
