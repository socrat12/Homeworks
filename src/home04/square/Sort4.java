package home04.square;

public class Sort4 {
    
    public static void main(String[] args) {
	int a = 3584684, b = 98765, c = -954, d = 0, x = 0;
	while (a > b || a > c || a > d || b > c || b > d || c > d) {
	    if (a > b) {
		x = a;
		a = b;
		b = x;
	    }
	    if (b > c) {
		x = b;
		b = c;
		c = x;
	    }
	    if (c > d) {
		x = c;
		c = d;
		d = x;
	    }
	}
	System.out.println(a + " " + b + " " + c + " " + d);
    }

}
