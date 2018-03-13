package home19.list.list;

import print.Print;

public class ListMain {

    public static void main(String[] args) {
	List my = new List();

	System.out.println(my);

	for (int i = 0; i < 10; i++) {
	    my.add(i);
	}
	System.out.println(my);

	my.addFirst(177);
	System.out.println(my);

	my.insertToIndex(56, 8);
	System.out.println(my);

	System.out.println("Element №5: " + my.get(4));

	my.set(17, 5);
	System.out.println(my);

	my.deleteByIndex(11);
	System.out.println(my);

	my.deleteByValue(6);
	System.out.println(my);

	System.out.println("Index of element with value 56 is " + my.indexByValue(56));
	System.out.println(my);

	System.out.println("Length: " + my.length());

	int[] array = my.toArray();
	Print.printArrayInt(array);

	String stroka = my.returnString();
	System.out.println(stroka);

	my.sort();
	System.out.println(my);

	my.clear();
	System.out.println(my);
    }
}