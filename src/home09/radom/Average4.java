package home09.radom;
//Найти среднее арифметическое в массиве целых чисел.

public class Average4
{

	public static void main(String[] args)
	{
		int[] mass =
		{ 0, 1, 90, 4, 5, 7, -50290, 9, 56, 67, 95, 74, -50, 12589, -35, 8, 19, 1561, 35748, 48 };
		int average = 0;

		for (int i = 0; i < mass.length; i++)
		{
			average += mass[i];
		}
		System.out.println("Average: " + (double) average / mass.length);
	}
}