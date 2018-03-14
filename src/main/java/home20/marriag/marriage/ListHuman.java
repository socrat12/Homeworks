package home20.marriag.marriage;

public class ListHuman {
    static private class Element {
	public Human person;
	public Element next;
    }

    private int numbersOElements;
    private Element first;

    public Human get(int position) {
	if (position < 0 || position >= numbersOElements) {
	    System.err.println("Wrong index");
	    return null;
	}

	Element current = first;
	for (int i = 0; i < position; i++) {
	    current = current.next;
	}

	return current.person;
    }

    public boolean set(Human value, int index) {
	if (index < 0 || index >= numbersOElements) {
	    return false;
	}

	Element current = first;
	for (int i = 0; i < index; i++) {
	    current = current.next;
	}

	current.person = value;
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

	Element previous = first;

	for (int i = 0; i < position - 1; i++) {
	    previous = previous.next;
	}

	Element current = previous.next;
	previous.next = current.next;
	numbersOElements--;
	return true;
    }

    public boolean deleteByValue(Human value) {
	if (first.person == value) {
	    first = first.next;
	    numbersOElements--;
	    return true;
	}

	Element previous = first;
	while (previous.next != null) {
	    if (previous.next.person.equals(value)) {
		break;
	    }
	    previous = previous.next;
	}

	if (previous.next != null) {
	    Element current = previous.next;
	    previous.next = current.next;
	    numbersOElements--;
	    return true;
	}

	return false;
    }

    public void addFirst(Human value) {
	if (numbersOElements == 0) {
	    first = new Element();
	    first.person = (value);
	    numbersOElements++;
	    return;
	}
	Element current = new Element();

	current.person = (value);
	current.next = first;
	first = current;
	numbersOElements++;
    }

    public void add(Human value) {
	if (numbersOElements == 0) {
	    first = new Element();
	    first.person = (value);
	    numbersOElements++;
	    return;
	}

	Element previous = first;
	Element current = new Element();
	while (previous.next != null) {
	    previous = previous.next;
	}
	previous.next = current;
	current.person = (value);
	numbersOElements++;
    }

    public boolean insertToIndex(Human value, int index) {
	if (index < 0 || index > numbersOElements) {
	    return false;
	}

	if (numbersOElements == 0) {
	    first = new Element();
	    first.person = (value);
	    numbersOElements++;
	    return false;
	}

	Element previous = first;
	Element current = new Element();
	for (int i = 1; i < index - 1; i++) {
	    previous = previous.next;
	}

	current.next = previous.next;
	previous.next = current;
	current.person = (value);
	numbersOElements++;
	return true;
    }

    public String toString() {
	Element current = first;
	String string = new String();
	string += HumanMain.newLine;

	while (current != null) {
	    string += current.person + "\n";
	    current = current.next;
	}

	if (string.equals(HumanMain.newLine)) {
	    return string + "We doesn't have a pairs";
	}
	return string;
    }

    public void clear() {
	first = null;
	numbersOElements = 0;
    }

    public int length() {
	return numbersOElements;
    }

    public Human[] toArray() {
	Human[] array = new Human[numbersOElements];
	Element current = first;

	for (int i = 0; i < array.length; i++) {
	    array[i] = current.person;
	    current = current.next;
	}

	return array;
    }

    public void sort() {
	Human[] array = toArray();

	boolean check = false;
	do {
	    check = false;
	    for (int i = 0; i < array.length - 1; i++) {
		if (compare(array[i], array[i + 1])) {
		    swap(i, i + 1, array);
		    check = true;
		}
	    }
	} while (check);

	Element current = first;
	for (int i = 0; i < array.length; i++) {
	    current.person = array[i];
	    current = current.next;
	}
    }

    private boolean compare(Human human, Human human2) {
	int minLength = Math.min(human.getName().length(), human2.getName().length());
	for (int i = 0; i < minLength; i++) {
	    if (human.getName().charAt(i) > human2.getName().charAt(i)) {
		return true;
	    } else if (human.getName().charAt(i) == human2.getName().charAt(i)) {
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }

    private void swap(int i, int j, Human[] array) {
	Human change = array[i];
	array[i] = array[j];
	array[j] = change;
    }

    public int indexByValue(Human value) {
	if (numbersOElements == 0) {
	    System.err.println("Empty list");
	    return -2147483648;
	}

	int index = 0;

	Element current = first;
	for (int i = 0; i < numbersOElements; i++) {
	    if (current.person.equals(value)) {
		break;
	    }
	    current = current.next;
	    index++;
	}

	return index;
    }
}
