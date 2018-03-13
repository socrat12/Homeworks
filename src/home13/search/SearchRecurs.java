package home13.search;

public class SearchRecurs
{
	private static int count = 0;

	public static void main(String[] args)
	{
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 };

		int find = 15;

		System.out.println(search(find, 0, array.length - 1, array));
		System.out.println(count);
	}

	public static int search(int find, int start, int end, int[] array)
	{
		count++;
		if (start > end)
		{
			System.out.println("Not found");
			System.exit(0);
		}
		int middle = (end + start) / 2;

		if (find > array[middle])
		{
			// поиск в правой части
			return search(find, middle + 1, end, array);
		}
		else if (find < array[middle])
		{
			// поиск в левой части 
			return search(find, start, middle - 1, array);
		}
		else
		{
			return middle;
		}
	}
}
