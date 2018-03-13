package home09.radom;
//Найти самый большой элемент в массиве.
public class Biggest1
{

	public static void main(String[] args)
	{
		int[] mass =
		{ 0, 1, 90, 4, 5, 7, -50290, 9, 56, 67, 95, 74, -50, 12589, -35, 8, 19, 1561, 35748, 48 };
		int big = mass[0];

		for (int i = 0; i < mass.length; i++)
		{
			if (big < mass[i])
			{
				big = mass[i];
			}
		}
		System.out.println("Biggest: " + big);
	}
}
