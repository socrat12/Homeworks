package home23.tetris;

public class Field {
    //размер игрового поля
    public boolean[][] field = new boolean[20][11];
    //очки
    private int score;
    // пока true - фигура ещё доступна для манипуляций
    public boolean figureInGame;
    // если false - конец игры, заполнение поля
    public boolean stackIsNtFull;
    
    public Field() {
	stackIsNtFull = true;
	score = 0;
    }

    public void moveDown(Figure figure) {

	// копирование координат фигуры во временный массив coord
	int[][] coord = figure.getCoordOnfield();

	// стирание фигуры
	eraseFig(coord);
	for (int i = 0; i < coord.length; i++) {
	    // если внизу не пусто, остановить и нарисовать фигуру
	    if (coord[i][0] == field.length - 1 || field[coord[i][0] + 1][coord[i][1]]) {
		// отрисовка текущей фигуры
		drawFig(coord);
		// проверка не собралась ли линия
		lineCheck();
		// запрос новой фигуры
		figureInGame = false;
		return;
	    }
	}
	// изменение координат фигуры со смещением вниз
	figure.moveDown();

	// копирование координат фигуры во временный массив coord
	coord = figure.getCoordOnfield();

	eraseFig(coord);
	for (int i = 0; i < coord.length; i++) {
	    // если достигнут нижний предел поля или дальше не пусто
	    if (coord[i][0] == field.length - 1 || field[coord[i][0] + 1][coord[i][1]]) {
		figureInGame = false;
		drawFig(coord);
		lineCheck();
		return;
	    }
	}

	drawFig(coord);
    }

    // сдвиг влево
    public void moveLeft(Figure figure) {
	int[][] coord = figure.getCoordOnfield();

	eraseFig(coord);
	for (int i = 0; i < coord.length; i++) {
	    // если слева не свободно
	    if (coord[i][1] == 0 || field[coord[i][0]][coord[i][1] - 1]) {
		drawFig(coord);
		return;
	    }
	}

	figure.moveLeft();
	coord = figure.getCoordOnfield();

	drawFig(coord);
    }

    // сдвиг вправо
    public void moveRight(Figure figure) {
	int[][] coord = figure.getCoordOnfield();

	eraseFig(coord);
	for (int i = 0; i < coord.length; i++) {
	    // если справа не свободно
	    if (coord[i][1] == field[0].length - 1 || field[coord[i][0]][coord[i][1] + 1]) {
		drawFig(coord);
		return;
	    }
	}

	figure.moveRight();
	coord = figure.getCoordOnfield();

	drawFig(coord);
    }

    // поворот
    public void rotate(Figure figure) {

	int[][] coord = figure.getCoordOnfield();

	eraseFig(coord);
	figure.rotate(this);
	coord = figure.getCoordOnfield();

	drawFig(coord);
    }

    // ввод фигуры в игру вверху поля
    public void appearFig(Figure figure) {
	int[][] coord = figure.getCoordOnfield();
	for (int i = 0; i < coord.length; i++) {
	    if (!field[coord[i][0]][coord[i][1]]) {
		field[coord[i][0]][coord[i][1]] = true;
	    } else {
		stackIsNtFull = false;
		figureInGame = false;
		return;
	    }
	}
    }

    // нарисовать фигуру
    private void drawFig(int[][] coord) {
	for (int i = 0; i < coord.length; i++) {
	    field[coord[i][0]][coord[i][1]] = true;
	}
    }

    // стереть фигуру
    private void eraseFig(int[][] coord) {
	for (int i = 0; i < coord.length; i++) {
	    field[coord[i][0]][coord[i][1]] = false;
	}
    }

    // поиск "собранных" линий
    private void lineCheck() {
	int series = 0; 
	
	for (int i = field.length - 1; i >= 0; i--) {
	    boolean full = true;
	    for (int j = 0; j < field[i].length; j++) {
		if (!field[i][j]) {
		    full = false;
		}
	    }
	    if (full) {
		series++;
		score += series;
		for (int j = 0; j < field[i].length; j++) {
		    field[i][j] = false;
		}
		for (int k = i; k > 0; k--) {
		    for (int j = 0; j < field[k].length; j++) {
			field[k][j] = field[k - 1][j];
		    }

		}
		i++;
	    }
	}
    }

    @Override
    public String toString() {
	String output = "\n\nScore: " + score + "\n";
	for (int i = 0; i < field.length; i++) {
	    output += "\t\t\t\t*";
	    for (int j = 0; j < field[i].length; j++) {
		output += (!field[i][j]) ? " " : "X";
	    }
	    output += "*\n";
	}
	output += "\t\t\t\t**";
	for (int i = 0; i < field[0].length; i++) {
	    output += "*";
	}
	return output;
    }
}