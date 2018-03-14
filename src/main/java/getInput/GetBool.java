package getInput;

import java.util.Scanner;

public class GetBool {
    
    private static Scanner take = new Scanner(System.in);
    
    public static boolean get() {

	String input = take.nextLine();

	while (!check(input)) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}
	// take.close();
	return ("yes".equals(input) || "1".equals(input) || "y".equals(input)) ? (true) : (false);

    }

    private static boolean check(String input) {
	// если ничего не введено или длина больше максимальной длины для int
	if (input.length() >= 1 && input.length() <= 3) {
	    if ("1".equals(input) || "2".equals(input) || "yes".equals(input) || "no".equals(input)
		    || input.equals("y") || input.equals("n")) {
		return true;
	    }
	}
	return false;
    }
}
