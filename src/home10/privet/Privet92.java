package home10.privet;
//Определить в одномерном числовом массиве A из n элементов типа чар, сколько раз в нем встречается последовательность ‘p’, ‘r’,’i’,’v’,’e’,’t’
//Усложнение - в любом регистре, сохранив при этом оригинальный массив неизменным
//Усложнение 2 - в любом регистре, сохранив при этом оригинальный массив неизменным, и не используя другого массива длинной более 6.
public class Privet92
{
	private final static int MASSLENGTH = 700000;

	public static void main(String[] args)
	{
		char[] sequence = "privet".toCharArray();
		int findLenght = sequence.length;
		char[] mass = new char[MASSLENGTH];
		boolean found = false;

		// не завершать программу, пока не найдёт
		while (!found)
		{
			long time = System.currentTimeMillis();
			for (int i = 0; i < MASSLENGTH; i++)
			{
				// случайные большие и маленькие буквы
				// 32 * (int) (Math.random() * 2) даёт в результате 0 или 1,
				// т.е. либо
				// к большим прибавляется 32 и они становятся маленькими, либо 0
				// и остаются большими
				mass[i] = (char) (65 + 32 * (int) (Math.random() * 2) + (int) (Math.random() * 26));
			}
			//print(mass);

			found = findPrivet(mass,sequence,findLenght);
			System.out.println("Time: " + (System.currentTimeMillis() - time) / 1000.0);
		}
	}

	/*private static void print(char[] mass)
	{
		int counter = 0;
		for (int k = 0; k < MASSLENGTH; k++)
		{
			System.out.print((char) mass[k] + "|");
			counter++;
			if (counter % 25 == 0)
			{
				System.out.println();
			}
		}
		System.out.println();
	}*/

	private static boolean findPrivet(char[] mass, char[] sequence, int findLenght)
	{
		int amount = 0;
		boolean check = false;
		for (int i = 0; i <= MASSLENGTH - findLenght; i++)
		{
			// если найден первый символ последовательности в любом регистре
			if (mass[i] == sequence[0] || mass[i] == sequence[0] + 32 || mass[i] == sequence[0] - 32)
			{
				check = false;
				// проверить последовательно идущие за ним
				for (int j = 1; j < findLenght; j++)
				{
					if (mass[i + j] != sequence[j] && mass[i + j] != sequence[j] + 32 && mass[i + j] != sequence[j] - 32)
					{
						i += j;
						break;
					}
					if (j == findLenght - 1)
					{
						check = true;
					}
				}
				// если все символы искомой строки идут подряд
				if (check)
				{
					for (int k = 0; k < findLenght; k++)
					{
						System.out.print(mass[i + k] + " ");
						if (k == findLenght - 1)
						{
							i += k;
						}
					}
					System.out.println();
					amount++;
				}
			}
		}
		System.out.println("The sequence is encountered " + amount + " times");
		if (amount != 0)
		{
			return true;
		}
		return false;
	}
}
