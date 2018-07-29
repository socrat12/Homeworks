package com.itStep.home37.alphabet;

public class App {
    public static void main(String[] args) {
	FilePrinter fp;
	try {
	    fp = new FilePrinter("c:/213652190853/new.txt");
	    fp.print("One");
	    fp.println("Two");
	    fp.print("One\n");
	    fp.println("Two");
	    fp.println(1);
	    fp.print(15.47000000);
	    fp.println((char) 65);
	    System.out.println("Done");
	} catch (CantPrint e) {
	    System.out.println(e.getMessage());
	}
    }
}
