package home06.dragon;
//Посчитать сумму цифр в целом числе 
public class sum3 {
    public static void main(String[] args) {
	int n = 1234567890, sum = 0;

	while (n > 0) {
	    sum += n % 10;
	    n /= 10;
	}
	System.out.println(sum);
    }
}
