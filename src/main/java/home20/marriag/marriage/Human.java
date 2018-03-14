package home20.marriag.marriage;

public class Human {
    private boolean sex;
    private String name;
    private Human sympathy;
    private int age;
    private static int count = 0;

    private final static String[] namesMen = { "Simon", "Andrew", "James", "John", "Philip", "Thade", "Barth", "Thomas",
	    "Less", "Matthew", "Simeon", "Judas" };
    private final static String[] namesWomen = { "Rose", "Dorothy", "Amelia", "Grace", "Susan", "Letitia", "Sophie",
	    "Natali", "Mia", "Olivia", "Lily", "Ava" };

    public Human() {
	sex = (Math.random() > 0.5) ? true : false;
	name = (sex) ? namesMen[count++ % 12] : namesWomen[count++ % 12];
	sympathy = null;
	age = (int) (Math.random() * 20 + 20);
    }

    public void setAge(int age) {
	this.age = age;
    }

    public int getAge() {
	return age;
    }

    public String getName() {
	return name;
    }

    public boolean getSex() {
	return sex;
    }

    public Human getWhoHeLikes() {
	return sympathy;
    }

    public void setWhoHeLikes(Human whoHeLikes) {
	sympathy = whoHeLikes;
    }

    public String toString() {
	if (sympathy == null) {
	    return "I'm " + name;
	} else {
	    return "I'm " + name + ".  \tI love " + sympathy.name;
	}
    }
}
