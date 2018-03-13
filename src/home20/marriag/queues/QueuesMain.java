package home20.marriag.queues;

public class QueuesMain {
    public static void main(String[] args) {
	Queues list = new Queues();

	System.out.println(list);
	list.add(56);

	System.out.println(list);

	for (int i = 0; i < 20; i++) {
	    list.add(i + 1);
	}
	System.out.println(list);
	int g = list.remove();
	System.out.println(g);
	int e = list.element();
	System.out.println(e);
	System.out.println(list);
	System.out.println();

	QueuesArray second = new QueuesArray();
	System.out.println(second);
	second.add(56);

	System.out.println(second);

	for (int i = 0; i < 20; i++) {
	    second.add(i + 1);
	}
	System.out.println(second);
	int r = second.remove();
	System.out.println(r);
	int el = second.element();
	System.out.println(el);
	System.out.println(second);
    }
}
