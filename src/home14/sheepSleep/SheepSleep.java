//Задача про овцу
package home14.sheepSleep;

public class SheepSleep {
    public static void main(String[] args) {
	boolean[] numbers = new boolean[10];
	for (int i = 0; i < 10; i++) {
	    numbers[i] = false;
	}
	int count = 0;
	for (int i = 1, sum; i < 1000; i++) {
	    sum = i * 23;
	    System.out.println(sum);
	    int number = sum;
	    while (number > 0) {
		if (!numbers[number % 10]) {
		    numbers[number % 10] = true;
		    count++;
		    if (count == 10) {
			System.out.println("Last sum is " + sum);
			System.out.println("Last number is " + number % 10);
			for (int m = 0; m < 10; m++) {
			    System.out.print(m + ": " + numbers[m] + ". ");
			}
			System.exit(0);
		    }
		}
		number /= 10;
	    }
	}
    }
}
