package home16.man;

public class Man {

    String name;
    int age, weigth;
    boolean sex;

    static String[] namesMen = { "Simon", "Andrew", "James", "John", "Philip", "Thade", "Barth", "Thomas", "Less",
	    "Matthew", "Simeon", "Judas" };
    static String[] namesWomen = { "Rose", "Dorothy", "Amelia", "Grace", "Susan", "Letitia", "Sophie", "Natali", "Mia",
	    "Olivia", "Lily", "Ava" };
    // массивы для избежания повторов, имя которого не было - false, если
    // попалось - true
    static boolean[] menExist = new boolean[namesMen.length];
    static boolean[] womenExist = new boolean[namesWomen.length];

    public Man() {

	int random = (int) (Math.random() * 2);
	// если закончились все имена
	if (!(check(menExist)) && !(check(womenExist))) {
	    menExist = new boolean[namesMen.length];
	    womenExist = new boolean[namesWomen.length];
	}
	// если по рандому выпадает на "мужского" персонажа, но их имена
	// закончились, подкорректировать. И наоборот.
	else if ((random == 1 && !(check(menExist))) || (random == 0 && !(check(womenExist)))) {
	    random = 1 - random;
	}

	if (random == 1) {
	    // true - мужской
	    sex = true;
	    age = (int) (Math.random() * 40) + 20;
	    weigth = (int) (Math.random() * 30) + 55;

	    random = (int) (Math.random() * namesMen.length);
	    // пока не попадётся новое имя из списка выдавать новое
	    // случайное значние его порядкового номера
	    while (menExist[random]) {
		random = (int) (Math.random() * namesMen.length);
	    }
	    name = namesMen[random];
	    // обозначить имя как использованное
	    menExist[random] = true;

	} else {
	    // sex не изменяется потому что по молчанию он уже false
	    age = (int) (Math.random() * 15) + 20;
	    weigth = (int) (Math.random() * 45) + 40;

	    random = (int) (Math.random() * namesWomen.length);
	    // пока не попадётся новое имя из списка выдавать новое
	    // случайное значние его порядкового номера
	    while (womenExist[(int) (Math.random() * namesWomen.length)]) {
		random = (int) (Math.random() * namesWomen.length);
	    }
	    name = namesWomen[random];
	    // обозначить имя как использованное
	    womenExist[random] = true;
	}
    }

    // возвращает false - если не осталось ни одного имени
    private static boolean check(boolean[] exist) {
	for (int i = 0; i < exist.length; i++) {
	    if (!exist[i]) {
		return true;
	    }
	}
	return false;
    }
}
