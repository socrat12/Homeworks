package home23.tetris.figures;

import home23.tetris.Field;
import home23.tetris.Figure;

public class Line extends Figure {
    public Line() {
	// задание точек, в которых "присутствуют" элементы фигуры
	coordOnfield[0][0] = 0;
	coordOnfield[0][1] = 4;
	coordOnfield[1][0] = 0;
	coordOnfield[1][1] = 5;
	coordOnfield[2][0] = 0;
	coordOnfield[2][1] = 6;
	coordOnfield[3][0] = 0;
	coordOnfield[3][1] = 7;
    }

    public void rotate(Field field) {
	// если прямая в самом верху или в вертикально положении касается левого
	// края
	if (coordOnfield[0][0] == 0 || (coordOnfield[0][1] == 0 && coordOnfield[1][0] != coordOnfield[0][0])) {
	    return;
	}

	// если прямая в вертикальном положении близко к правому краю или в
	// горизонтальном близко к нижнему краю поля
	if ((coordOnfield[0][1] >= field.field[0].length - 2 && coordOnfield[1][0] != coordOnfield[0][0])
		|| (coordOnfield[0][0] >= field.field.length - 3)) {
	    return;
	}

	// если вертикально расположенная прямая "зажата" для поворота
	if (coordOnfield[1][0] != coordOnfield[0][0] && (field.field[coordOnfield[3][0]][coordOnfield[3][1] + 1]
		|| field.field[coordOnfield[3][0]][coordOnfield[3][1] - 1]
		|| field.field[coordOnfield[2][0]][coordOnfield[2][1] + 1]
		|| field.field[coordOnfield[2][0]][coordOnfield[2][1] - 1]
		|| field.field[coordOnfield[2][0]][coordOnfield[2][1] + 2]
		|| field.field[coordOnfield[1][0]][coordOnfield[1][1] + 1]
		|| field.field[coordOnfield[1][0]][coordOnfield[1][1] - 1]
		|| field.field[coordOnfield[1][0]][coordOnfield[1][1] + 2])) {
	    return;
	}

	// если прямая расположена горизонтально, то повернуть вертикально и на
	if (coordOnfield[1][0] == coordOnfield[0][0]) {
	    rotateToVertical();
	} else {
	    rotateToHorizontal();
	}
    }

    private void rotateToHorizontal() {
	coordOnfield[0][0] += 1;
	coordOnfield[0][1] -= 1;

	coordOnfield[2][0] -= 1;
	coordOnfield[2][1] += 1;

	coordOnfield[3][0] -= 2;
	coordOnfield[3][1] += 2;
    }

    private void rotateToVertical() {
	coordOnfield[0][0] -= 1;
	coordOnfield[0][1] += 1;

	coordOnfield[2][0] += 1;
	coordOnfield[2][1] -= 1;

	coordOnfield[3][0] += 2;
	coordOnfield[3][1] -= 2;
    }
}