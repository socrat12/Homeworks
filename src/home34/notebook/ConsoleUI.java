package home34.notebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import home34.notebook.exceptions.*;
import home34.notebook.notepad.NoteList;
import home34.notebook.notepad.ReminderList;
import home34.notebook.utils.GetChoise;

public class ConsoleUI {

    private NoteList notes = new NoteList();
    private ReminderList reminders = new ReminderList();
    private SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
    private SimpleDateFormat format2 = new SimpleDateFormat("dd MM yyyy kk:mm");
    private boolean exit = false;
    private final String LINE = "=================================================";

    public ConsoleUI() {
	try {
	    notes.addNotesFromFile();
	} catch (WriteReadException e) {
	    System.err.println(e.getMessage());
	}
	try {
	    reminders.addRemindersFromFile();
	} catch (WriteReadException e) {
	    System.err.println(e.getMessage());
	}
    }

    public boolean isExit() {
	return exit;
    }

    public void start() {
	while (!exit) {
	    System.out.println();
	    System.out.println(LINE);
	    System.out.println("\t\tMain Menu");
	    System.out.println(LINE);
	    System.out.println("1. Notes\n2. Reminders\n3. Exit");
	    System.out.println(LINE);
	    switch (GetChoise.getChoise()) {
	    case 1: {
		menu2("Note");
		break;
	    }
	    case 2: {
		menu2("Reminder");
		break;
	    }
	    case 3: {
		exit = true;
		break;
	    }
	    default:
		break;
	    }
	}
    }

    /**
     * Меню напоминаний или заметок, в зависимости от выбора
     * 
     * @param noteOrReminder
     *            Строка "Заметки" или "Напоминания"
     */
    private void menu2(String noteOrReminder) {
	while (true) {
	    System.out.println();
	    System.out.println(LINE);
	    System.out.print("\t\t" + noteOrReminder);
	    System.out.println("s menu");
	    System.out.println(LINE);
	    System.out.print("1. Show all " + noteOrReminder + "s\n2. Add\n3. Remove");
	    System.out.print("\n4. Show " + noteOrReminder
		    + ("Note".equals(noteOrReminder) ? "s created " : "s planned ") + "in a certain period");
	    System.out.println("\n5. Back to Main menu");
	    System.out.println(LINE);
	    switch (GetChoise.getChoise()) {
	    case 1: {
		// вывод всех заметок/напоминаний
		System.out.println(("Note".equals(noteOrReminder) ? notes : reminders));
		break;
	    }
	    case 2: {
		// добавление заметки/напоминнания
		add(noteOrReminder);
		break;
	    }
	    case 3: {
		remove(noteOrReminder);
		break;
	    }
	    case 4: {
		certainPeriod(noteOrReminder);
		break;
	    }
	    case 5: {
		return;
	    }
	    default:
		break;
	    }
	}
    }

    private void certainPeriod(String noteOrReminder) {
	Date startDate, endDate;
	while (true) {
	    try {
		System.out.println("Please input start date");
		String input = GetChoise.getString();
		if (input.length() == 0) {
		    System.out.println("Showing all " + noteOrReminder + "s");
		    System.out.println(("Note".equals(noteOrReminder) ? notes : reminders));
		    return;
		} else {
		    startDate = format.parse(input);
		    System.out.println("Please input end date");
		    endDate = format.parse(GetChoise.getString());
		    break;
		}
	    } catch (ParseException e) {
		System.out.println("Wrong input (DD MM YYYY)");
	    }
	}

	System.out.println(("Note".equals(noteOrReminder) ? notes.showInACertainPeriod(startDate, endDate)
		: reminders.showInACertainPeriod(startDate, endDate)));
    }

    private void remove(String noteOrReminder) {
	System.out.println("Please, input ID (-1 to remove all of them)");
	long choise = GetChoise.getLong();
	if (choise == -1) {
	    try {
		if ("Note".equals(noteOrReminder))
		    notes.removeAll();
		else
		    reminders.removeAll();
	    } catch (WriteReadException e) {
		System.out.println(e.getClass() + " " + e.getMessage());
	    }
	    System.out.println("Removed all " + noteOrReminder + "s");
	    return;
	}
	long id = choise;
	try {
	    if (("Note".equals(noteOrReminder) ? notes.remove(id) : reminders.remove(id))) {
		System.out.println(noteOrReminder + " " + id + " deleted");
	    } else {
		System.out.println("There is no " + noteOrReminder + " with ID " + id);
	    }
	} catch (WriteReadException e) {
	    System.out.println(e.getClass() + " " + e.getMessage());
	}
    }

    @SuppressWarnings("deprecation")
    private void add(String noteOrReminder) {
	System.out.println("Please, input content");
	String content = GetChoise.getString();

	if ("Reminder".equals(noteOrReminder)) {
	    String date;
	    System.out.println("Please, input date (DD MM YYYY or DD MM YYYY hh:mm) ");
	    Date plannedDate = new Date();
	    boolean wrong = true;
	    while (wrong) {
		try {
		    date = GetChoise.getString();
		    // напоминание для ленивых
		    if (date.isEmpty()) {
			plannedDate = new Date();
			plannedDate.setDate(plannedDate.getDate() + 1);
			System.out.println("Default date: tomorrow 10am");
			wrong = false;
			break;
		    }
		    if (date.contains(":")) {
			plannedDate = format2.parse(date);
		    } else {
			plannedDate = format.parse(date);
			plannedDate.setHours(10);
		    }
		    if (plannedDate.before(new Date())) {
			throw new WrongDateException();
		    }
		    wrong = false;
		} catch (ParseException e) {
		    System.err.println("Wrong input (DD MM YYYY or DD MM YYYY hh:mm)");
		} catch (WrongDateException e) {
		    System.err.println("The planned date should be after the current");
		    System.out.println("Please, input again (DD MM YYYY or DD MM YYYY hh:mm)");
		}
	    }
	    try {
		reminders.add(new Date(), plannedDate, content);
	    } catch (WriteReadException e) {
		System.err.println(e.getClass() + " " + e.getMessage());
	    }
	} else {
	    try {
		notes.add(new Date(), content);
	    } catch (WriteReadException e) {
		System.err.println(e.getClass() + " " + e.getMessage());
	    }
	}
	System.out.println(noteOrReminder + " add");
    }
}
