package home14.sheepSleep;

public class PeaceOfCake {
    private static char[][] cake = new char[5][6];

    public static void main (String[] args) {
	init();
	print();
	share();
	print();
    }

    private static void init () {
	char[] name = new char[5];
	for (int k = 0; k < 5; k++) {
	    // (char)((Math.random()*26) + 'A' - случайная прописная буква
	    // английского алфавита
	    name[k] = (char) ((Math.random() * 26) + 'A');
	    for (int z = k - 1; z >= 0;) {
		// проверка отсутствия одинаковых букв
		if (name[z] == name[k]) {
		    // если повторение - присвоить последней букве новое
		    // случайное значение
		    name[k] = (char) ((Math.random() * 26) + 'A');
		    // и начать проверку заново
		    z = k - 1;
		    continue;
		}
		z--;
	    }
	    // на случайную клетку установить случайную букву
	    int i = (int) (Math.random() * 5);
	    int j = (int) (Math.random() * 6);
	    if (cake[i][j] == 0) {
		cake[i][j] = name[k];
	    } else {
		k -= 1;
	    }
	}
    }

    private static void share () {
	// проход по горизонтали
	for (int i = 0; i < cake.length; i++) {
	    for (int j = 0; j < cake[i].length; j++) {
		// если наткнулся на букву
		if (cake[i][j] != 0) {
		    // запонить ею всё пустое пространство слева
		    for (int k = j - 1; k >= 0 && cake[i][k] == 0; k--) {
			cake[i][k] = cake[i][j];
		    }
		    // и справа
		    for (int k = j + 1; k < cake[i].length && cake[i][k] == 0; k++) {
			cake[i][k] = cake[i][j];
		    }
		}
	    }
	}
	// проход по вертикали
	for (int i = 0; i < cake[0].length; i++) {
	    for (int j = 0; j < cake.length; j++) {
		// если наткнулся на букву
		if (cake[j][i] != 0) {
		    // запонить ею всё пустое пространство сверху
		    for (int k = j - 1; k >= 0 && cake[k][i] == 0; k--) {
			cake[k][i] = cake[j][i];
		    }
		    // и снизу
		    for (int k = j + 1; k < cake.length && cake[k][i] == 0; k++) {
			cake[k][i] = cake[j][i];
		    }
		}
	    }
	}
    }

    public static void print () {
	System.out.print("-");
	for (int j = 0; j < cake[0].length; j++) {
	    System.out.print("----");
	}
	System.out.println();
	for (int i = 0; i < cake.length; i++) {
	    System.out.print("| ");
	    for (int j = 0; j < cake[i].length; j++) {
		System.out.print(cake[i][j] + " | ");
	    }
	    System.out.println();
	    System.out.print("-");
	    for (int j = 0; j < cake[i].length; j++) {
		System.out.print("----");
	    }
	    System.out.println();
	}
    }
}
