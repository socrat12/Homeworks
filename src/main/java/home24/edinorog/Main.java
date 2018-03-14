package home24.edinorog;

public class Main {
    public final static String INPUT_FILE = "resources/edinorog/B-large-practice.in";
    public final static String OUTPUT_FILE = "resources/edinorog/sample.out";

    public static void main(String[] args) throws Exception {
	String[] input = FileUtils.readFileAsStringArray(INPUT_FILE);
	String[] output = new String[input.length - 1];
	for (int i = 1; i < input.length; i++) {
	    String result = TaskResolver.resolveOneCase(input[i]);
	    output[i - 1] = "Case #" + i + ": " + result;
	}
	FileUtils.writeStringArrayToFile(output, OUTPUT_FILE);
    }
}
