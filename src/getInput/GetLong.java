package getInput;

import java.util.Scanner;

public class GetLong {

    private static Scanner take = new Scanner(System.in);

    public static long get() {
	
	while (true) {
	    try {
		String input = take.nextLine();
		return Long.parseLong(input);
	    } catch (NumberFormatException e) {
		System.out.println("Wrong Input. Retry >>");
	    }
	}
    }
}