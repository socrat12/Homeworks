package home22.newChess;

public abstract class Piece {

    public boolean color;
    public char name;
    public int letter;
    public int digit;

    public char getName() {
	return name;
    }

    @Override
    public String toString() {
	String temp = new String();
	temp += (color) ? 'W' : 'B';
	temp += name;
	return temp;
    }

    public static boolean checkMove() {
	// TODO Auto-generated method stub
	return true;
    }
}