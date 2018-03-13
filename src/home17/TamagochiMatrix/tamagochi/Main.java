package home17.TamagochiMatrix.tamagochi;

import getInput.GetString;

public class Main
{

	public static void main(String[] args)
	{
		String userName = null;

		while (userName == newUser())
		{
			System.out.println();
			TamagochiUI ui = new TamagochiUI(userName);
			ui.startGame();
		}
	}

	private static String newUser()
	{
		System.out.print("Please, input your name: ");
		return GetString.get();
	}
}