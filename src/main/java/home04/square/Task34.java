package home04.square;

//34.	По номеру месяца напечатать пору года.
public class Task34 {

    public static void main(String[] args) {
	int month = 4;

	if (month > 2 && month < 6) {
	    System.out.println("Spring");
	} else if (month > 5 && month < 9) {
	    System.out.println("Summer");
	} else if (month > 8 && month < 12) {
	    System.out.println("Autumn");
	} else {
	    System.out.println("Winter");
	}
    }

}
