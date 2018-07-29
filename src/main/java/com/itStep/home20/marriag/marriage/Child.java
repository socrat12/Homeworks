package com.itStep.home20.marriag.marriage;

public class Child extends Human {
    private Human father;
    private Human mother;

    public Child(Human parent1, Human parent2) {
	setAge((int) (Math.random() * 7 + 1));
	setFather((parent1.getSex()) ? parent1 : parent2);
	setMother((!parent2.getSex()) ? parent2 : parent1);
    }

    public void setFather(Human father) {
	this.father = father;
    }

    public Human getFather() {
	return father;
    }

    public void setMother(Human mother) {
	this.mother = mother;
    }

    public Human getMother() {
	return mother;
    }

    public String toString() {
	return "My name is " + getName() + ". I'm " + getAge() + " years old. My parents is " + getFather().getName()
		+ " and " + getMother().getName();
    }
}
