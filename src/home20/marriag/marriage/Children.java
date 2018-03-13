package home20.marriag.marriage;

public class Children extends Human {
    private Human father;
    private Human mother;

    public Children() {
	setAge((int) (Math.random() * 7 + 1));
    }

    public void setFather(Human father) {
	this.father = father;
    }

    public Human getFather() {
	return father;
    }

    public void setMother(Human mother) {
	this.mother = mother;
    }

    public Human getMother() {
	return mother;
    }

    public String toString() {
	return "My name is " + getName() + ". I'm " + getAge() + " years old. My parents is " + getFather().getName()
		+ " and " + getMother().getName();
    }
}
