package com.itStep.home39.citiesWargaming.wargaming;

import java.util.HashMap;

public class Team {
    private long id; 
    private double rating; 
    private Player[] players;

    public Team(HashMap<String,Double> players2, long id, String ...names) {
	this.id = id;
	players = new Player[names.length];
	for (int i = 0; i < names.length; i++) {
	    players[i] = new Player(names[i], players2.get(names[i]));
	}
	rating = calculateRating();
    }
    
    public double getRating() {
	return rating;
    }

    public long getId() {
        return id;
    }
    
    public double calculateRating () {
	double rate = 0;
	for (Player player : players) {
	    rate += player.getRating();
	}
	return ((int) (rate * 1000)) / 1000.0;
    }
    
    @Override
    public String toString() {
	String ret = id + ":";
	for (int i = 0; i < players.length; i++) {
	    ret += players[i] + (i != players.length - 1 ? "," : "\r\n");
	}
	return ret;
    }
}
