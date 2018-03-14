package home06.dragon;
/*Программа должна выводить N строчек (по строчке на каждый месяц)
с информацией о номере месяца, сумме платежа (всегда одинаковая),
сколько рублей в этом платеже  ушло на оплату  процентов, сколько 
рублей ушло на погашение основного долга, сколько всего осталось
долга после этого платежа.*/
public class bank4 {
    public static void main(String[] args) {
	int month = 60, percent = 18;
	double sum = 8000;
	// ежемесячный процент
	double perMonth = percent / 100.0 / 12.0;

	// коэффициент аннуитета
	double k = Math.pow((1 + perMonth), month);
	double koef = (perMonth * k) / (k - 1);

	// сумма в месяц
	double totalMonth = sum * koef;

	// текущие проценты = отсаток суммы долга * процент в месяц
	double curPerc;

	for (int i = 0; i < month; i++) {
	    curPerc = sum * perMonth;
	    sum = (sum - (totalMonth - curPerc));
	    System.out.printf("%d\t%.2f\t%.2f\t%.2f\t%.2f%n", i + 1, totalMonth, curPerc, totalMonth - curPerc, sum);
	}
    }

}
