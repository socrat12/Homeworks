package home39.citiesWargaming.wargaming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOoperations2 {
    private FileReader freader;
    private BufferedReader bfreader;
    private FileWriter fwriter;
    private BufferedWriter bfwriter;

    /**
     * путь к файлу задан по умолачнию
     */
    public IOoperations2() {
    }

    /**
     * путь к файлу задайётся параметром path
     * 
     * @param path
     */
    public IOoperations2(String path) {
	try {
	    freader = new FileReader(path);
	    bfreader = new BufferedReader(freader);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    /**
     * путь к файлу задайётся параметром path
     * 
     * @param path
     * @return
     */
    public String readLine() {
	try {
	    return bfreader.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	    return "";
	}
    }

    public boolean isReady() {
	try {
	    return bfreader.ready();
	} catch (IOException e) {
	    e.printStackTrace();
	    return false;
	}
    }

    /**
     * Создание нового файла для записи
     * 
     * @param path
     *            - путь для нового файла, в который предполагается запись
     */
    public void createNewFile(String path) {
	File out = new File(path);
	try {
	    out.mkdirs();
	    if (out.exists() || !out.isFile())
		out.delete();
	    out.createNewFile();
	    fwriter = new FileWriter(out);
	} catch (IOException e) {
	    e.printStackTrace();
	}

	bfwriter = new BufferedWriter(fwriter);
    }

    /**
     * @param str
     *            Добавляемая в файл строка
     */
    public void writeLine(String str) {
	try {
	    bfwriter.write(str);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * Закрывает все потоки вводы-вывода
     */
    public void closeFiles() {
	try {
	    if (bfwriter != null) {
		bfwriter.close();
		fwriter.close();
	    }
	    if (bfreader != null) {
		bfreader.close();
		freader.close();
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}
