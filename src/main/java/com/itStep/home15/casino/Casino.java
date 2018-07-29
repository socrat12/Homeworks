package com.itStep.home15.casino;

import com.itStep.getInput.GetInt;

public class Casino {
    public static int score;

    public static void main(String[] args) {
	System.out.println("Welcome to The Casino!");
	System.out.print("How much money do you have? ");
	score = GetInt.get();
	System.out.println("Please choise your game:");
	System.out.println("1. Blackjack");
	System.out.println("2. Roulette");
	System.out.print(">>>>> ");
	boolean wrong;
	do {
	    wrong = false;
	    switch (GetInt.get()) {
	    case 1: {
		BlackJack.enter();
		break;
	    }
	    case 2: {
		Roulette.enter();
		break;
	    }
	    default: {
		wrong = true;
	    }
	    }
	} while (wrong);
    }
}
