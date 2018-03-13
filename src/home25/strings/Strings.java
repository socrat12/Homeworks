package home25.strings;

import getInput.GetString;

public class Strings {

    public static void main(String[] args) throws Exception {
	String[] input = GetString.get().split(" ");
	sort(input);
	print(input);
	
	System.out.println();
	
	String[] fromFile = FileUtils.readFileAsStringArray("resources/Strings/Jane.txt");
	sort(fromFile);
	print(fromFile);
    }

    private static void sort(String[] array) {
	boolean check = false;
	do {
	    check = false;
	    for (int i = 0; i < array.length - 1; i++) {
		if (array[i].compareTo(array[i + 1]) > 0) {
		    swap(i, i + 1, array);
		    check = true;
		}
	    }
	} while (check);
    }

    private static void swap(int i, int j, String[] array) {
	String change = array[i];
	array[i] = array[j];
	array[j] = change;
    }

    private static void print(String[] array) {
	int counter = 0;
	for (int k = 0; k < array.length; k++) {
	    counter += array[k].length();
	    System.out.print(array[k].toUpperCase() + "|");
	    if (counter / 80 > 0 ) {
		System.out.println();
		counter = 0;
	    }
	}
	System.out.println();
    }
}
