package home32.Set;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

	Comparator<Integer> comp = new Comparator<Integer>() {

	    @Override
	    public int compare(Integer o1, Integer o2) {
		if (o1 < o2) return -1;
		else if (o1 == o2) return 0;
		else return 1;

		// return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
	    }
	};

	TreeShagoSet<Integer> my = new TreeShagoSet<Integer>(comp);

	my.add(10);
	my.add(9);
	my.add(8);
	my.add(11);
	my.add(20);
	my.add(3);
	my.add(1);
	my.add(4);

	System.out.println(my);
	System.out.println(my.contains(11));
    }
}
