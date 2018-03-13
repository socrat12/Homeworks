package home04.square;

public class Sort {
    
    public static void main(String[] args) {
	int a = 100, b = 15, c = 5, x = 0;
	while (a > b || a > c || b > c) {
	    if (b > c) {
		x = b;
		b = c;
		c = x;
	    }
	    if (a > b) {
		x = a;
		a = b;
		b = x;
	    }
	}
	System.out.println(a + " " + b + " " + c);
    }

}
