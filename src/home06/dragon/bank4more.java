package home06.dragon;
/*То же самое, только годовую ставку в месячную переводить
  по принципу сложного процента, где Pгод = (1 + Pмес)^12 - 1.*/
public class bank4more {
    public static void main(String[] args) {
	int month = 60, percent = 18;
	double sum = 8000;
	// ежемесячный процент
	double perMonth = Math.pow((percent / 100.0 + 1), 1.0 / 12) - 1;

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