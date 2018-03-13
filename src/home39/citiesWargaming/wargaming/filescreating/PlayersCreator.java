package home39.citiesWargaming.wargaming.filescreating;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import home39.citiesWargaming.wargaming.IOoperations2;

public class PlayersCreator {

    private static Set<String> playerNames;
    private final static String VOWELS = "aeiouy";
    private final static int PLAYERS_AMOUNT = 155;

    public static void main(String[] args) throws IOException {
	playerNames = new TreeSet<String>();
	IOoperations2 io = new IOoperations2();
	io.createNewFile("resources//wargaming//players.txt");

	for (int i = 0; i < PLAYERS_AMOUNT; i++) {
	    String name = nameCreator();
	    double expirience = ((int) ((Math.random() * 100) * 1000)) / 1000.0;
	    io.writeLine(name + ":" + expirience + "\r\n");
	}
	io.closeFiles();
    }

    private static String nameCreator() {
	String name = "";
	name += (char) ((int) (Math.random() * 26 + 'A'));
	while (true) {
	    for (int i = 1; i < (int) (Math.random() * 8 + 3); i++) {
		String newLetter = "" + (char) (Math.random() * 26 + 'a');
		if ((VOWELS.contains("" + name.charAt(i - 1)) && VOWELS.contains(newLetter))
			|| (!VOWELS.contains("" + name.charAt(i - 1)) && !VOWELS.contains(newLetter))) {
		    i--;
		    continue;
		}
		name += newLetter;
	    }
	    if (playerNames.add(name)) break;
	}
	return name;
    }
}