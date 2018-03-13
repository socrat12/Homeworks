package home23.tetris.figures;

import home23.tetris.Field;
import home23.tetris.Figure;

public class Z extends Figure {
    public Z() {
	// задание точек, в которых "присутствуют" элементы фигуры
	if (Math.random() > 0.5) {
	    // левосторонная
	    coordOnfield[0][0] = 0;
	    coordOnfield[0][1] = 4;
	    coordOnfield[1][0] = 0;
	    coordOnfield[1][1] = 5;
	    coordOnfield[2][0] = 1;
	    coordOnfield[2][1] = 5;
	    coordOnfield[3][0] = 1;
	    coordOnfield[3][1] = 6;
	} else {
	    // правосторонная
	    coordOnfield[0][0] = 0;
	    coordOnfield[0][1] = 5;
	    coordOnfield[1][0] = 0;
	    coordOnfield[1][1] = 6;
	    coordOnfield[2][0] = 1;
	    coordOnfield[2][1] = 4;
	    coordOnfield[3][0] = 1;
	    coordOnfield[3][1] = 5;
	}
    }

    @Override
    public void rotate(Field field) {
	// поворот левосторонней фигуры в зависимости от текущего положения
	if (coordOnfield[1][1] == coordOnfield[2][1] && coordOnfield[1][0] < coordOnfield[2][0]) {
	    System.out.println("One");
	    // фигура расположена горизонтально
	    if (coordOnfield[0][0] == coordOnfield[1][0]) {
		System.out.println("OneOne");
		coordOnfield[0][0] += 2;
		coordOnfield[3][1] -= 2;
		// фигура расположена вертикально
	    } else {
		System.out.println("OneTwo");
		// невозможен поворот возле крайней правой стенки или если справа препятствие
		if (coordOnfield[1][1] == field.field[0].length - 1
			|| field.field[coordOnfield[1][0]][coordOnfield[1][1] + 1]
			|| field.field[coordOnfield[2][0]][coordOnfield[2][1] + 1]) {
		    System.out.println("OneReturn");
		    return;
		}
		coordOnfield[0][0] -= 2;
		coordOnfield[3][1] += 2;
	    }
	    // поворот правосторонней фигуры в зависимости от текущего положения
	} else {
	    System.out.println("Two");
	    if (coordOnfield[0][0] == coordOnfield[1][0]) {
		System.out.println("TwoOne");
		coordOnfield[1][0] += 2;
		coordOnfield[2][1] += 2;
	    } else {
		System.out.println("TwoTwo");
		// невозможен поворот возле крайней левой стенки или если слева препятствие
		if (coordOnfield[0][1] == 0 
			|| field.field[coordOnfield[0][0]][coordOnfield[0][1] - 1]
			|| field.field[coordOnfield[3][0]][coordOnfield[3][1] - 1]) {
		    System.out.println("TwoReturn");
		    return;
		}
		coordOnfield[1][0] -= 2;
		coordOnfield[2][1] -= 2;
	    }
	}
    }
}