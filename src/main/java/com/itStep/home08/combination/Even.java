package com.itStep.home08.combination;

public class Even
{

	public static void main(String[] args)
	{
		int[] massiv = new int[100];

		for (int i = 0; i < massiv.length; i++)
		{
			massiv[i] = i;
		}

		for (int i = 0; i < massiv.length; i++)
		{
			if (massiv[i] % 2 == 0)
			{
				System.out.print(massiv[i] + "!");
			}

		}
		System.out.println();

		int[] massiv2 = {0, 1, 90, 4, 5, 7, 9, 56, 67, 95, 74};

		for (int i = 0; i < massiv2.length; i++)
		{
			if (massiv2[i] % 2 == 0)
			{
				System.out.print(massiv2[i] + "!");
			}
		}
		System.out.println();
	}
}
