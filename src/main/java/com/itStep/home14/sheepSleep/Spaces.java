//Разделить строку на слова, разделённые пробелами
package com.itStep.home14.sheepSleep;

public class Spaces {

    public static void main(String[] args) {
	String text = " Mama myla     ramu ";
	System.out.println(text);

	String[] words = split(text);
	print(words);

	/* print(text.split(" ")); System.out.println(text.substring(5, 9)); */
    }

    private static String[] split(String text) {
	String[] result;
	int words = 0;
	for (int i = 0; i < text.length(); i++) {
	    if (text.charAt(i) == ' ') {
		while(i < text.length() - 1 && text.charAt(i+1) == ' ') {
		    i++;
		}
		if (i != text.length() - 1) {
		    words++;
		}
	    }
	}

	result = new String[words];
	int previous = 0, count = 0;
	for (int i = 0; i < text.length(); i++) {
	    if (i == text.length() - 1 || text.charAt(i + 1) == ' ') {
		// создать новую строку
		char[] currentWord = new char[i + 1 - previous];
		for (int j = previous; j <= i; j++) {
		    currentWord[j - previous] = text.charAt(j);
		}
		result[count] = String.valueOf(currentWord);
		count++;
		previous = i + 2;
		// добавить её в результат
		// обновить
	    }
	}

	return result;
    }

    private static void print(String[] array) {
	for (int i = 0; i < array.length; i++) {
	    System.out.print(array[i] + "/");
	}
	System.out.println();
    }
}
