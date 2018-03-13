package home04.square;
//Разветвляющиеся алгоритмы. Разработать схемы алгоритмов.

//2. Даны два числа x и y. Можно ли через точку (x,y) 
//провести окружность единичного радиуса с центром в начале координат.

public class Task2 {
    public static void main(String[] args) {
	double x = -0.8366600265340756, y = 0.5477225575051659, r = 1;
	// формула окружности x^2 + y^2 = R^2
	double f = x * x + y * y; 
	
	if (((f - r) > -0.000000001) && ((f - r) < 0.000000001)) {
	    System.out.println("Yes");
	} else {
	    System.out.println("No");
	}
    }

}
