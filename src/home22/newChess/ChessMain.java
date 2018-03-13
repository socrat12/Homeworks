package home22.newChess;

public class ChessMain {

    public static void main(String[] args) {

	Player one = new Player("One");
	Player two = new Player("Two");

	Game newGame = new Game(one, two);
	newGame.start(one, two);
    }
}
