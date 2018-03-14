package home34.notebook.utils;

import java.util.Scanner;

public class GetChoise {
    
    private static Scanner take = new Scanner(System.in);
    
    public static int getChoise() {

	String input = take.nextLine();

	while (input.isEmpty() || !("54321".contains(input))) {
	    System.err.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}

	return Byte.parseByte(input);
    }
    
    public static String getString() {
	return take.nextLine();
    }
    
    public static long getLong() {
	while (true) {
	    try {
		String input = take.nextLine();
		return Long.parseLong(input);
	    } catch (NumberFormatException e) {
		System.err.println("Wrong Input. Retry >>");
	    }
	}
    }
}
