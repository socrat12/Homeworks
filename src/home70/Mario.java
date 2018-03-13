package home70;

import java.util.ArrayList;
import java.util.List;

public class Mario {

    private boolean movePossible = true;
    private boolean right = false;
    private boolean left = false;
    private List<Integer> platform;
    private int index;
    private int brickNUmber;
    
    public Mario (int size, int position) {
	this.index = position;
	
	platform = new ArrayList<>();
	for (int i = 0; i < size; i++) {
	    platform.add(i);
	}
	brickNUmber = platform.get(index);
    }
    
    void jumpLeft() {
	if (index < 2) {
	    //System.out.println("Некуда прыгать влево");
	    if (!right) left = true;
	    else movePossible = false;
	    return;
	} 
	platform.remove(index);
	index -= 2;
	brickNUmber = platform.get(index);
	left = false;
	right = false;
    }
    
    void jumpRight() {
	if (platform.size() - 1 - index < 2) {
	    //System.out.println("Некуда прыгать вправо");
	    if (!left) right = true;
	    else movePossible = false;
	    return;
	} 
	platform.remove(index);
	index += 1;
	brickNUmber = platform.get(index);
	right = false;
	left = false;
    }
    
    int currentPosition() {
	return brickNUmber;
    }
    
    public boolean isMovePossible() {
	return movePossible;
    }
    
    public int getPlatformSize() {
	return platform.size();
    }

    public static void main (String[] args) {
	int size = 1000000;
	Mario mario = new Mario(size, size / 2);
	long time = System.nanoTime();
	while (mario.isMovePossible()) {
	    System.out.println(mario.currentPosition());
	    if (Math.random() < 0.5) mario.jumpRight();
	    else mario.jumpLeft();
	}
	System.out.println((System.nanoTime() - time) / 1000000000.0);
	System.out.println(mario.getPlatformSize());
    }
}
