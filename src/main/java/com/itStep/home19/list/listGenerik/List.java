package com.itStep.home19.list.listGenerik;

public class List<N> {
    static private class Element<N> {
	public N value;
	public Element<N> next;
    }

    private int numbersOElements;
    private Element<N> first;

    public List() {
	numbersOElements = 0;
	first = null;
    }

    public N get(int position) {
	if (position < 0 || position >= numbersOElements) {
	    System.err.println("Wrong index");
	    return null;
	}

	Element<N> current = first;
	for (int i = 0; i < position; i++) {
	    current = current.next;
	}

	return current.value;
    }

    public boolean set(N value, int position) {
	if (position < 0 || position >= numbersOElements) {
	    return false;
	}

	if (first == null) {
	    first = new Element<N>();
	}

	Element<N> current = first;
	for (int i = 0; i < position; i++) {
	    current = current.next;
	}

	current.value = value;
	return true;
    }

    public boolean deleteByIndex(int position) {
	if (position < 0 || position >= numbersOElements) {
	    return false;
	}

	if (position == 0) {
	    first = first.next;
	    numbersOElements--;
	    return true;
	}

	Element<N> previous = first;

	for (int i = 0; i < position - 1; i++) {
	    previous = previous.next;
	}

	Element<N> current = previous.next;
	previous.next = current.next;
	numbersOElements--;
	return true;
    }

    public boolean deleteByValue(N value) {
	if (first.value == value) {
	    first = first.next;
	    numbersOElements--;
	    return true;
	}

	Element<N> previous = first;
	while (previous.next != null) {
	    if (previous.next.value == value) {
		break;
	    }
	    previous = previous.next;
	}

	if (previous.next != null) {
	    Element<N> current = previous.next;
	    previous.next = current.next;
	    numbersOElements--;
	    return true;
	}

	return false;
    }

    public void addFirst(N value) {
	if (numbersOElements == 0) {
	    first = new Element<N>();
	    first.value = (value);
	    numbersOElements++;
	    return;
	}
	Element<N> current = new Element<N>();

	current.value = (value);
	current.next = first;
	first = current;
	numbersOElements++;
    }

    public void add(N value) {
	if (numbersOElements == 0) {
	    first = new Element<N>();
	    first.value = (value);
	    numbersOElements++;
	    return;
	}

	Element<N> previous = first;
	Element<N> current = new Element<N>();
	while (previous.next != null) {
	    previous = previous.next;
	}
	previous.next = current;
	current.value = (value);
	numbersOElements++;
    }

    public boolean addToPosition(N value, int position) {
	if (position < 0 || position > numbersOElements) {
	    return false;
	}

	if (numbersOElements == 0) {
	    first = new Element<N>();
	    first.value = (value);
	    numbersOElements++;
	    return false;
	}

	Element<N> previous = first;
	Element<N> current = new Element<N>();
	for (int i = 1; i < position - 1; i++) {
	    previous = previous.next;
	}
	current.next = previous.next;
	previous.next = current;
	current.value = (value);
	numbersOElements++;
	return true;
    }

    public void print() {
	Element<N> current = first;
	int counter = 0;
	System.out.print("[ ");
	while (current != null) {
	    System.out.print(current.value);
	    current = current.next;
	    if (current != null) {
		System.out.print(" | ");
	    }
	    counter++;
	    if (counter % 19 == 0) {
		System.out.println();
	    }
	}
	System.out.print(" ]\n");
    }

    public void clear() {
	first = null;
	numbersOElements = 0;
    }

    public int length() {
	return numbersOElements;
    }

    public String[] toArray() {
	String[] array = new String[numbersOElements];
	Element<N> current = first;

	for (int i = 0; i < array.length; i++) {
	    array[i] = "" + current.value;
	    current = current.next;
	}

	return array;
    }

    public String toString() {
	String stroka = new String();
	Element<N> current = first;

	for (int i = 0; i < numbersOElements; i++) {
	    stroka += current.value + " ";
	    current = current.next;
	}

	return stroka;
    }

    @SuppressWarnings("unchecked")
    public void sort() {
	String[] array = toArray();

	for (int j = 0; j < array.length - 1; j++) {
	    int min = j;
	    for (int i = j + 1; i < array.length; i++) {
		if (array[i].compareTo(array[min]) < 0) {
		    min = i;
		}
	    }
	    // если j-ый элемент и так миимальный
	    if (min != j) {
		String change = array[min];
		array[min] = array[j];
		array[j] = change;
	    }
	}

	Element<N> current = first;
	for (int i = 0; i < array.length; i++) {
	    current.value = (N) (array[i]);
	    current = current.next;
	}
    }

    public int indexByValue(N value) {
	if (numbersOElements == 0) {
	    System.err.println("Empty list");
	    return -1;
	}

	int index = 0;

	Element<N> current = first;
	for (int i = 0; i < numbersOElements; i++) {
	    if (current.value == value) {
		break;
	    }
	    current = current.next;
	    index++;
	}

	return index;
    }
}
