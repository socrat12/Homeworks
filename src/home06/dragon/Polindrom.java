package home06.dragon;

public class Polindrom
{

	public static void main(String[] args)
	{
		int polindrom = 1234321;
		int digits = digitsNumber(polindrom);
		for (int i = 0; i < digits/2; i++)
		{
			if (findPOsition (polindrom, digits - 1 - i) != findPOsition (polindrom, i))
			{
				System.out.println("Nope...");
				System.exit(0);
			}
		}
		System.out.println("Polindrom!");
	}

	private static int findPOsition(int number, int digits)
	{
		number = number / (int)Math.pow(10, digits);
		return number%10;
	}

	private static int digitsNumber(int number)
	{
		int counter = 0;
		if (number == 0)
		{
			return 1;
		}
		while (number > 0)
		{
			counter++;
			number /= 10;
		}
		return counter;
	}

}