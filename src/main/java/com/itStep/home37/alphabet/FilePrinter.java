package com.itStep.home37.alphabet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilePrinter {
    File f;
    FileOutputStream fWrite;

    public FilePrinter(String path) throws CantPrint {
	f = new File(path);
	f.mkdirs();
	if (!f.exists() || !f.isFile()) {
	    f.delete();
	    try {
		f.createNewFile();
	    } catch (IOException e) {
		throw new CantPrint("Could not create file");
	    }
	}
	try {
	    fWrite = new FileOutputStream(f, true);
	} catch (FileNotFoundException e) {
	    throw new CantPrint("Some problem with creation FileOutputStream");
	}
    }

    public void print(Object s) throws CantPrint {
	write(s.toString());
    }

    public void println(Object s) throws CantPrint {
	write(s.toString());
	write("\n");
    }

    public void print(String s) throws CantPrint {
	write(s);
    }

    public void println(String s) throws CantPrint {
	write(s);
	write("\n");
    }

    public void println(byte i) throws CantPrint {
	write(i + "");
	write("\n");
    }

    public void print(byte i) throws CantPrint {
	write(i + "");
    }

    public void println(short i) throws CantPrint {
	write(i + "");
	write("\n");
    }

    public void print(short i) throws CantPrint {
	write(i + "");
    }

    public void println(char i) throws CantPrint {
	write(i + "");
	write("\n");
    }

    public void print(char i) throws CantPrint {
	write(i + "");
    }

    public void println(int i) throws CantPrint {
	write(i + "");
	write("\n");
    }

    public void print(int i) throws CantPrint {
	write(i + "");
    }

    public void println(double d) throws CantPrint {
	write(String.valueOf(d));
	write("\n");
    }

    public void print(double d) throws CantPrint {
	write(String.valueOf(d));
    }

    public void println(float f) throws CantPrint {
	write(String.valueOf(f));
	write("\n");
    }

    public void print(float f) throws CantPrint {
	write(String.valueOf(f));
    }

    private void write(String s) throws CantPrint {
	for (int i = 0; i < s.length(); i++) {
	    try {
		if (s.charAt(i) == '\n') {
		    fWrite.write(13);
		    fWrite.write(10);
		}
		fWrite.write(s.charAt(i));
	    } catch (IOException e) {
		throw new CantPrint("Some problem with writing to file");
	    }
	}
    }
}
