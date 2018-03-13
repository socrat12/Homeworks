package home39.citiesWargaming.cities.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import home39.citiesWargaming.cities.City;

public class IOoperations {
    FileReader freader;
    BufferedReader bfreader;
    FileWriter fwriter;
    BufferedWriter bfwriter;

    /**
     *  путь к файлу задан по умолачнию
     */
    public IOoperations() {
	try {
	    freader = new FileReader("resources\\cities\\worldcities.txt");
	    bfreader = new BufferedReader(freader);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }
    
    
    /**  путь к файлу задайётся параметром path
     * @param path 
     */
    public IOoperations(String path) {
	try {
	    freader = new FileReader(path);
	    bfreader = new BufferedReader(freader);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
    }

    /**
     * @return возвращает LinkedList городов, прочитанных из файла
     */
    public ArrayList<City> getArray() {
	ArrayList<City> list = new ArrayList<City>();
	try {
	    while (bfreader.ready()) {
	        list.add(new City(bfreader.readLine().split(",")));
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return list;
    }

    /** Создание нового файла для записи 
     * @param path - путь для нового файла, в который предполагается запись
     */
    public void createNewFile(String path) {
	File out = new File(path);
	try {
	    out.mkdirs();
	    if (out.exists() || !out.isFile()) out.delete();
	    out.createNewFile();
	    fwriter = new FileWriter(out);
	} catch (IOException e) {
	    e.printStackTrace();
	}

	bfwriter = new BufferedWriter(fwriter);
    }

    /**
     * @param str Добавляемая в файл строка
     */
    public void writeLine(String str) {
	try {
	    bfwriter.write(str);
	    bfwriter.flush();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     *  Закрывает все потоки вводы-вывода
     */
    public void closeFiles() {
	try {
	    bfwriter.close();
	    fwriter.close();
	    bfreader.close();
	    freader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}