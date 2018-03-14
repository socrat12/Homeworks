package home34.notebook.notepad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import home34.notebook.exceptions.WriteReadException;
import home34.notebook.utils.FileTreatment;

public class ReminderList {

    private final String LINE = "-------------------------------------------------\n";
    private String temp;
    private FileTreatment ftReminders;
    private List<Record> reminders = new LinkedList<Record>();
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat formatForFile = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);
    private String path = "resources/notebook/Reminders.txt";

    public void addRemindersFromFile() throws WriteReadException {
	ftReminders = new FileTreatment(path);
	String temp = ftReminders.fileToString();

	for (int i = 0; i < temp.length(); i++) {
	    if (temp.charAt(i) == '\t') {
		try {
		    i = oneNoteReadFromFile(temp, i + 1);
		} catch (Exception e) {
		    ftReminders.clearFile();
		    throw new WriteReadException(e.getClass() + e.getMessage() + "\nError in Reminders.txt. Cleared all data");
		} 
	    }
	    if (temp.charAt(i + 1) == LINE.charAt(0)) {
		i += LINE.length();
	    }
	}
    }    

    /**
     * @param fromFile Строка полученная из содержимого файла
     * @param i номер текущего символа строки
     * @return Следущий индекс строки
     * @throws WriteReadException
     */
    private int oneNoteReadFromFile(String fromFile, int i) throws ParseException, NumberFormatException  {
	long id = 0;
	String content = "";
	Date dateOfCreate = null;
	Date date = null;

	i = fromFile.indexOf("ID: ", i) + "ID: ".length();
	i = parametrAdd(fromFile, i);
	id = Long.parseLong(temp);

	i = fromFile.indexOf("Date: ", i) + "Date: ".length();
	i = parametrAdd(fromFile, i);
	date = formatForFile.parse(temp);

	i = fromFile.indexOf("Content: ", i) + "Content: ".length();
	i = parametrAdd(fromFile, i);
	content = temp;

	i = fromFile.indexOf("Created: ", i) + "Created: ".length();
	i = parametrAdd(fromFile, i);
	dateOfCreate = formatForFile.parse(temp);

	reminders.add(new Record(id, dateOfCreate, date, content));
	return i;
    }

    /**
     * @param temp
     * @param i
     * @return
     */
    private int parametrAdd(String fromFile, int i) {
	temp = "";
	while (fromFile.charAt(i) != '\r') {
	    temp += fromFile.charAt(i++);
	}
	return i + 2;
    }

    /**
     * Метод отвечает, имеются ли напоминания в записной книжке
     * 
     * @return <b>true</b> если записей нет <br>
     *         <b>false</b> если есть хотя бы одна запись
     */
    public boolean isEmpty() {
	return reminders.isEmpty();
    }

    /**
     * Добавляет напоминание в записную книжку и генерирует ID
     *
     * @param dateOfCreation Дата создания заметки, генерируется автоматически
     * @param plannedDate Дата планирования, вводится пользователем
     * @param reminder Текст напоминания, вводится пользователем
     * @throws WriteReadException
     */
    public void add(Date dateOfCreation, Date plannedDate, String reminder) throws WriteReadException {
	long id;
	boolean existId = false;
	// избегание повторов ID
	do {
	    String temp = "" + new Date().getTime();
	    id = Long.parseLong(temp.substring(temp.length() - 4, temp.length()));
	    for (Record rem : reminders) {
		if (rem.getId() == id) {
		    existId = true;
		}
	    }
	} while (existId);
	for (int i = 0; i < reminders.size(); i++) {
	    if (plannedDate.before(reminders.get(i).getDate())) {
		reminders.add(i, (new Record(id * id, dateOfCreation, plannedDate, reminder)));
		refreshFileContent();
		return;
	    }
	}
	reminders.add(new Record(id * id, dateOfCreation, plannedDate, reminder));
	refreshFileContent();
    }

    /**
     * @param toAdd
     * @throws WriteReadException
     */
    private void addOneRemindeToFile(Record toAdd) throws WriteReadException {
	ftReminders.print(toAdd);
	ftReminders.print(LINE);
    }

    /**
     * Удаляет напоминание из записной книжки по его ID номеру
     * 
     * @param id удаляемого напоминания
     * @return <b>true</b> если удаление успешно произведено <br>
     *         <b>false</b> если элемент с таким ID не найден
     * @throws WriteReadException
     */
    public boolean remove(long id) throws WriteReadException {
	for (Record rem : reminders) {
	    if (rem.getId() == id) {
		reminders.remove(rem);
		refreshFileContent();
		return true;
	    }
	}
	return false;
    }

    private void refreshFileContent() throws WriteReadException {
	ftReminders.clearFile();
	for (Record record : reminders) {
	    addOneRemindeToFile(record);
	}
    }

    public void removeAll() throws WriteReadException {
	reminders.clear();
	ftReminders.clearFile();
    }

    public String showInACertainPeriod(Date startDate, Date endDate) {
	String string = new String();
	boolean exist = false;
	string += LINE;
	string += "Reminders from " + format.format(startDate) + " to " + format.format(endDate) + ":\n";
	string += LINE;
	for (Record rem : reminders) {
	    if (rem.getDate().after(startDate) && rem.getDate().before(endDate)) {
		string += rem;
		string += LINE;
		exist = true;
	    }
	}
	if (!exist)
	    return "No reminders between " + format.format(startDate) + " and " + format.format(endDate);
	return string;
    }
    
    public void sort() throws WriteReadException {
	for (int i = 0; i < reminders.size(); i++) {
	    int min = i;
	    for (int j = i + 1; j < reminders.size(); j++) {
		if (reminders.get(j).getDate().before(reminders.get(min).getDate())) {
		    min = j;
		}
	    }
	    if (min != i) {
		Record temp = reminders.get(i);
		reminders.set(i, reminders.get(min));
		reminders.set(min, temp);
	    }
	}
	refreshFileContent();
    }
    
    @Override
    public String toString() {
	if (reminders.isEmpty()) {
	    return "No reminders yet...";
	}
	
	String string = new String();
	string += LINE;
	for (Record rem : reminders) {
	    string += rem + LINE;
	}
	return string;
    }

    public Date getOldestReminder () {
	Date date = new Date();
	for (Record rem : reminders) {
	    if (rem.getDate().before(date)) date = rem.getDate();
	}
	return date;
    }

    public Date getLatestReminderDate () {
	Date date = new Date();
	for (Record rem : reminders) {
	    if (rem.getDate().after(date)) date = rem.getDate();
	}
	return date;
    }
}
