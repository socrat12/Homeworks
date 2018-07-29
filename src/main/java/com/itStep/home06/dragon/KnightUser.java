package com.itStep.home06.dragon;

import com.itStep.getInput.GetInt;

/*Программа моделирует бой между рыцарем и драконом раунд за раундом.
 * В начале каждого раунда дракон выполняет выбранное драконом действие.
 * Если после этого рыцарь остается жив, то рыцарь наносит удар по дракону.
 * В каждом раунде необходимо выводить информацию о том, какое дело совершил 
 * дракон, и какие здоровье и сила удара оказались у обоих дуэлянтов в конце 
 * раунда. Программа заканчивается при смерти одного из участников сообщением
 * о результате. 
Возможные действия дракона:
1 Удар по рыцарю
2 увеличение силы своего у	дара заклинанием навсегда (buff)
3 уменьшение силы удара рыцаря заклинанием навсегда (debuff)
4 полное излечение заклинанием*/
public class KnightUser {
    // исходные данные
    private final static int DRAGONHP = 200;
    private static int dragonA = 3, knightHP = 100, knightA = 90, buff = 1, debuff = 5;
    // полностью отдать управление компьютеру
    private static boolean ai = false;

    public static void main(String[] args) {
	String choise;
	// проверка может ли дракон в принципе выиграть
	possibility();
	// dragonFHP остаётся как константа, все манипуляции с dragonHP
	int dragonHP = DRAGONHP, rounds = 1;

	// цикл вплоть до поражения рыцаря - дракон проиграть не может, так как
	// possibility не завершил программу
	while (knightHP > 0) {
	    // ход дракона dragon(dragonHP)
	    switch (user(dragonHP)) {
	    case 1: {
		knightHP -= dragonA;
		choise = "Attack";
		break;
	    }
	    case 2: {
		dragonA += buff;
		choise = "Buff";
		break;
	    }
	    case 3: {
		knightA -= debuff;
		choise = "Debuff";
		break;
	    }
	    default: {
		dragonHP = DRAGONHP;
		choise = "Cure";
	    }
	    }

	    if (knightHP > 0) {
		// если рыцарь ещё жив - его ход
		dragonHP = knight(dragonHP);
	    }
	    // результаты раунда
	    print(rounds, choise, dragonHP);

	    rounds++;
	}
	System.out.println("\t\t\t\t\t     Dragon win!");
    }

    private static int user(int dragonHP) {
	// если пользоватль отдал управление компьютеру
	if (ai == true) {
	    return dragon(dragonHP);
	}
	System.out.println("Possible options:\n1. Attack the Knight.\n2. Increase Dragon attack power.");
	System.out.println("3. Decrease Knight attak power.\n4. Complete cure of the Dragon.");
	System.out.println("5. Allow the Dragon to choose itself one time\n6. Give the dragon full freedom :-).");
	System.out.print("Your move: ");
	// Выбор пользователя
	int userchoise;
	// защита от неверного ввода
	do {
	    System.out.print("Your move: ");
	    userchoise = GetInt.get();
	} while (userchoise < 1 || userchoise > 6);
	if (userchoise == 5) {
	    possibility();
	    return dragon(dragonHP);
	} else if (userchoise == 6) {
	    possibility();
	    ai = true;
	    return dragon(dragonHP);
	}
	return userchoise;
    }

    private static void print(int rounds, String choise, int dragonHP) {
	System.out.println("\t\t\t\t\t      Round " + rounds);
	System.out.println("Dragon Choice:\tDragon health points:\t"
		+ "Dragon attak power:\tKnight health points:\tKnight attak power:");
	System.out.println("    " + choise + "\t\t" + dragonHP + "\t\t         " + dragonA + "\t\t\t" + knightHP
		+ "\t\t\t" + knightA);
	System.out.println();
    }

    private static void possibility() {
	// даже если рыцарю сделать дебафф, он своим ударом всё равно с одного
	// или двух ударов убивает дракона, при том что атака дракона не
	// позволяет ему убить рыцаря до его хода даже с баффом
	if ((knightA - debuff > DRAGONHP / 2.0) && (dragonA + buff < knightHP)) {
	    System.out.println("Dragon doesn't have a chance...");
	    System.exit(0);
	}
    }

    private static int knight(int dragonHP) {
	// рыцарь наносит ответный удар
	return dragonHP - knightA;
    }

    private static int dragon(int dragonHP) {
	// проверка, не нужно ли уменьшить силу рыцаря, чтобы уберечься
	if (debuff(dragonHP)) {
	    return 3;
	}
	// лечение, если нужно
	else if ((dragonHP - knightA <= 0) && !(knightHP <= dragonA)) {
	    return 4;
	}
	// увеличение силы
	else if (buff()) {
	    return 2;
	}
	// атака
	else
	    return 1;
    }

    private static boolean debuff(int dragonHP) {
	// если значние debyff равно 0, нет смысл его применять
	if (debuff == 0) {
	    return false;
	}
	// если не удасться убить дракона до его хода и его атака больше
	// или равна половине изначальной жизни дракона
	if ((knightA >= DRAGONHP / 2.0) && !(knightHP <= dragonA + buff)) {
	    return true;
	}
	// спастсь от смерти дебаффом, чтобы не получить бесконечный
	// цикл "лечение-удар рыцаря"
	if (knightA >= dragonHP && knightA - debuff < dragonHP) {
	    return true;
	}
	// примерное количество ходов, с учётом лечения без применения дебафа
	float min = ((float) knightHP / dragonA)
		+ (((float) knightA / (dragonHP - knightA)) * ((float) knightHP / dragonA)), newMin;
	for (int i = 1; i <= knightA / debuff; i++) {
	    // примерное количество ходов, с учётом лечения с применением дебафа
	    newMin = ((float) knightHP / dragonA)
		    + (((float) (knightA - i * debuff) / (dragonHP - knightA)) * ((float) knightHP / dragonA));
	    if ((newMin + i < min) && buff == 0) {
		return true;
	    }
	}
	return false;
    }

    private static boolean buff() {
	// однозначно применить бафф, если его применение сразу убьёт дракона
	// и если атака дракона УЖЕ не убьёт дракона
	if ((knightHP <= dragonA + buff) && !(knightHP <= dragonA)) {
	    return true;
	}
	// количество ходов без учёта лечения и применения баффа до убийства
	// рыцаря
	float min = (float) knightHP / dragonA;
	for (int i = 1; i <= knightHP / 3; i++) {
	    // то же, с учётом баффа
	    if ((((float) knightHP / (dragonA + i * buff)) + i) < min) {
		return true;
	    }
	}
	return false;
    }
}
