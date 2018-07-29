package com.itStep.home20.marriag.queues;

public class Queues {
    static private class Element {
	public int value;
	public Element next;
    }

    private int numbersOfElements;
    private Element first;
    private Element last;

    //возвращает первый добавленный элемент и удаляет его из очереди
    public int remove() {

	int value = first.value;

	first = first.next;
	numbersOfElements--;

	return value;
    }

    //возвращает первый добавленный элемент 
    public int element() {
	return first.value;
    }

    //добавляет элемент в конец очереди
    public void add(int value) {
	if (numbersOfElements == 0) {
	    first = new Element();
	    first.value = (value);
	    last = first;
	    numbersOfElements++;
	    return;
	}

	last.next = new Element();
	last.next.value = (value);
	last = last.next;
	numbersOfElements++;
    }

    public String toString() {
	Element current = first;
	String string = new String();
	string += "[ ";
	while (current != null) {
	    string += current.value;
	    current = current.next;
	    if (current != null) {
		string += " | ";
	    }
	}
	string += " ]";
	return string;
    }

    public void clear() {
	first = null;
	numbersOfElements = 0;
    }

    public int length() {
	return numbersOfElements;
    }
}
