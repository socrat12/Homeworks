package home04.square;

//найти корень, не испульзуя Math.sqrt()
public class Square3 {

    public static void main(String[] args) {
	// число, из которого извлекается корень
	double number = 0.0000000000000000000000000000000000000000000000012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890D;
	double accuracy = 0.000000000000001;

	long time = System.nanoTime();
	System.out.println("  Math square from " + number + " is " + Math.sqrt(number));
	System.out.println("Time - " + (System.nanoTime() - time) / 1000f);

	if (number * number == number) {
	    System.out.println("Handle square from " + number + " is " + number);
	} else if (number < 0) {
	    System.out.println("No answer");
	} else {
	    long timeme = System.nanoTime();

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

	    while (find * find != number) {
		// задание точности
		if (((1 - find * find / number) < accuracy) && ((1 - find * find / number) > -accuracy)) {
		    break;
		}

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
	    System.out.println("Handle square from " + number + " is " + find);
	    System.out.println("Time - " + (System.nanoTime() - timeme) / 1000f);
	}
    }

}
