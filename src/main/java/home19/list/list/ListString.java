package home19.list.list;

public class ListString {
    static private class Element {
	public String value;
	public Element next;
    }

    private int numbersOElements;
    private Element first;

    public String get(int position) {
	if (position < 0 || position >= numbersOElements) {
	    System.err.println("Wrong index");
	    return null;
	}

	Element current = first;
	for (int i = 0; i < position; i++) {
	    current = current.next;
	}

	return current.value;
    }

    public boolean set(String value, int index) {
	if (index < 0 || index >= numbersOElements) {
	    return false;
	}

	Element current = first;
	for (int i = 0; i < index; i++) {
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

	Element previous = first;

	for (int i = 0; i < position - 1; i++) {
	    previous = previous.next;
	}

	Element current = previous.next;
	previous.next = current.next;
	numbersOElements--;
	return true;
    }

    public boolean deleteByValue(String value) {
	if (first.value == value) {
	    first = first.next;
	    numbersOElements--;
	    return true;
	}

	Element previous = first;
	while (previous.next != null) {
	    if (previous.next.value.equals(value)) {
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

    public void addFirst(String value) {
	if (numbersOElements == 0) {
	    first = new Element();
	    first.value = (value);
	    numbersOElements++;
	    return;
	}
	Element current = new Element();

	current.value = (value);
	current.next = first;
	first = current;
	numbersOElements++;
    }

    public void add(String value) {
	if (numbersOElements == 0) {
	    first = new Element();
	    first.value = (value);
	    numbersOElements++;
	    return;
	}

	Element previous = first;
	Element current = new Element();
	while (previous.next != null) {
	    previous = previous.next;
	}
	previous.next = current;
	current.value = (value);
	numbersOElements++;
    }

    public boolean insertToIndex(String value, int index) {
	if (index < 0 || index > numbersOElements) {
	    return false;
	}

	if (numbersOElements == 0) {
	    first = new Element();
	    first.value = (value);
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
	current.value = (value);
	numbersOElements++;
	return true;
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
	numbersOElements = 0;
    }

    public int length() {
	return numbersOElements;
    }

    public String[] toArray() {
	String[] array = new String[numbersOElements];
	Element current = first;

	for (int i = 0; i < array.length; i++) {
	    array[i] = current.value;
	    current = current.next;
	}

	return array;
    }

    public void sort() {
	String[] array = toArray();

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
	    current.value = array[i];
	    current = current.next;
	}
    }

    private boolean compare(String string, String string2) {
	int minLength = Math.min(string.length(), string2.length());
	for (int i = 0; i < minLength; i++) {
	    if (string.charAt(i) > string2.charAt(i)) {
		return true;
	    } else if (string.charAt(i) == string2.charAt(i)) {
		continue;
	    } else {
		return false;
	    }
	}
	return false;
    }

    private void swap(int i, int j, String[] array) {
	String change = array[i];
	array[i] = array[j];
	array[j] = change;
    }

    public int indexByValue(String value) {
	if (numbersOElements == 0) {
	    System.err.println("Empty list");
	    return -2147483648;
	}

	int index = 0;

	Element current = first;
	for (int i = 0; i < numbersOElements; i++) {
	    if (current.value.equals(value)) {
		break;
	    }
	    current = current.next;
	    index++;
	}

	return index;
    }
}
