package home10.privet;
/* Даны координаты точки. Нарисовать в консоли две оси (х и у), и саму точку. Координаты могут быть от 1 до 15, только 
 * целые. Допустимая погрешность +-0.5. Вместо точки можно также использовать крестик + или x. */
///+

public class temp {

	public static void main(String[] names) {

		int x = 3, y = 3;

		System.out.println("y ^");
		System.out.println("  |");

		for (int i = 15; i > 0; i--) {
			if (i >= 10) {
				if (y == i) {
					System.out.print(i + "|");
					for (int j = 0; j <= 2 * x - 2; j++) {
						System.out.print(" ");
					}
					System.out.println(".");
				} else {
					System.out.println(i + "|");
				}
			} else {
				if (y == i) {
					System.out.print(" " + i + "|");
					for (int j = 0; j <= 2 * x - 2; j++) {
						System.out.print(" ");
					}
					System.out.println(".");
				} else {
					System.out.println(" " + i + "|");
				}
			}
		}

		System.out.println("  +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+--->");
		System.out.println("  0 1 2 3 4 5 6 7 8 9 0 1 2 3 4 5   x");
	}
}
