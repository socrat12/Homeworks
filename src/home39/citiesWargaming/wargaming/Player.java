package home39.citiesWargaming.wargaming;

public class Player {
    
    private String name;
    private double rating;
    
    public Player(String name, double rating) {
	this.name = name;
	this.rating = rating;
    }
    
    public String getName() {
        return name;
    }

    public double getRating() {
	return rating;
    }

    @Override
    public String toString() {
	return name + ":" + rating;
    }
}