package home39.citiesWargaming.wargaming.filescreating;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import home39.citiesWargaming.wargaming.IOoperations2;

public class TeamCreator {

    private static ArrayList<String> players;
    private static Set<Long> teamsID;
    private final static int teamSize = 5;
    
    public static void main(String[] args) {
	IOoperations2 io = new IOoperations2("resources//wargaming//players.txt");
	teamsID = new TreeSet<Long>();
	players = new ArrayList<String>();
	
	while (io.isReady()) {
	    players.add(io.readLine());
	}
	io.closeFiles();
	
	IOoperations2 io2 = new IOoperations2();
	io2.createNewFile("resources//wargaming//teams.txt");
	int amount = players.size() / teamSize;
	for (int i = 0; i < amount; i++) {
	    io2.writeLine(teamBuilder());
	}
	io2.closeFiles();
    }

    private static String teamBuilder() {
	String team = teamID() + ":";
	for (int i = 0; i < teamSize; i++) {
	    if (players.size() == 0) return "";
	    int randPlayer = (int)(Math.random() * players.size());
	    String name = players.get(randPlayer).split(":")[0];
	    team += name + (i != teamSize - 1 ? "," : "\r\n");
	    players.remove(randPlayer);
	}
	return team;
    }

    private static String teamID() {
	long id;
	while (true) {
	    id = (long) (Math.random() * 1000000);
	    if (teamsID.add(id)) break;
	}
	return "" + id;
    }
}