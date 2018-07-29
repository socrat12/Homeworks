package com.itStep.home70.mario;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MarioIterator {

    private boolean movePossible = true;
    private boolean right = false;
    private boolean left = false;
    private int brickNUmber;
    private List<Integer> platform;
    private ListIterator<Integer> it;
    
    public MarioIterator (int size, int position) {
	platform = new LinkedList<>();
	
	for (int i = 0; i < size; i++) {
	    platform.add(i);
	}
	
	it = platform.listIterator();
	while (it.hasNext()) {
	    if (it.next() == position) break;
	}
	it.previous();
	brickNUmber = position;
    }
    
    void jumpLeft() {
	if(it.previousIndex() < 2) {
	    //System.out.println("Некуда прыгать влево");
	    if (!right) left = true;
	    else movePossible = false;
	    return;
	}
	it.remove();
	it.previous();
	brickNUmber = it.previous();
	left = false;
	right = false;
    }
    
    void jumpRight() {
	if (it.nextIndex() > platform.size() - 3) {
	    //System.out.println("Некуда прыгать вправо");
	    if (!left) right = true;
	    else movePossible = false;
	    return;
	}
	it.remove();
	it.next();
	brickNUmber = it.next();
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
	MarioIterator mario = new MarioIterator(size, size / 2);	
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
