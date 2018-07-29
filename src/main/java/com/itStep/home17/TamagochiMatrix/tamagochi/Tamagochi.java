package com.itStep.home17.TamagochiMatrix.tamagochi;

public class Tamagochi {
    private static final int MEAT = 1;
    private static final int FISH = 2;
    private static final int CHEESE = 3;
    private static final int GRASS = 4;
    public static final int DOG = 1;
    public static final int CAT = 2;
    public static final int HORSE = 3;
    public static final int ELEPHANT = 4;
    public static final int MOUSE = 5;

    private final int max = 100;
    private int health;
    private int stamina;
    private int hapiness;
    private int id;
    private String name;
    private boolean shit;

    public Tamagochi() {
	health = 60;
	stamina = 30;
	hapiness = 40;
	name = "Cat";
	id = 1;
    }

    public Tamagochi(String name, int health, int stamina, int hapiness, int identificator) {
	this.health = health;
	this.stamina = stamina;
	this.hapiness = hapiness;
	this.name = name;
	id = identificator;
    }

    public void feed(int foodtype, int mass) {
	if (foodtype < 1 || foodtype > 4) {
	    System.err.println("Wrong food");
	    return;
	}
	if (stamina <= 5) {
	    System.out.println("Animal is tired, he need a sleep!");
	    return;
	}
	switch (id) {
	case DOG: {
	    switch (foodtype) {
	    case MEAT: {
		System.out.println("Eating meat");
		health = (health + 10 * mass <= max) ? health + 10 * mass : max;
		hapiness = (hapiness + 10 * mass <= max) ? hapiness + 10 * mass : hapiness;
		break;
	    }
	    case FISH: {
		System.out.println("Eating fish");
		health = (health + 5 * mass <= max) ? health + 5 * mass : max;
		hapiness = (hapiness + 2 * mass <= max) ? hapiness + 2 * mass : hapiness;
		break;
	    }
	    case CHEESE: {
		System.out.println("Eating cheese");
		health = (health + 2 * mass <= max) ? health + 2 * mass : max;
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    case GRASS: {
		System.out.println("The pet is angry for you!");
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    }
	    break;
	}
	case CAT: {
	    switch (foodtype) {
	    case MEAT: {
		System.out.println("Eating meat");
		health = (health + 5 * mass <= max) ? health + 5 * mass : max;
		hapiness = (hapiness + 2 * mass <= max) ? hapiness + 2 * mass : hapiness;
		break;
	    }
	    case FISH: {
		System.out.println("Eating fish");
		health = (health + 10 * mass <= max) ? health + 10 * mass : max;
		hapiness = (hapiness + 10 * mass <= max) ? hapiness + 10 * mass : hapiness;
		break;
	    }
	    case CHEESE: {
		System.out.println("Eating cheese");
		health = (health + 2 * mass <= max) ? health + 2 * mass : max;
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    case GRASS: {
		System.out.println("The pet is angry for you!");
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    }
	    break;
	}
	case ELEPHANT: {
	    switch (foodtype) {
	    case MEAT: {
		System.out.println("The pet is angry for you!");
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    case FISH: {
		System.out.println("The pet is angry for you!");
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    case CHEESE: {
		System.out.println("The pet is angry for you!");
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    case GRASS: {
		System.out.println("Eating grass");
		health = (health + mass <= max) ? health + mass : max;
		hapiness = (hapiness + 2 * mass <= max) ? hapiness + 2 * mass : hapiness;
		break;
	    }
	    }
	    break;
	}
	case HORSE: {
	    switch (foodtype) {
	    case MEAT: {
		System.out.println("The pet is angry for you!");
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    case FISH: {
		System.out.println("The pet is angry for you!");
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    case CHEESE: {
		System.out.println("The pet is angry for you!");
		hapiness = (hapiness - 2 * mass >= 0) ? hapiness - 2 * mass : hapiness;
		break;
	    }
	    case GRASS: {
		System.out.println("Eating grass");
		health = (health + 10 * mass <= max) ? health + 10 * mass : max;
		hapiness = (hapiness + 10 * mass <= max) ? hapiness + 10 * mass : hapiness;
		break;
	    }
	    }
	    break;
	}
	case MOUSE: {
	    switch (foodtype) {
	    case MEAT: {
		System.out.println("Eating meat");
		health = (health + 20 * mass <= max) ? health + 10 * mass : max;
		hapiness = (hapiness + 2 * mass <= max) ? hapiness + 2 * mass : hapiness;
		break;
	    }
	    case FISH: {
		System.out.println("Eating fish");
		health = (health + 20 * mass <= max) ? health + 10 * mass : max;
		hapiness = (hapiness + 2 * mass <= max) ? hapiness + 2 * mass : hapiness;
		break;
	    }
	    case CHEESE: {
		System.out.println("Eating cheese");
		health = (health + 20 * mass <= max) ? health + 10 * mass : max;
		hapiness = (hapiness + 2 * mass <= max) ? hapiness + 2 * mass : hapiness;
		break;
	    }
	    case GRASS: {
		System.out.println("Eating grass");
		health = (health + 20 * mass <= max) ? health + 10 * mass : max;
		hapiness = (hapiness + 2 * mass <= max) ? hapiness + 2 * mass : hapiness;
		break;
	    }
	    }
	    break;
	}
	default: {
	    System.err.println("Wrong ID");
	}
	}

    }

    public void sleep(int hours) {
	switch (id) {
	case DOG: {
	    stamina = (stamina + hours * 15 <= max) ? stamina + hours * 15 : max;
	    break;
	}
	case CAT: {
	    stamina = (stamina + hours * 10 <= max) ? stamina + hours * 10 : max;
	    break;
	}
	case ELEPHANT: {
	    stamina = (stamina + hours * 25 <= max) ? stamina + hours * 25 : max;
	    break;
	}
	case HORSE: {
	    stamina = (stamina + hours * 20 <= max) ? stamina + hours * 20 : max;
	    break;
	}
	case MOUSE: {
	    stamina = (stamina + hours * 5 <= max) ? stamina + hours * 5 : max;
	    break;
	}
	default: {
	    System.err.println("Wrong ID");
	}
	}
    }

    public void game() {
	if (health <= 10) {
	    System.out.println("Animal is seek, he need a vet!");
	    return;
	}
	if (stamina <= 10) {
	    System.out.println("Animal is tired, he need a sleep!");
	    return;
	}

	switch (id) {
	case DOG: {
	    System.out.println("You plaing with your pet. He is happier");
	    hapiness = (hapiness + 5 <= max) ? hapiness + 5 : max;
	    break;
	}
	case CAT: {
	    System.out.println("You plaing with your pet. He is happier");
	    hapiness = (hapiness + 20 <= max) ? hapiness + 20 : max;
	    break;
	}
	case ELEPHANT: {
	    System.out.println("You plaing with your pet. He is happier");
	    hapiness = (hapiness + 10 <= max) ? hapiness + 10 : max;
	    break;
	}
	case HORSE: {
	    System.out.println("You plaing with your pet. He is happier");
	    hapiness = (hapiness + 8 <= max) ? hapiness + 8 : max;
	    break;
	}
	case MOUSE: {
	    System.out.println("You plaing with your pet. He is happier");
	    hapiness = (hapiness + 6 <= max) ? hapiness + 6 : max;
	    break;
	}
	default: {
	    System.err.println("Wrong ID");
	}
	}
    }

    public void status() {
	System.out.println("Your pet " + name + " status:");
	System.out.printf("\nHealth: %d\nEnergy: %d\nHapiness: %d\n", health, stamina, hapiness);
	if (shit) {
	    System.out.println("You need to clean up ))))");
	    System.out.print("\n\n@@@@@@@@@@@@@@");
	}
	System.out.println();
    }

    public void vet() {
	health = (health < 50) ? 50 : health;
    }

    public void shit() {
	shit = true;
    }

    public void clean() {
	shit = false;
    }

    public String HowAreYou() {
	if (health < 30) {
	    return "I'm hungry, please feed me";
	}

	if (stamina < 30) {
	    return "I'm tired, please let me sleep";
	}

	if (hapiness < 30) {
	    return "I'm sad, please game with me";
	}

	return "Not so bad";
    }

    public void endOfCycle() {
	health -= 3;
	stamina = (stamina - 3 >= 0) ? stamina - 3 : 0;
	hapiness = (hapiness - 3 >= 0) ? hapiness - 3 : 0;
    }

    public boolean alive() {
	if (health > 0) {
	    return true;
	}
	return false;
    }

    public void shower() {
	if (health <= 10) {
	    System.out.println("Animal is seek, he need a vet!");
	    return;
	}
	if (stamina <= 10) {
	    System.out.println("Animal is tired, he need a sleep!");
	    return;
	}

	switch (id) {
	case DOG: {
	    System.out.println("You wash your dog");
	    clean();
	    hapiness = (hapiness + 20 <= max) ? hapiness + 20 : max;
	    break;
	}
	case CAT: {
	    System.out.println("Your cat snarls at you and bites");
	    hapiness = (hapiness - 20 >= 0) ? hapiness - 20 : max;
	    break;
	}
	case ELEPHANT: {
	    System.out.println("You wash your elephant");
	    hapiness = (hapiness + 30 <= max) ? hapiness + 30 : max;
	    break;
	}
	case HORSE: {
	    System.out.println("You wash your horse");
	    hapiness = (hapiness + 15 <= max) ? hapiness + 15 : max;
	    break;
	}
	case MOUSE: {
	    System.out.println("You wash your mouse");
	    hapiness = (hapiness - 5 >= 0) ? hapiness - 5 : max;
	    break;
	}
	default: {
	    System.err.println("Wrong ID");
	}
	}
    }

    public void pumper() {
	switch (id) {
	case DOG: {
	    System.out.println("You stroked your cat. He does not care");
	    break;
	}
	case CAT: {
	    System.out.println("You stroked your dog. He is incredibly happy");
	    hapiness = (hapiness + 30 <= max) ? hapiness + 30 : max;
	    break;
	}
	case ELEPHANT: {
	    System.out.println("You stroked your elephant. He did't notice that");
	    break;
	}
	case HORSE: {
	    System.out.println("You stroked your horse. He is a little pleased");
	    hapiness = (hapiness + 10 <= max) ? hapiness + 10 : max;
	    break;
	}
	case MOUSE: {
	    System.out.println("You stroked your mouse. She is afraid of you");
	    hapiness = (hapiness - 15 >= 0) ? hapiness - 15 : max;
	    shit();
	    break;
	}
	default: {
	    System.err.println("Wrong ID");
	}
	}
    }
}
