package home22.newChess;

public class Player {

    String color;
    String name;
    
    public Player(String name) {
	this.name = name;
    }

    @Override
    public String toString() {
        return "Player " + name + ". " + color;
    }
}
