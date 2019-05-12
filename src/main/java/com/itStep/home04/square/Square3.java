package com.itStep.home04.square;

//найти корень, не испульзуя Math.sqrt()
public class Square3 {

    private final static double ACCURACY = 0.000000000000001;

    public static void main(String[] args) {
        // число, из которого извлекается корень
        double number =
            0.0000000000000000000000000000000000000000000000012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890D;

        System.out.println("Handle square from " + number + " is " + squareFind(number));
    }

    private static double squareFind(final double number) {
        if (number < 0) {
            return Double.NaN;
        }

        if (number * number == number) {
            return number;
        }

        double step = number / 2;

        // корректировка для чисел меньше 1
        if (number < 1) {
            step = smallNumbersCorrect(number);
        }
        double answer = step;

        while (!numberIsFound(number, answer)) {
            // приближение к искомому, если меньше
            if (answer * answer < number) {
                answer += step;
                // проверка, не перешагнуло ли "порог" искомого
                if (answer * answer > number) {
                    // уменьшение шага вдвое
                    step /= 2;
                }
                // приближение к искомому, если больше
            } else {
                answer -= step;
                // проверка, не перешагнуло ли "порог" искомого
                if (answer * answer < number) {
                    // уменьшение шага вдвое
                    step /= 2;
                }
            }
        }
        return answer;
    }

    private static double smallNumbersCorrect(final double number) {
        double correct = 1, popravka = number, step = number / 2;
        // уменьшение шага поиска до разряда числа
        while (popravka < 1) {
            popravka *= 10;
            correct *= 4;
            step = number * correct * 10;
        }
        return step;
    }

    private static boolean numberIsFound(final double number, final double answer) {
        return (1 - answer * answer / number) <= ACCURACY && ((1 - answer * answer / number) >= -ACCURACY);
    }
}
