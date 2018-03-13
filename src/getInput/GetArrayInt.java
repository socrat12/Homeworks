package getInput;

import java.util.Scanner;

public class GetArrayInt {
    
    private static Scanner take = new Scanner(System.in);
    
    public static int[] get() {

	String input = take.nextLine();

	while (!check(input)) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}

	// take.close();

	char[] arrayChar = input.toCharArray();

	int[] array = new int[arrayChar.length];
	for (int i = 0; i < arrayChar.length; i++) {
	    array[i] = arrayChar[i] - 48;
	}
	return array;
    }

    private static boolean check(String input) {
	if (input.length() < 1) {
	    return false;
	}

	for (int i = 0; i < input.length(); i++) {
	    boolean exist = false;
	    for (char j = '0'; j <= '9'; j++) {
		if (j == input.charAt(i)) {
		    exist = true;
		    break;
		}
	    }
	    if (!exist) {
		return false;
	    }
	}
	return true;
    }
}