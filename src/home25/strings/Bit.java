package home25.strings;

public class Bit {

    public static void main(String[] args) {
	int x = 0x0001;

	x = x << 5;
	x = x | 12;

	System.out.println(Integer.toBinaryString(x));
	System.out.println(x);
    }
}
