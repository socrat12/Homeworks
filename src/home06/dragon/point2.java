package home06.dragon;
/*Задание 2
Даны координаты точки. Нарисовать в консоли две оси (х и у), и саму точку. 
Координаты могут быть от 1 до 15, только целые. Допустимая погрешность +-0.5. 
Вместо точки можно также использовать крестик + или Х. 
Как-то так (на моноширинном шрифте консоли смотрится лучше): точка х=3, у=2:*/

public class point2 {
    public static void main(String[] args) {
	int x = 11, y = 11;
	if ((x > 15) || (x < 1) || (y > 15) || (y < 1)) {
	    System.exit(0);
	}
	System.out.println("  ^");
	for (int j = 16; j >= 0; j--) {
	    if  (j < 10)
	    {
		System.out.print(" ");
	    }
	    System.out.print(j);
	    System.out.print("|");
	    if (j == y) {
		System.out.print(" ");
		for (int i = 0; i < x-1; i++) {
		    System.out.print("  ");
		}
		System.out.print("+");
	    }
	    if (j != 0) {
		System.out.println();
	    }
	}
	System.out.println("---------------------------------------->");
	System.out.print("  ");
	for (int i = 0; i < 17; i++) {
	    System.out.print(i%10 + " ");
	}
    }
}
