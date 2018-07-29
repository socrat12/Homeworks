package com.itStep.home22.newChess;

public class Game {
    private Board board;

    public Game(Player one, Player two) {
	board = new Board();
	//случаный цвет фигур для игроков
	if (Math.random() > 0.5) {
	    two.color = "White";
	    one.color = "Black";
	} else {
	    two.color = "Black";
	    one.color = "White";
	}
    }

    public void start(Player one, Player two) {
	System.out.println(one);
	System.out.print(two);
	System.out.print(board);
	
	int current = 1;
	while (true) {
	    do {
		System.out.print((current % 2 != 0) ? "White's move: " : "Black's move: ");
		GetMove.get();
	    } while (!Piece.checkMove());
	    board.makeMove((one.color.equals("White") ? one : two));
	    System.out.print(board);
	    current++;
	}
    }
}
