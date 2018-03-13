package home04.square;

//найти корень, не испульзуя Math.sqrt()
public class Square4 {
    // число, из которого извлекается корень
    private static double number = 0.00000000000000000000000000012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890D;
    // до какого знака после запятой считать
    private static double accuracy = 0.0000000000000001;

    public static void main(String[] args) {
	long time = System.nanoTime();
	double answer2 = sqrt(number, accuracy);
	System.out.println("  Math square from " + number + " is " + answer2);
	System.out.println("Time - " + (System.nanoTime() - time));

	time = System.nanoTime();
	double answer = sqrt(number, accuracy);
	System.out.println("Handle square from " + number + " is " + answer);
	System.out.println("Time - " + (System.nanoTime() - time));

	time = System.nanoTime();
	answer2 = sqrtJava(number);
	System.out.println("  Math square from " + number + " is " + answer2);
	System.out.println("Time - " + (System.nanoTime() - time));
    }

    private static double sqrt(double number, double accuracy) {
	if (number * number == number) {
	    return number;
	}
	if (number < 0) {
	    return Double.NaN;
	}

	double correct = 1, popravka = number, step = number / 2;

	// корректировка для чисел меньше 1
	if (number < 1) {
	    // уменьшение шага поиска до разряда числа
	    while (popravka < 1) {
		popravka *= 10;
		correct *= 4;
		step = number * correct * 10;
	    }
	}
	// предполагаемое число
	double find = step;

	while (find * find / number + accuracy != 1 && find * find / number - accuracy != 1) {
	    // приближение к искомому, если меньше
	    if (find * find < number) {
		find += step;
		// проверка, не перешагнуло ли "порог" искомого
		if (find * find > number) {
		    // уменьшение шага вдвое
		    step /= 2;
		}
		// приближение к искомому, если больше
	    } else {
		find -= step;
		// проверка, не перешагнуло ли "порог" искомого
		if (find * find < number) {
		    // уменьшение шага вдвое
		    step /= 2;
		}
	    }
	}
	return find;
    }

    private static double sqrtJava(double number) {
	return Math.sqrt(number);
    }
}