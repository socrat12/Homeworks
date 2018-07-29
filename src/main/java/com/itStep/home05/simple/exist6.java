package com.itStep.home05.simple;
//Task 6: Сумма квадратов цифр некоторого двузначного числа на 1 
//больше утроенного произведения этих цифр. После деления этого 
//двузначного числа на сумму его цифр в частном получается 7 и в  остатке  6.
//Составить алгоритм поиска этого числа, если оно существует.
public class exist6 {

    public static void main(String[] args) {
	for (int i = 10; i < 100; i++) {
	    int dec = i / 10, unit = i % 10;
	    int sum = (dec) * (dec) + (unit) * (unit), comp = dec * unit * 3;
	    int division1 = i / (dec + unit), division2 = i % (dec + unit);

	    if ((sum - comp == 1) && division1 == 7 && division2 == 6) {
		System.out.println("Exist: " + i);
	    }
	}
    }

}
