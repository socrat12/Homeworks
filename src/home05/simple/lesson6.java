package home05.simple;
//Решить квадратное уравнение методом полного перебора всех чисел от -100000 до +100000 с шагом 0.1. 
public class lesson6 {

    public static void main(String[] args) {
	double a = 2, b = 5, c = 2, d;

	d = calculateD(a, b, c);
	calculateAnswer(a, b, d);
    }

    private static void calculateAnswer(double a, double b, double d) {
	if (d == 0) {
	    calculateX(a, b);
	} else if (d > 0) {
	    calculateX1x2(a, b, d);
	} else {
	    System.out.println("No answer");
	}
    }

    private static void calculateX1x2(double a, double b, double d) {
	double xOne = (-b + Math.sqrt(d)) / 2 * a;
	double xTwo = (-b - Math.sqrt(d)) / 2 * a;
	System.out.println("x1 is " + xOne);
	System.out.println("x2 is " + xTwo);
    }

    private static void calculateX(double a, double b) {
	System.out.println("X is " + ((-b) / 2 * a));
    }

    private static double calculateD(double a, double b, double c) {
	return b * b - 4 * a * c;
    }

}
