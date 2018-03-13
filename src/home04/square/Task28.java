//28.	Для последовательности An = n sin(n) найдите сумму и произведение:
//            б) n членов, первый из которых имеет номер m.

package home04.square;

public class Task28 {

    public static void main(String[] args) {
	double sum = 0, comp = 1;

	for (double m = 5, n = 20; m < (n + 1); m++) {
	    sum += m * Math.sin(m);
	    comp *= m * Math.sin(m);
	}
	System.out.println("Sum is " + sum);
	System.out.println("Composition is " + comp);
    }

}
