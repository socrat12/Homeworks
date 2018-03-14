//Написать программу сложения двух чисел, полученых как аргументы командной строки.
package home12.polindrom;

import getInput.GetInt;

public class SumArguments_6 {
    public static void main(String[] args) {
	if (args.length != 2) {
	    System.err.println("Usage: Home12.Polindrom <number1> <number2>");
	    System.exit(0);
	}

	// защита от ввода символов
	if (!GetInt.check(args[0]) || !GetInt.check(args[1])) {
	    System.out.println("Wrong input");
	    System.exit(0);
	}

	System.out.println(Integer.parseInt(args[0]) + Integer.parseInt(args[1]));
    }
}
