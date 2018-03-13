package home23.tetris;

public abstract class Figure {
    //координаты фигуры на поле
    protected int[][] coordOnfield = new int[4][2];

    public int[][] getCoordOnfield() {
        return coordOnfield;
    }

    public void setCoordOnfield(int line, int column, int index) {
        coordOnfield[index][0] = line;
        coordOnfield[index][1] = column;
    }

    //перемещение вправо
    public void moveRight() {
	for (int i = 0; i < coordOnfield.length; i++) {
	    coordOnfield[i][1] += 1;
	}
    }
    
    //перемещение вниз
    public void moveDown() {
	for (int i = 0; i < coordOnfield.length; i++) {
	    coordOnfield[i][0] += 1;
	}
    }

    //перемещение влево
    public void moveLeft() {
	for (int i = 0; i < coordOnfield.length; i++) {
	    coordOnfield[i][1] -= 1;
	}
    }
    
    //поворот
    public abstract void rotate(Field field);
}
