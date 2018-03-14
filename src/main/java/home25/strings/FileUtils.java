package home25.strings;

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

	String fileAsString = new String(content).toLowerCase();
	fileAsString = fileAsString.replaceAll("\r\n", " ").replaceAll("\n\r", " ").replaceAll("\r", " ")
		.replaceAll("\\.", "").replaceAll(",", "").replaceAll("!", "");

	String[] result = fileAsString.split(" ");
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
