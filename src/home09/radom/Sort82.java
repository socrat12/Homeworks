package home09.radom;
//Упорядочить массив случайных чисел по возрастанию. 
//версия без рекурсии
public class Sort82
{
	private final static int MASSLENGTH = 10000;

	public static void main(String[] args)
	{
		int[] mass = new int[MASSLENGTH];

		for (int i = 0; i < MASSLENGTH; i++)
		{
			mass[i] = (int) (Math.random() * MASSLENGTH);
		}

		print(mass);
		long time = System.currentTimeMillis();
		sort(mass);
		System.out.println("Time - " + (System.currentTimeMillis() - time) / 1000f);
		print(mass);
	}

	private static void sort(int[] array)
	{
		for (int j = 0; j < array.length - 1; j++)
		{
			int min = j;
			for (int i = j; i < array.length; i++)
			{
				if (array[i] < array[min])
				{
					min = i;
				}
			}
			swap(min, j, array);
		}
	}

	private static void print(int[] array)
	{
		int counter = 0;
		for (int k = 0; k < array.length; k++)
		{
			System.out.print(array[k] + "|");
			counter++;
			if (counter % 25 == 0)
			{
				System.out.println();
			}
		}
		System.out.println();
	}

	private static void swap(int i, int j, int[] array)
	{
		int change = array[i];
		array[i] = array[j];
		array[j] = change;
	}
}