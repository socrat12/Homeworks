//Определить, является ли строка полиндромом
package home12.polindrom;

public class Polindrom_5
{
	public static void main(String[] args)
	{
		if (args.length == 0)
		{
			System.err.println("Usage: Home12.Polindrom <some symbols>");
			System.exit(0);
		}
		first(args[0]);
		second(args[0]);
	}

	private static void first(String string)
	{
		for (int i = 0; i < string.length() / 2; i++)
		{
			if (string.charAt(string.length() - 1 - i) != string.charAt(i))
			{
				System.out.println("Nope...");
				System.exit(0);
			}
		}
		System.out.println("Polindrom!");
	}

	private static void second(String string)
	{
		char[] array = string.toCharArray();
		for (int i = 0; i < array.length / 2; i++)
		{
			if (array[array.length - 1 - i] != array[i])
			{
				System.out.println("Nope...");
				System.exit(0);
			}
		}
		System.out.println("Polindrom!");
	}
}
