package com.itStep.home39.citiesWargaming.wargaming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Pairing {

    private static HashMap<String, Double> players = new HashMap<String, Double>();;
    private static ArrayList<Team> teams = new ArrayList<Team>();;
    private static IOoperations2 io;

    public static void main (String[] args) {

	playersReading();

	teamReading();

	sortTeam();

	pairsWriting();

	System.out.println("Done");
    }

    /**
     * 
     */
    private static void pairsWriting () {
	io = new IOoperations2();
	io.createNewFile("resources/wargaming/pairs.txt");
	if (teams.size() % 2 != 0) findAndDeleteExcess();
	for (int i = 0; i < teams.size() - 1; i++) {
	    System.out.println(teams.get(i).getRating());
	    io.writeLine(teams.get(i++).getId() + " - " + teams.get(i).getId() + "\r\n");
	    System.out.println(teams.get(i).getRating());
	}
	io.closeFiles();
    }

    private static void findAndDeleteExcess () {
	List<Double> diffrence = new ArrayList<Double>();
	for (int i = 0; i < teams.size() - 1; i++) {
	    double tempMax = teams.get(i + 1).getRating() - teams.get(i).getRating();
	    diffrence.add(tempMax);
	}
	for (int i = 0; i < diffrence.size(); i++) {
	    System.out.println(i + ": " + diffrence.get(i));
	}
	System.out.println();
    }

    /**
     * 
     */
    private static void playersReading () {
	IOoperations2 io = new IOoperations2("resources/wargaming/players.txt");
	while (io.isReady()) {
	    String[] temp = io.readLine().split(":");
	    players.put(temp[0], Double.parseDouble(temp[1]));
	}
    }

    /**
     * 
     */
    private static void teamReading () {
	IOoperations2 io;
	io = new IOoperations2("resources/wargaming/teams.txt");
	while (io.isReady()) {
	    String[] temp = io.readLine().split(":");
	    teams.add(new Team(players, Long.parseLong(temp[0]), temp[1].split(",")));
	}
    }

    /**
     * 
     */
    private static void sortTeam () {
	Comparator<Team> c = new Comparator<Team>() {
	    @Override
	    public int compare (Team o1, Team o2) {
		if (o1.getRating() - o2.getRating() > 0) return 1;
		if (o1.getRating() - o2.getRating() < 0) return -1;
		else return 0;
	    }
	};
	teams.sort(c);
	for (int i = 0; i < teams.size(); i++) {
	    System.out.println(i + ": " + teams.get(i).getRating());
	}
	System.out.println();
    }
}
