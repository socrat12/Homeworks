package com.itStep.home34.notebook.notepad;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import com.itStep.home34.notebook.exceptions.WriteReadException;
import com.itStep.home34.notebook.utils.FileTreatment;

public class NoteList {

    private static final String LINE = "-------------------------------------------------\n";
    private String temp;
    private FileTreatment ftNotes;
    private List<Record> notes = new LinkedList<Record>();
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
    private SimpleDateFormat formatForFile = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);

    public void addNotesFromFile() throws WriteReadException {
	ftNotes = new FileTreatment("resources/notebook/Notes.txt");
	String temp = ftNotes.fileToString();

	for (int i = 0; i < temp.length(); i++) {
	    if (temp.charAt(i) == '\t') {
		try {
		    i = oneNoteReadFromFile(temp, i + 1);
		} catch (Exception e) {
		    System.out.println(e.getClass() + e.getMessage());
		    ftNotes.clearFile();
		    throw new WriteReadException("Error in Notes.txt. Cleared all data");
		} 
	    }
	    if (temp.charAt(i + 1) == LINE.charAt(0)) {
		i += LINE.length();
	    }
	}
    }

    /**
     * @param fromFile
     *            Строка полученная из содержимого файла
     * @param i
     *            номер текущего символа строки
     * @return
     * @throws ParseException 
     * @throws WriteReadException
     */
    private int oneNoteReadFromFile(String fromFile, int i) throws ParseException, NumberFormatException {
	long id = 0;
	String content = "";
	Date dateOfCreate = null;
	
	i = fromFile.indexOf("ID: ", i) + "ID: ".length();
	i = parametrAdd(fromFile, i);
	id = Long.parseLong(temp);

	i = fromFile.indexOf("Content: ", i) + "Content: ".length();
	i = parametrAdd(fromFile, i);
	content = temp;

	i = fromFile.indexOf("Created: ", i) + "Created: ".length();
	i = parametrAdd(fromFile, i);
	dateOfCreate = formatForFile.parse(temp);

	notes.add(new Record(id, dateOfCreate, content));
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
     * Метод отвечает, имеются ли заметки в записной книжке
     * 
     * @return <b>true</b> если записей нет <br>
     *         <b>false</b> если есть хотя бы одна запись
     */
    public boolean isEmpty() {
	return notes.isEmpty();
    }

    /**
     * Добавляет заметку в записную книжку и генерирует ID
     * 
     * @param date
     *            Дата создания заметки, генерируется автоматически
     * @param note
     *            Текст заметки, вводится пользователем
     * @throws WriteReadException
     */
    public void add(Date date, String note) throws WriteReadException {
	long id;
	boolean existId = false;
	// избегание повторов ID
	do {
	    String temp = "" + new Date().getTime();
	    id = Long.parseLong(temp.substring(temp.length() - 4, temp.length()));
	    for (Record note1 : notes) {
		if (note1.getId() == id) {
		    existId = true;
		}
	    }
	} while (existId);
	notes.add(new Record(id * id, date, note));
	Record toAdd = notes.get(notes.size() - 1);
	oneNoteAddToFile(toAdd);
    }

    /**
     * @param toAdd
     * @throws WriteReadException
     */
    private void oneNoteAddToFile(Record toAdd) throws WriteReadException {
	ftNotes.print(toAdd);
	ftNotes.print(LINE);
    }

    public Date getOldestNote() {
	Date date = new Date();
	for (Record note : notes) {
	    if (note.getDateOfCreate().before(date)) date = note.getDateOfCreate();
	}
	return date;
    }
    /**
     * Удаляет заметку из записной книжки по её ID номеру
     * 
     * @param id
     *            удаляемой заметки
     * @return <b>true</b> если удаление успешно произведено <br>
     *         <b>false</b> если элемент с таким ID не найден
     * @throws WriteReadException
     */
    public boolean remove(long id) throws WriteReadException {
	for (Record note : notes) {
	    if (note.getId() == id) {
		notes.remove(note);
		removeFromFile();
		return true;
	    }
	}
	return false;
    }

    private void removeFromFile() throws WriteReadException {
	ftNotes.clearFile();
	for (Record record : notes) {
	    oneNoteAddToFile(record);
	}
    }

    public void removeAll() throws WriteReadException {
	notes.clear();
	ftNotes.clearFile();
    }

    @Override
    public String toString() {
	if (notes.isEmpty()) {
	    return "No notes yet...";
	}

	String string = new String();
	string += LINE;
	for (Record note : notes) {
	    string += (note == null ? "null" : note);
	    string += LINE;
	}
	return string;
    }

    /**
     * @param startDate
     * @param endDate
     * @return String - все записи за указанный промежуток
     */
    public String showInACertainPeriod(Date startDate, Date endDate) {
	String string = new String();
	boolean exist = false;
	string += LINE;
	string += "Notes from " + format.format(startDate) + " to " + format.format(endDate) + ":\n";
	string += LINE;
	for (Record note : notes) {
	    if (note.getDateOfCreate().after(startDate) && note.getDateOfCreate().before(endDate)) {
		string += note;
		string += LINE;
		exist = true;
	    }
	}
	if (!exist)
	    return "No notes between " + format.format(startDate) + " and " + format.format(endDate);
	return string;
    }
}
