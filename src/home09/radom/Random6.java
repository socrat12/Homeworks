package home09.radom;
//Заполнить массив из 10 чисел типа double случайными значениями от 0 до 1. 
//(использовать Math.random()).

public class Random6
{

	public static void main(String[] args)
	{
		double[] mass = new double[10];

		for (int i = 0; i < mass.length; i++)
		{
			mass[i] = Math.random();
		}

		print(mass);
	}

	private static void print(double[] mass)
	{
		for (int k = 0; k < mass.length; k++)
		{
			System.out.println(mass[k]);
		}
		System.out.println();
	}
}
