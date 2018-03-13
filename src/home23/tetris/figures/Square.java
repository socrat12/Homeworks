package home23.tetris.figures;

import home23.tetris.Field;
import home23.tetris.Figure;

public class Square extends Figure {
    public Square() {
	// задание точек, в которых "присутствуют" элементы фигуры
	coordOnfield[0][0] = 0;
	coordOnfield[0][1] = 4;
	coordOnfield[1][0] = 0;
	coordOnfield[1][1] = 5;
	coordOnfield[2][0] = 1;
	coordOnfield[2][1] = 4;
	coordOnfield[3][0] = 1;
	coordOnfield[3][1] = 5;
    }

    @Override
    public void rotate(Field field) {
	// квадрату не осбо нужен поворот)
	return;
    }
}