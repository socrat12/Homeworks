package com.itStep.home34.notebook.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itStep.home34.notebook.exceptions.WriteReadException;

/**
 * @author Neznaev_AI
 *
 */
public class FileTreatment {
    private File f;
    private String path;
    private FileOutputStream fWrite;
    private FileInputStream fRead;

    /**
     * @param path Путь до файла, содержащего заметки
     * @throws WriteReadException включает все ошибки при работе с фалом
     */
    public FileTreatment(String path) throws WriteReadException {
	this.path = path;
	creatingConnectionWithAFile();
    }
    
    public void close() throws WriteReadException {
	try {
	    fWrite.close();
	    fRead.close();
	} catch (IOException e) {
	    throw new WriteReadException(e.getClass() + " " + e.getMessage());
	}
    }

    /**
     * @param path
     * @throws WriteReadException
     */
    private void creatingConnectionWithAFile() throws WriteReadException {
	f = new File(path);
	f.mkdirs();
	if (!f.exists() || !f.isFile()) {
	    f.delete();
	    try {
		f.createNewFile();
	    } catch (IOException e) {
		throw new WriteReadException ("Could not create file");
	    }
	}
	try {
	    fWrite = new FileOutputStream(f, true);
	    fRead = new FileInputStream(f);
	} catch (FileNotFoundException e) {
	    throw new WriteReadException("Some problem with creation FileOutputStream");
	}
    }
    
    public void clearFile() throws WriteReadException {
	try {
	    fWrite = new FileOutputStream(f);
	} catch (FileNotFoundException e) {
	    throw new WriteReadException("Some problem with creation FileOutputStream");
	}
	print("");
    }
    
    /**
     * @return Возвращает содержимое фала одним стрингом
     * @throws WriteReadException
     */
    public String fileToString() throws WriteReadException {
	String s = new String();
	try {
	    while (fRead.available() > 0) {
		s += (char)fRead.read();
	    } 
	} catch (IOException e) {
	    throw new WriteReadException("Can't open " + f.getAbsolutePath());
	}
	return s;
    }

    public void print(Object s) throws WriteReadException {
	write(s.toString());
    }

    public void println(Object s) throws WriteReadException {
	write(s.toString());
	write("\n");
    }

    public void print(String s) throws WriteReadException {
	write(s);
    }

    public void println(String s) throws WriteReadException {
	write(s);
	write("\n");
    }

    public void println(byte i) throws WriteReadException {
	write(i + "");
	write("\n");
    }

    public void print(byte i) throws WriteReadException {
	write(i + "");
    }

    public void println(short i) throws WriteReadException {
	write(i + "");
	write("\n");
    }

    public void print(short i) throws WriteReadException {
	write(i + "");
    }

    public void println(char i) throws WriteReadException {
	write(i + "");
	write("\n");
    }

    public void print(char i) throws WriteReadException {
	write(i + "");
    }

    public void println(int i) throws WriteReadException {
	write(i + "");
	write("\n");
    }

    public void print(int i) throws WriteReadException {
	write(i + "");
    }

    public void println(double d) throws WriteReadException {
	write(String.valueOf(d));
	write("\n");
    }

    public void print(double d) throws WriteReadException {
	write(String.valueOf(d));
    }

    public void println(float f) throws WriteReadException {
	write(String.valueOf(f));
	write("\n");
    }

    public void print(float f) throws WriteReadException {
	write(String.valueOf(f));
    }

    private void write(String s) throws WriteReadException {
	for (int i = 0; i < s.length(); i++) {
	    try {
		if (s.charAt(i) == '\n') {
		    fWrite.write(13);
		    fWrite.write(10);
		    continue;
		}
		fWrite.write(s.charAt(i));
		fWrite.flush();
	    } catch (IOException e) {
		throw new WriteReadException("Some problem with writing to file");
	    }
	}
    }
}
