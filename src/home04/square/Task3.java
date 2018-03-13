//3. В 1626г. индейцы  продали  остров за 20 долларов. 
//Если бы эти  деньги были помещены в банк под 4% годовых
//(процент капитализированный), то какова была бы стоимость капитала сегодня?
package home04.square;

public class Task3 {
    public static void main(String[] args) {
	double sum = 20, percent = 1.04;

	for (int i = 1626; i < 2018; i++) {
	    sum *= percent;
	}
	System.out.println(sum / 1000000 + " millions dollars");
    }

}
