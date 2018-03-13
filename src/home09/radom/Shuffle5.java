package home09.radom;
//Дано - массив и 2 индекса.  Переставить эти 2 элемента местами. 
public class Shuffle5
{

	public static void main(String[] args)
	{
		int[] mass =
		{ 0, 1, 90, 4, 5, 7, -50290, 9, 56, 67, 95, 74, -50, 12589, -35, 8, 19, 1561, 35748, 48 };
		int index0 = 14, index1 = 3;

		print(mass);
		swap(index0, index1, mass);
		print(mass);
	}

	private static void print(int[] array)
	{
		for (int k = 0; k < array.length; k++)
		{
			System.out.print(array[k] + "|");
		}
		System.out.println();
	}

	private static void swap(int i, int j, int[] array)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}