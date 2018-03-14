package getInput;

import java.util.Scanner;

public class GetInt {
    
    private static Scanner take = new Scanner(System.in);
    
    public static int get() {
	String input = take.nextLine();

	while (!check(input)) {
	    System.out.println("Wrong Input. Retry >>");
	    input = take.nextLine();
	}
	// take.close();

	return Integer.parseInt(input);
    }

    public static boolean check(String input) {
	if (input.equals("exit")) {
	    System.exit(0);;
	}
	// если ничего не введено или длина больше максимальной длины для int
	if (input.length() < 1 || input.length() > 11) {
	    return false;
	}

	for (int i = 0; i < input.length(); i++) {
	    // если первый символ минус и он не единственный, продолжить, в
	    // противном случае - false
	    if (i == 0 && input.charAt(i) == '-') {
		if (input.length() > 1) {
		    continue;
		} else {
		    return false;
		}
	    }
	    boolean exist = false;
	    for (char j = '0'; j <= '9'; j++) {
		// совпадает ли каждый поседующий с арабскими цифрами
		if (j == input.charAt(i)) {
		    exist = true;
		    break;
		}
	    }
	    if (!exist) {
		return false;
	    }
	}
	if (input.length() > 8) {
	    // преобразовать строку во временную переменную типа long для
	    // сравнения с минимальным и максимальным значением
	    Long one = Long.parseLong(input);
	    if (one < -2147483648 || one > 2147483647) {
		return false;
	    }
	}
	return true;
    }
}
