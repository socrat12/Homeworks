package home19.list.list;

public class List {
    static private class Element {
	public int value;
	public Element next;
    }

    private int numbersOElements;
    private Element first;

    public int get(int position) {
	if (position < 0 || position >= numbersOElements) {
	    System.err.println("Wrong index");
	    return -2147483648;
	}

	Element current = first;
	for (int i = 0; i < position; i++) {
	    current = current.next;
	}

	return current.value;
    }

    public boolean set(int value, int index) {
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

    public boolean deleteByValue(int value) {
	if (first.value == value) {
	    first = first.next;
	    numbersOElements--;
	    return true;
	}

	Element previous = first;
	while (previous.next != null) {
	    if (previous.next.value == value) {
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

    public void addFirst(int value) {
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

    public void add(int value) {
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

    public boolean insertToIndex(int value, int index) {
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

    public int[] toArray() {
	int[] array = new int[numbersOElements];
	Element current = first;

	for (int i = 0; i < array.length; i++) {
	    array[i] = current.value;
	    current = current.next;
	}

	return array;
    }

    public String returnString() {
	String stroka = new String();
	Element current = first;

	for (int i = 0; i < numbersOElements; i++) {
	    stroka += current.value;
	    current = current.next;
	}

	return stroka;
    }

    public void sort() {
	int[] array = toArray();

	for (int j = 0; j < array.length - 1; j++) {
	    int min = j;
	    for (int i = j + 1; i < array.length; i++) {
		if (array[i] < array[min]) {
		    min = i;
		}
	    }
	    // если j-ый элемент и так миимальный
	    if (min != j) {
		int change = array[min];
		array[min] = array[j];
		array[j] = change;
	    }
	}

	Element current = first;
	for (int i = 0; i < array.length; i++) {
	    current.value = (array[i]);
	    current = current.next;
	}
    }

    public int indexByValue(int value) {
	if (numbersOElements == 0) {
	    System.err.println("Empty list");
	    return -2147483648;
	}

	int index = 0;

	Element current = first;
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