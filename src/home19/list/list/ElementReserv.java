package home19.list.list;

public class ElementReserv {
    private int value;
    private ElementReserv next;

    public void setValue(int value) {
	this.value = value;
    }

    public int getValue() {
	return value;
    }

    public void setNext(ElementReserv ref) {
	next = ref;
    }

    public ElementReserv getNext() {
	return next;
    }
}