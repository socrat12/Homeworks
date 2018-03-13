package home19.list.listGenerik;

import print.Print;

public class ListMain {

    public static void main(String[] args) {
	List<Integer> my = new List<Integer>();

	my.print();

	for (int i = 0; i < 10; i++) {
	    my.add(i);
	}
	my.print();

	my.addFirst(177);
	my.print();

	my.addToPosition(56, 5);
	my.print();

	System.out.println("Element №5: " + my.get(4));

	my.set(17, 5);
	my.print();

	my.deleteByIndex(11);
	my.print();

	my.deleteByValue(6);
	my.print();

	System.out.println("Index of element with value 56 is " + my.indexByValue(56));
	my.print();

	System.out.println("Length: " + my.length());

	String[] arrayString = my.toArray();
	int[] array = new int[arrayString.length];
	for (int i = 0; i < array.length; i++) {
	    array[i] = Integer.parseInt(arrayString[i]);
	}
	Print.printArrayInt(array);

	String stroka = my.toString();
	System.out.println(stroka);

	my.sort();
	my.print();

	my.clear();
	my.print();
    }
}