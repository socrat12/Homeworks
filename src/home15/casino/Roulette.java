package home15.casino;

import getInput.GetInt;

public class Roulette {
    private static int[] field = new int[37];
    private static int[] redNumbers = new int[18];
    private static int ball;

    public static void enter() {
	boolean game = false;
	System.out.println("Welcome to Roulette!");
	// обозначение какие ячейки относятся к красным, какие - к чёрным
	initRed();
	do {
	    game = false;
	    run();

	    if (Casino.score > 0) {
		System.out.printf("\nNext? \n1: Yes \nOther: No ");
		if (GetInt.get() == 1) {
		    game = true;
		}
	    } else {
		System.out.println("You are bankrupt");
	    }
	}
	// играть, пока пользователь не передумает или не проиграет все деньги
	while (game && Casino.score > 0);

    }

    private static void run() {
	// вывести поле для фишек
	ball = -1;
	print();
	int bet;
	do {
	    System.out.printf("Please input your bet size (<= %d): ", Casino.score);
	    bet = GetInt.get();
	} while (bet > Casino.score);

	Casino.score -= bet;
	System.out.println("Possible bet:");
	System.out.printf("1. Odd\n2. Even\n3. Black\n4. Red\n5. Zero");
	System.out.printf("\n6. 1st 12\n7. 2nd 12\n8. 3rd 12\n9. 1 to 18\n10. 19 to 36");
	System.out.printf("\n11. 1st column\n12. 2nd column\n13. 3rd column\n14. To number\n>>>> ");

	// "запуск" шарика
	ball = (int) (Math.random() * 37);

	switch (GetInt.get()) {
	case 1: {
	    // нечётные, выигрыш 2 к 1
	    if (ball % 2 != 0) {
		print();
		Casino.score += bet * 2;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 2: {
	    // чётные, выигрыш 2 к 1
	    if (ball % 2 == 0 && ball != 0) {
		print();
		Casino.score += bet * 2;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 3: {
	    // чёрное, выигрыш 2 к 1
	    if (!redChek(ball)) {
		print();
		Casino.score += bet * 2;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 4: {
	    // красное, выигрыш 2 к 1
	    if (redChek(ball)) {
		print();
		Casino.score += bet * 2;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 5: {
	    // зеро, выигрыш 37 к 1
	    if (ball == 0) {
		print();
		Casino.score += bet * 37;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 6: {
	    // первая 12-ка, выигрыш 3 к 1
	    if (ball >= 1 && ball <= 12) {
		print();
		Casino.score += bet * 3;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 7: {
	    // вторая 12-ка, выигрыш 3 к 1
	    if (ball > 12 && ball <= 24) {
		print();
		Casino.score += bet * 3;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 8: {
	    // третья 12-ка, выигрыш 3 к 1
	    if (ball > 24 && ball <= 36) {
		print();
		Casino.score += bet * 3;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 9: {
	    // первая половина, выигрыш 2 к 1
	    if (ball >= 1 && ball <= 18) {
		print();
		Casino.score += bet * 2;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 10: {
	    // вторая половина, выигрыш 2 к 1
	    if (ball > 18 && ball <= 36) {
		print();
		Casino.score += bet * 2;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 11: {
	    // первый столбец, выигрыш 3 к 1
	    if (ball % 3 == 1) {
		print();
		Casino.score += bet * 3;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 12: {
	    // второй столбец, выигрыш 3 к 1
	    if (ball % 3 == 2) {
		print();
		Casino.score += bet * 3;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 13: {
	    // третий столбец, выигрыш 3 к 1
	    if (ball % 3 == 0) {
		print();
		Casino.score += bet * 3;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	case 14: {
	    // конкретное число, выигрыш 37 к 1
	    System.out.print("What number? ");
	    if (ball == GetInt.get()) {
		print();
		Casino.score += bet * 37;
		System.out.println("Congratulation! You won! Your score is " + Casino.score);
		return;
	    }
	    break;
	}
	default: {
	    System.out.println("Wrong choise!");
	}
	}
	print();
	System.out.println("You lose! Your score is " + Casino.score);
    }

    private static void initRed() {
	int red = 1;
	for (int i = 0; i < redNumbers.length; i++) {
	    redNumbers[i] = red;
	    if (red % 9 == 0) {
		if (red / 9 == 2) {
		    red -= 1;
		} else {
		    red += 1;
		}
	    }
	    red += 2;
	}
    }

    private static boolean redChek(int number) {
	for (int i = 0; i < redNumbers.length; i++) {
	    if (number == redNumbers[i]) {
		return true;
	    }
	}
	return false;
    }

    private static void print() {
	if (field[0] == ball) {
	    System.out.printf("\t\t|\t\u20DD\t|");
	} else {
	    System.out.printf("\t\t|\t%d\t|", field[0]);
	}
	System.out.printf("\n-------------------------------------------------\n");
	for (int i = 1; i < field.length; i++) {
	    field[i] = i;
	    // вывод "шарика" вместо цифры
	    if (field[i] == ball) {
		if (!redChek(field[i])) {
		    // вывод чёрных ячеек
		    System.out.printf("||||||||\u20DD||||||");
		} else {
		    // вывод красных ячеек
		    System.out.printf("|\t\u20DD\t");
		}
	    } else {
		if (!redChek(field[i])) {
		    // вывод чёрных ячеек
		    System.out.printf("||||||||%d||||||", field[i]);
		} else {
		    // вывод красных ячеек
		    System.out.printf("|\t%d\t", field[i]);
		}
	    }
	    if (i % 3 == 0) {
		System.out.printf("|\n-------------------------------------------------\n");
	    }
	}
    }
}
