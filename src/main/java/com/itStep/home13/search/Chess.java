package com.itStep.home13.search;

public class Chess {
    private static String[][] chessBoard;
    static final String[] PIECES = { "\u2659", "\u2656", "\u2658", "\u2657", "\u2655", "\u2654", "\u2657", "\u2658", "\u2656", "\u265f", "\u265c", "\u265d", "\u265e", "\u265b", "\u265a", "\u265e", "\u265d", "\u265c" };

    public static void main(String[] args) {
	initBoard();
	print2d();
	while (true) {
	    System.out.print("Please enter coordinate from: ");
	    //int[] from = Chess.GetMove.get();
	    System.out.printf("Please enter coordinate to: ");
	   // int[] to = Chess.GetMove.get();
	    //makeMove(from, to);
	    print2d();
	    break;
	}
    }

    /*private static void makeMove(int[] from, int[] to) {
	// из ту достать две координаты
	// в массиве чесбоард переставить нужный стринг в нужное место
	chessBoard[to[1]][to[0]] = chessBoard[from[1]][from[0]];
	// на месте где была строка фигура поставить array[i][j] == null
	chessBoard[from[1]][from[0]] = null;
	// добавить выход из цикла по желанию пользователя
	// при вводе "exit" программа завершается
    }*/

    private static void initBoard() {
	chessBoard = new String[8][8];
	for (int i = 0; i < 8; i++) {
	    chessBoard[0][i] = PIECES[i + 1];
	    chessBoard[1][i] = PIECES[0];
	    chessBoard[6][i] = PIECES[9];
	    chessBoard[7][i] = PIECES[i + 10];
	}
    }

    public static void print2d() {
	System.out.print("     ");
	for (char i = 'A'; i <= 'H'; i++) {
	    System.out.print(" " + i + "   ");
	}
	System.out.println();
	System.out.println("    ---------------------------------------");
	for (int i = 0; i < chessBoard.length; i++) {
	    System.out.print(chessBoard.length - i + "  |");
	    for (int j = 0; j < chessBoard[i].length; j++) {
		if (chessBoard[i][j] == null) {
		    if ((i + j) % 2 != 0) {
			System.out.print("|||||");
		    } else {
			System.out.print("    |");
		    }
		} else {
		    if ((i + j) % 2 == 0) {
			System.out.print(" " + chessBoard[i][j] + " |");
		    } else {
			System.out.print("|" + chessBoard[i][j] + "||");
		    }
		}
	    }
	    System.out.print(" " + (chessBoard.length - i));
	    System.out.println();
	    if (i != chessBoard.length - 1) {
		System.out.println();
	    }
	}
	System.out.println("    ---------------------------------------");
	System.out.print("     ");
	for (char i = 'A'; i <= 'H'; i++) {
	    System.out.print(" " + i + "   ");
	}
	System.out.println();
    }
}
