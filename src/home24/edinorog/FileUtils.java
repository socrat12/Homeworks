package home24.edinorog;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileUtils {

    public static String[] readFileAsStringArray(String path) throws Exception {
	File file = new File(path);
	
	if (!(file.exists() && file.isFile())) {
	    return null;
	}
	
	FileReader reader = new FileReader(file);
	
	int size = (int) file.length();
	char[] content = new char[size];
	reader.read(content);
	reader.close();
	
	String fileAsString = new String(content);
	fileAsString = fileAsString.replaceAll("\r\n", "\n").replaceAll("\n\r", "\n").replaceAll("\r", "\n");
	
	String[] result = fileAsString.split("\n");
	return result;
    }

    public static void writeStringArrayToFile(String[] content, String path) throws Exception {
	new File(path).delete();
	
	FileWriter writer = new FileWriter(path);
	for (int i = 0; i < content.length; i++) {
	    writer.write(content[i]);
	    writer.write("\r\n");
	}
	writer.close();
    }
}