package home11.pancakes;

public class Triangle
{
	private final static int HEIGHT = 7;

	public static void main(String[] args)
	{
		int[][] triangleArray = new int[HEIGHT][];

		for (int i = 0; i < HEIGHT; i++)
		{
			triangleArray[i] = new int[i + 1];
			for (int j = 0; j < triangleArray[i].length; j++)
			{
				triangleArray[i][j] = (int) (Math.random() * HEIGHT * 10 - HEIGHT * 5);
			}
		}

		print2d(triangleArray);
		sum(triangleArray);

	}

	public static void print2d(int[][] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			// приведение вывода архива к треугольному виду
			if (array[i].length < array[HEIGHT - 1].length)
			{
				for (int k = 0; k < array[HEIGHT - 1].length - array[i].length; k++)
				{
					System.out.print("  ");
				}
			}
			System.out.print("| ");
			for (int j = 0; j < array[i].length; j++)
			{
				System.out.print(array[i][j] + " | ");
			}
			System.out.println();
		}
	}

	private static void sum(int[][] array)
	{
		int sum = 0;
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				sum += array[i][j];
			}
		}
		System.out.println("Sum is " + sum);
	}
}
