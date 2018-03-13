package home58;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Corpse
 *
 */
public class WriterToFile {
    private File file;
    private Writer writer = null;
    private BufferedWriter bufferedWriter = null;
    
    public WriterToFile(String path) {
	file = new File(path);
	writerCreator();
    }

    public WriterToFile(File f) {
	file = f;
	writerCreator();
    }

    /**
     * 
     */
    private void writerCreator () {
	if (!file.isFile() || file.exists()) createFile();
	try {
	    writer = new FileWriter(file);
	} catch (IOException e) {
	    e.printStackTrace();
	}
	bufferedWriter = new BufferedWriter(writer);
    }
    
    /**
     * путь к файлу задайётся параметром path
     * 
     * @param path
     */
    private void createFile() {
	file.mkdirs();
	if (!file.isFile() || file.exists()) {
	    file.delete();
	    try {
		file.createNewFile();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
    
    /**
     * Добавляет начало новой строки
     *            
     */
    public void writeLine() {
	try {
	    bufferedWriter.write("\r\n");
	    //System.out.println(str);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * @param str
     *            Добавляемая в файл строка
     */
    public void writeLine(String str) {
	try {
	    bufferedWriter.write(str + "\r\n");
	    //System.out.println(str);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
    
    /**
     * @param str
     *            Добавляемая в файл строка
     */
    public void write(String str) {
	try {
	    bufferedWriter.write(str);
	    //System.out.println(str);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
 
    /**
     * Закрывает все потоки вводы-вывода
     */
    public void close() {
	try {
	    if (bufferedWriter != null) bufferedWriter.close();
	    if (writer != null) writer.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }
}