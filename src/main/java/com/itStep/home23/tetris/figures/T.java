package com.itStep.home23.tetris.figures;

import com.itStep.home23.tetris.Field;
import com.itStep.home23.tetris.Figure;

public class T extends Figure {
    public T() {
	// задание точек, в которых "присутствуют" элементы фигуры
	coordOnfield[0][0] = 0;
	coordOnfield[0][1] = 5;
	coordOnfield[1][0] = 1;
	coordOnfield[1][1] = 4;
	coordOnfield[2][0] = 1;
	coordOnfield[2][1] = 5;
	coordOnfield[3][0] = 1;
	coordOnfield[3][1] = 6;
    }

    @Override
    public void rotate(Field field) {
	// невозможен поворот из крайнего правого положения или крайнего левого
	// положения
	if (coordOnfield[1][1] == coordOnfield[2][1]
		&& (coordOnfield[1][1] == field.field[0].length - 1 || coordOnfield[1][1] == 0)) {
	    return;
	}
	// невозможен поворот, если рядом препятствие
	if (coordOnfield[1][1] == coordOnfield[2][1] && (field.field[coordOnfield[1][0]][coordOnfield[1][1] + 1]
		|| field.field[coordOnfield[1][0]][coordOnfield[1][1] - 1]
		|| field.field[coordOnfield[2][0]][coordOnfield[2][1] + 1]
		|| field.field[coordOnfield[2][0]][coordOnfield[2][1] - 1]
		|| field.field[coordOnfield[3][0]][coordOnfield[3][1] + 1]
		|| field.field[coordOnfield[3][0]][coordOnfield[3][1] - 1])) {
	    return;
	}

	// координаты, которые изменяютя независимо от текущего положения всегда
	// одинаково
	coordOnfield[1][0] = coordOnfield[0][0];
	coordOnfield[1][1] = coordOnfield[0][1];

	coordOnfield[0][0] = coordOnfield[3][0];
	coordOnfield[0][1] = coordOnfield[3][1];

	// поворот в зависимости от текущего положения
	if (coordOnfield[3][1] > coordOnfield[2][1]) {
	    coordOnfield[3][0] += 1;
	    coordOnfield[3][1] -= 1;
	} else if (coordOnfield[3][0] > coordOnfield[2][0]) {
	    coordOnfield[3][0] -= 1;
	    coordOnfield[3][1] -= 1;
	} else if (coordOnfield[3][1] < coordOnfield[2][1]) {
	    coordOnfield[3][0] -= 1;
	    coordOnfield[3][1] += 1;
	} else if (coordOnfield[3][0] < coordOnfield[2][0]) {
	    coordOnfield[3][0] += 1;
	    coordOnfield[3][1] += 1;
	}
    }
}
