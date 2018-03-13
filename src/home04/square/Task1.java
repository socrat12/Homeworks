//Циклические алгоритмы. Разработать схемы алгоритмов.
//1.	Сколько слагаемых должно быть  в  сумме 
//1+1/2+1/3+1/4+...+1/n, чтобы эта сумма оказалась больше 5 ?

package home04.square;

public class Task1 {
    public static void main(String[] args) {
	int div = 2;
	for (double sum = 1; sum <= 5; div++) {
	    sum += 1.0 / div;
	}
	System.out.println(div-1);
    }

}
