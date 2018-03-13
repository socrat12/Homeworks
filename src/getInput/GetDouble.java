package getInput;

import java.util.Scanner;

public class GetDouble {
    
    private static Scanner take = new Scanner(System.in);
    
    public static double get() {
	String input = take.nextLine();

	while (!check(input)) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}

	// take.close();
	return Double.parseDouble(input);
    }

    public static boolean check(String input) {
	if (input.length() < 1) {
	    return false;
	}

	for (int i = 0; i < input.length(); i++) {
	    if (i == 0 && input.charAt(i) == '-') {
		if (input.length() > 1) {
		    continue;
		} else {
		    return false;
		}
	    }
	    boolean exist = false, point = false;
	    for (char j = '0'; j <= '9'; j++) {
		if (j == input.charAt(i)) {
		    exist = true;
		    break;
		}
		if (input.charAt(i) == '.') {
		    if (i != 0 && i != input.length() - 1 && !point) {
			exist = true;
			point = true;
			break;
		    }
		}
	    }
	    if (!exist) {
		return false;
	    }
	}
	return true;
    }
}
