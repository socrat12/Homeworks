package com.itStep.home05.simple;
//9. Вычислить максимально возможное значение силы логова драконов
public class dragon9 {

    public static void main(String[] args) {
	int sum = 22;
	int ostatok = sum % 3;
	double comp;

	if (ostatok <= 1) {
	    ostatok += 3;
	    sum -= ostatok;
	}
	comp = Math.pow(3, sum / 3) * ostatok;
	System.out.println((int) comp);
    }

}
