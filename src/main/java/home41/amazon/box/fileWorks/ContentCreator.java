package home41.amazon.box.fileWorks;

import java.util.ArrayList;
import java.util.List;

public class ContentCreator {

    private final static int AMOUNT = 10;

    public static void main(String[] args) {
	FileWorks fw = new FileWorks();
	fw.createFile("resources/box/boxes.csv");
	for (int i = 0; i < AMOUNT; i++) {
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    int amountOfBoxes = (int) (Math.random() * 20);
	    for (int j = 0; j < amountOfBoxes; j++) {
		List<Integer> listIn = new ArrayList<Integer>();
		listIn.add((int) (Math.random() * 10 + 1));
		listIn.add((int) (Math.random() * 10 + 1));
		list.add(listIn);
	    }
	    fw.writeLine(amountOfBoxes + "," + list + "," + ((int) (Math.random() * amountOfBoxes)));
	}
	fw.close();
    }
}
