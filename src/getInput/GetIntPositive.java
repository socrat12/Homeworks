package getInput;

import java.util.Scanner;

public class GetIntPositive {

    private static Scanner take = new Scanner(System.in);

    public static int get() {
	String input = take.nextLine();

	while (true) {
	    try {
		input = take.nextLine();
		return Integer.parseInt(input);
	    } catch (NumberFormatException e) {
		System.out.println("Wrong Input. Retry >>");
	    }
	}
    }
}