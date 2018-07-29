package com.itStep.home34.notebook;

/**
 *  	Notepad V1.3
 * @author Alexander Neznaev
 *
 */
public class ConsoleApplication {

    public static void main(String[] args) {
	ConsoleUI ui = new ConsoleUI();
	
	while (!ui.isExit()) {
	    try {
		ui.start();
	    } catch (Exception e) {
		System.err.println(e.getClass() + " " + e.getMessage());
		for (StackTraceElement s : e.getStackTrace()) {
		    System.out.println(s);
		}
	    }
	}
	System.out.println("Good buy");
    }
}
