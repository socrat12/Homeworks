package home05.simple;
//Task 5: Найти сумму : г) кубов четных чисел из первых n натуральных чисел.
public class even5 {

    public static void main(String[] args) {
	int n = 20, sum = 0;

	for (int i = 0; i <= n; i += 2) {
	    sum += i * i * i;
	}

	System.out.println(sum);
    }

}