package home20.marriag.queues;

public class QueuesArray {
    private int[] array = new int[0];

  //возвращает первый добавленный элемент и удаляет его из очереди
    public int remove() {
	int value = array[0];
	int[] temp = new int[array.length - 1];

	for (int i = 0; i < temp.length; i++) {
	    temp[i] = array[i + 1];
	}
	array = temp;

	return value;
    }

    //возвращает первый добавленный элемент 
    public int element() {
	return array[0];
    }

    //добавляет элемент в конец очереди
    public void add(int value) {
	int[] temp = new int[array.length + 1];
	for (int i = 0; i < temp.length - 1; i++) {
	    temp[i] = array[i];
	}
	temp[temp.length - 1] = value;
	array = temp;
    }

    public String toString() {
	String string = new String();

	string += "[ ";
	for (int i = 0; i < array.length; i++) {
	    string += array[i];
	    if (i != array.length - 1) {
		string += " | ";
	    }
	}
	string += " ]";
	return string;
    }

    public void clear() {
	array = new int[0];
    }

    public int length() {
	return array.length;
    }
}