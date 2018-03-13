package home15.casino;

import getInput.GetInt;

public class BlackJack {
    private static boolean stay;
    private static int pointsUser, pointsDealer, nextCard;
    private static String[] userCards = new String[9];
    private static String[] dealerCards = new String[9];
    private final static String[] cardDeck = { "2\u2664", "3\u2664", "4\u2664", "5\u2664", "6\u2664", "7\u2664",
	    "8\u2664", "9\u2664", "10\u2664", "2\u2667", "3\u2667", "4\u2667", "5\u2667", "6\u2667", "7\u2667",
	    "8\u2667", "9\u2667", "10\u2667", "2\u2665", "3\u2665", "4\u2665", "5\u2665", "6\u2665", "7\u2665",
	    "8\u2665", "9\u2665", "10\u2665", "2\u2666", "3\u2666", "4\u2666", "5\u2666", "6\u2666", "7\u2666",
	    "8\u2666", "9\u2666", "10\u2666", "V\u2665", "D\u2665", "K\u2665", "V\u2667", "D\u2667", "K\u2667",
	    "V\u2666", "D\u2666", "K\u2666", "V\u2664", "D\u2664", "K\u2664", "T\u2667", "T\u2666", "T\u2665",
	    "T\u2664" };

    public static void enter() {
	boolean game = false;
	System.out.println("Welcome to Blackjack!");
	do {
	    game = false;
	    System.out.println();
	    run();
	    if (Casino.score > 0) {
		System.out.printf("\n\nAgain? \n1: Yes \nOther: No ");
		if (GetInt.get() == 1) {
		    game = true;
		}
	    } else {
		System.out.println("You are bankrupt! Go away!))");
	    }
	} while (game && Casino.score > 0);
    }

    private static void run() {
	init();

	int bet;
	do {
	    System.out.printf("Please input your bet size (<= %d): ", Casino.score);
	    bet = GetInt.get();
	} while (bet > Casino.score);
	Casino.score -= bet;

	if (pointsUser == 21) {
	    printCurrent();
	    System.out.println("Congratulation! You have a Blackjack!");
	    Casino.score += bet * 2;
	    System.out.println("Your score is " + Casino.score);
	    return;
	}

	do {
	    printCurrent();

	    System.out.println("Your move:");
	    System.out.println("1. Hit me");
	    System.out.println("2. Stay");
	    System.out.print(">>>>> ");
	    userChoise();
	    if (pointsUser > 20) {
		printCurrent();
		break;
	    }
	} while (!stay);

	System.out.println("Dealer move");
	dealerMove(bet);
    }

    // обнуление всех параметров
    private static void init() {
	stay = false;
	pointsUser = 0;
	pointsDealer = 0;
	nextCard = 2;
	for (int i = 0; i < userCards.length; i++) {
	    userCards[i] = null;
	    dealerCards[i] = null;
	}
	userCards[0] = cardDeck[scoring(0)];
	userCards[1] = cardDeck[scoring(0)];
	dealerCards[0] = cardDeck[scoring(1)];
    }

    private static void userChoise() {
	switch (GetInt.get()) {
	case 1: {
	    userCards[nextCard] = cardDeck[scoring(0)];
	    nextCard++;
	    break;
	}
	case 2: {
	    stay = true;
	    break;
	}
	default: {
	    System.out.println("Wrong choise!");
	}
	}
    }

    private static void printCurrent() {
	System.out.println("Your money: " + Casino.score);
	System.out.print("User hand: ");
	for (int i = 0; i < userCards.length && userCards[i] != null; i++) {
	    System.out.print(userCards[i] + " ");
	}
	System.out.printf("\t");
	System.out.print("Dealer hand: ");
	for (int i = 0; i < dealerCards.length && dealerCards[i] != null; i++) {
	    System.out.print(dealerCards[i] + " ");
	}
	System.out.println();
	System.out.print("User's points is " + pointsUser);
	System.out.printf("\t");
	System.out.print("Dealer's points is " + pointsDealer);
	System.out.println();
    }

    private static int scoring(int i) {
	int correct = 0, random;
	do {
	    random = (int) (Math.random() * cardDeck.length);
	} while (!repeat(random));

	// корректировка для числовых карт - от позиции отнимаем определённый
	// коэффициент, чтобы получить числовое значение
	if (random < 9) {
	    correct = -2;
	} else if (random > 8 && random < 18) {
	    correct = 7;
	} else if (random > 17 && random < 27) {
	    correct = 16;
	} else if (random > 26 && random < 36) {
	    correct = 25;
	}
	// корректировка для картинок - всегда должно получаться значние 10,
	// независимо от их позиции в массиве
	else if (random > 35 && random < 48) {
	    correct = random % 10 + ((random / 10) - 1) * 10;
	}
	// для тузов - тоже, но 11
	else {
	    correct = (random % 10 + ((random / 10) - 1) * 10) - 1;
	}

	if (i == 0) {
	    pointsUser += random - correct;
	} else {
	    pointsDealer += random - correct;
	}
	return random;
    }

    // проверка отстуствия одинаковых карт на поле - предполагаем, что у нас
    // одна колода
    private static boolean repeat(int random) {
	for (int i = 0; i < userCards.length; i++) {
	    if (cardDeck[random] == userCards[i] || cardDeck[random] == dealerCards[i]) {
		return false;
	    }
	}
	return true;
    }

    private static void dealerMove(int bet) {
	dealerCards[1] = cardDeck[scoring(1)];
	printCurrent();
	if (pointsUser > 21) {
	    if (userCards[2] != null) {
		System.out.print("You lose!");
		if (pointsDealer == 22) {
		    System.out.print(" Dealer has golden point");
		}
		System.out.println();
		System.out.println("Your score is " + Casino.score);
	    } else {
		if (pointsDealer != 22) {
		    System.out.println("You lose!");
		    System.out.println("Your score is " + Casino.score);
		} else {
		    System.out.println("Draw");
		    Casino.score += bet;
		    System.out.println("Your score is " + Casino.score);
		}
	    }
	    return;
	} else {
	    stay = false;
	    nextCard = 2;
	    do {
		if (pointsDealer >= 17 || pointsDealer > pointsUser) {
		    stay = true;
		} else {
		    dealerCards[nextCard] = cardDeck[scoring(1)];
		    printCurrent();
		}
		nextCard++;
	    } while (!stay);

	    if (pointsDealer == pointsUser) {
		System.out.println("Draw");
		Casino.score += bet;
		System.out.println("Your score is " + Casino.score);
	    } else if (pointsDealer > 21 || pointsDealer < pointsUser) {
		if (pointsDealer == 22 && dealerCards[2] == null) {
		    System.out.print("You lose! Dealer has golden point");
		    System.out.println("Your score is " + Casino.score);
		} else {
		    System.out.println("You win!");
		    Casino.score += bet * 2;
		    System.out.println("Your score is " + Casino.score);
		}
	    } else {
		System.out.println("You lose!");
		System.out.println("Your score is " + Casino.score);
	    }
	}
    }
}
