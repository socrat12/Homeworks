package com.itStep.home05.simple;
//Task 3: Составить программу, которая бы реализовала следующий алгоритм:
//переменной Т присвоить значение true если сочетание день. месяц образует 
//правильную дату, и значение false- иначе(учитывая количество дней в месяце
//и название месяца).
public class month3 {
    public static void main(String[] args) {
	int month = 3, day = 31;

	boolean T = false;

	if (month > 0 && month <= 12 && day > 0 && day <= 31) {
	    if (!(((month % 7 == 2 || month % 7 == 4 || month % 7 == 6)
		    && day == 31) || (day > 28 && month == 2))) {
		T = true;
	    }
	}
	System.out.println(T);
    }

}
