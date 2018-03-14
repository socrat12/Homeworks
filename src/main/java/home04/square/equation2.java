package home04.square;

//Решить квадратное уравнение методом полного перебора всех чисел от -100000 до +100000 с шагом 0.1. 
public class equation2 {

    public static void main(String[] args) {
	double a = 2, b = 4, c = 2, z, z1, z2;

	int x = 1;

	for (float i = -100; i <= 100; i += 0.01) {
	    z = a * i * i + b * i + c;
	    z1 = a * (i + 0.01) * (i + 0.01) + b * (i + 0.01) + c;
	    z2 = a * (i + 0.02) * (i + 0.02) + b * (i + 0.02) + c;
	    // System.out.print(i + ":\t");
	    // System.out.println(a * i * i + b * i + c);
	    if ((z < 0) && (z1 >= 0)) {
		System.out.println("x" + x + " is " + i);
		x += 1;
	    }
	    if ((z > 0) && (z1 <= 0)) {
		System.out.println("x" + x + " is " + i);
		x += 1;
	    }
	    if (x == 1) {
		if ((z < z1) && (z1 > z2)) {
		    System.out.println("x" + x + " is " + (i + 0.01));
		}
		if ((z > z1) && (z1 < z2)) {
		    System.out.println("x" + x + " is " + (i + 0.01));
		}
	    }
	}
	System.out.println("end");
    }

}
