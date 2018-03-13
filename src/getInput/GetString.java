package getInput;

import java.util.Scanner;

public class GetString {
    
    private static Scanner take = new Scanner(System.in);
    
    public static String get() {
	String input = take.nextLine();

	while (input.length() < 1) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}
	// take.close();

	return input;
    }
}
