package home37.alphabet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import getInput.GetBool;

public class Alphabet {
    private static FileOutputStream outputAlpha;

    public static void main(String[] args) {
	File alpha = new File("resources/alphabet/Alphabet.txt");
	alpha.mkdirs();

	if (!alpha.exists() || !alpha.isFile()) {
	    while (true) {
		try {
		    alpha.delete();
		    alpha.createNewFile();
		    break;
		} catch (IOException e) {
		    System.err.println("Could not create file");
		    System.out.println("Are you want to try again? (y/n)");
		    if (!GetBool.get())
			System.exit(0);
		}
	    }
	}
	int count = 0;
	try {
	    outputAlpha = new FileOutputStream(alpha);
	    for (byte i = 'A'; i <= 'z'; i++) {
		outputAlpha.write(i);
		if (i == 'Z') {
		    outputAlpha.write(13);
		    outputAlpha.write(10);
		    i = 'a' - 1;
		}
	    }
	} catch (IOException e) {
	    count++;
	    if (count > 10000) {
		System.err.println("Undone");
		System.exit(0);
	    }
	}
	System.out.println("Done");
    }
}