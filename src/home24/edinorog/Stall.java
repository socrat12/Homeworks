package home24.edinorog;

public class Stall {
    public int amount;
    public char color;
    
    public Stall(int amount, char color) {
	this.amount = amount;
	this.color = color;
    }
    
    public String toString() {
	String string = new String();
	
	string += color + ": ";
	string += amount;
	
	return string;
    }
}