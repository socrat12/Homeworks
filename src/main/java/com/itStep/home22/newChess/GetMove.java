package com.itStep.home22.newChess;

import java.util.Scanner;

public class GetMove {
    public static int[] move = new int[4];

    @SuppressWarnings("resource")
    public static void get() {
	Scanner take = new Scanner(System.in);

	String input = take.nextLine();

	while (!check(input)) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}
	//take.close();

	int letter = input.charAt(0) - 65, letter1, number1;
	if (input.length() == 4) {
	    letter1 = input.charAt(2) - 65;
	    number1 = 7 - (input.charAt(3) - 49);
	} else {
	    letter1 = input.charAt(3) - 65;
	    number1 = 7 - (input.charAt(4) - 49);
	}
	if (letter > 8) {
	    letter -= 32;
	}
	if (letter1 > 8) {
	    letter1 -= 32;
	}
	move[0] = letter;
	move[1] = 7 - (input.charAt(1) - 49);
	move[2] = letter1;
	move[3] = number1;
    }

    private static boolean check(String input) {
	if (input.equals("exit") || input.equals("Exit") || input.equals("EXIT") || input.equals("0")
		|| input.equals("quit") || input.equals("Quit") || input.equals("QUIT")) {
	    System.out.println("Exiting...");
	    System.exit(0);
	}
	if (input.length() < 4 || input.length() > 5) {
	    return false;
	}

	boolean existNumber = false, existLetters = false;
	boolean existNumber1 = false, existLetters1 = false;
	for (char i = 'A', j = '1'; j <= '8'; j++, i++) {
	    if ((i == input.charAt(0) || (i + 32) == input.charAt(0)) && !existLetters) {
		existLetters = true;
	    }
	    if (j == input.charAt(1) && !existNumber) {
		existNumber = true;
	    }
	    if (input.length() == 4) {
		if (j == input.charAt(3) && !existNumber1) {
		    existNumber1 = true;
		}
		if ((i == input.charAt(2) || (i + 32) == input.charAt(2)) && !existLetters1) {
		    existLetters1 = true;
		}
	    } else {
		if (j == input.charAt(4) && !existNumber1) {
		    existNumber1 = true;
		}
		if ((i == input.charAt(3) || (i + 32) == input.charAt(3)) && !existLetters1) {
		    existLetters1 = true;
		}
	    }
	}
	if (!(existNumber && existLetters && existNumber1 && existLetters1)) {
	    return false;
	}
	return true;
    }
}
