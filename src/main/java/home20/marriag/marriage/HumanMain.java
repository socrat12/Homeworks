package home20.marriag.marriage;

public class HumanMain {
    public final static String newLine = "-----------------------\n";
    
    public static void main(String[] args) {
	Human[] people = new Human[10];
	boolean diffrentSex = false;
	for (int i = 0; i < people.length; i++) {
	    people[i] = new Human();
	    if (i != 0 && people[i].getSex() != people[i - 1].getSex()) {
		diffrentSex = true;
	    }

	    if (i == people.length - 1 && !diffrentSex) {
		i--;
	    }
	}
	print(people);

	for (int i = 0; i < people.length; i++) {
	    int random = (int) (Math.random() * people.length);
	    if (people[i].getSex() == people[random].getSex()) {
		i--;
		continue;
	    }
	    people[i].setWhoHeLikes(people[random]);
	}
	print(people);

	ListHuman familys = new ListHuman();

	for (int i = 0; i < people.length - 1; i++) {
	    for (int j = i + 1; j < people.length; j++) {
		if (people[i] == people[j].getWhoHeLikes() && people[j] == people[i].getWhoHeLikes()) {
		    familys.add(people[i]);
		    familys.add(people[j]);
		    Child child = new Child(people[i], people[j]);
		    familys.add(child);
		}
	    }
	}
	System.out.println(familys);
    }

    private static void print(Human[] people) {
	System.out.print(newLine);
	for (int i = 0; i < people.length; i++) {
	    System.out.println(people[i]);
	}
    }
}
