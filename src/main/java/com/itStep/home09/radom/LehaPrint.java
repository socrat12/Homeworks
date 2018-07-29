package com.itStep.home09.radom;
//Найти самый большой элемент в массиве.
//Что-то вроде пузырька но наверное чуть быстрее его, а может и нет :)
public class LehaPrint
{
	public static void main(String[] args)
	{
		int[] c =
		{ 9, 10, 5, 8, 7, 15, -59, 50, 100 };
		int[] c1 = new int[100];
		int maxN = 0, z = 0;
		System.out.print("Befor Array : ");
		for (int b = 0; b < c.length; b++)
		{
			c1[b] = c[b];
			System.out.print("	" + c1[b]);
		}
		System.out.println();

		for (int n = c.length - 1; n >= 0; n--)
		{
			for (int i = 0; i < c.length; i++)
			{
				maxN = Math.max(maxN, c[i]);
			}
			while (maxN != c[z])
			{
				z++;
			}
			c1[n] = maxN;
			c[z] = 0;
			maxN = 0;
			z = 0;
		}
		System.out.print("After Array : ");
		for (int a = 0; a < c.length; a++)
		{
			System.out.print("	" + c1[a]);
		}
	}
}
