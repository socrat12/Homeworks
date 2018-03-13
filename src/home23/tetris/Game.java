package home23.tetris;

import getInput.GetInt;
import home23.tetris.figures.*;

public class Game {
    private Field field;

    public Game() {
	field = new Field();
    }

    public void start() {

	while (field.stackIsNtFull) {
	    // текущая фигура
	    Figure currentPiece = figureRandom();
	    field.figureInGame = true;
	    // ввод фигуры в игру вверху поля
	    field.appearFig(currentPiece);

	    while (field.figureInGame) {
		// отрисовка поля
		System.out.println(field);
		System.out.println("Possible move:\n1. Left\n2. Right\n3. Rotate" + "\n4. Down\n5. Completly down");

		move(currentPiece);
	    }
	}
	System.out.println(field);
	System.out.println("Game is over");
    }

    // выбор хода пользователем
    private void move(Figure currentPiece) {
	switch (GetInt.get()) {
	// перемещение влево
	case (1): {
	    field.moveLeft(currentPiece);
	    field.moveDown(currentPiece);
	    break;
	}
	// перемещение вправо
	case (2): {
	    field.moveRight(currentPiece);
	    field.moveDown(currentPiece);
	    break;
	}
	// поворот
	case (3): {
	    field.rotate(currentPiece);
	    break;
	}
	// перемещение вниз
	case (4): {
	    field.moveDown(currentPiece);
	    break;
	}
	// перемещение вниз до упора
	case (5): {
	    while (field.figureInGame) {
		field.moveDown(currentPiece);
	    }
	    break;
	}
	case (0): {
	    field.stackIsNtFull = false;
	    field.figureInGame = false;
	    break;
	}
	default: {
	    break;
	}
	}
    }

    //выбор случайной фигуры
    private Figure figureRandom() {
	Figure currentPiece = null;
	switch ((int) (Math.random() * 5)) {
	case 0:
	    currentPiece = new L();
	    break;
	case 1:
	    currentPiece = new Line();
	    break;
	case 2:
	    currentPiece = new Square();
	    break;
	case 3:
	    currentPiece = new T();
	    break;
	case 4:
	    currentPiece = new Z();
	    break;
	default:
	    break;
	}
	return currentPiece;
    }
}