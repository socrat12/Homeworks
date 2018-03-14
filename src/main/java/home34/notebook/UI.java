package home34.notebook;

import java.util.Date;

import home34.notebook.exceptions.WriteReadException;
import home34.notebook.notepad.NoteList;
import home34.notebook.notepad.ReminderList;

public class UI {
    private NoteList notes = new NoteList();
    private ReminderList reminders = new ReminderList();
    
    public UI() {
	try {
	    notes.addNotesFromFile();
	    reminders.addRemindersFromFile();
	} catch (WriteReadException e) {
	    System.err.println(e.getMessage());
	}
    }
    
    public String showAllNotes () {
	return notes.toString();
    }
    
    public String showAllReminders () {
	return reminders.toString();
    }
    
    public String addNotes (String content) {
	try {
	    notes.add(new Date(), content);
	    return "Done";
	} catch (WriteReadException e) {
	    return "Undone";
	}
    }
    
    public String addReminders (Date plannedDate, String content) {
	try {
	    reminders.add(new Date(), plannedDate, content);
	    return "Done";
	} catch (WriteReadException e) {
	    return "Undone";
	}
    }
    
    public String removeNote (long id) {
	try {
	    if (notes.remove(id)) {
	        return "Note" +  " " + id + " deleted";
	    }
	} catch (WriteReadException e) {
	    System.out.println(e.getClass() + " " + e.getMessage());
	}
	return "There is no note with ID " + id;
    }
    
    public String removeReminder (long id) {
	try {
	    if (reminders.remove(id)) {
		return "Reminder " + id + " deleted";
	    }
	} catch (WriteReadException e) {
	    System.out.println(e.getClass() + " " + e.getMessage());
	}
	return "There is no reminder with ID " + id;
    }
    
    public String removeAllNotes () {
	try {
	    notes.removeAll();
	} catch (WriteReadException e) {
	    System.out.println(e.getClass() + " " + e.getMessage());
	}
	return "Removed all notes";
    }
    
    public String removeAllReminders () {
	try {
	    reminders.removeAll();
	} catch (WriteReadException e) {
	    System.out.println(e.getClass() + " " + e.getMessage());
	}
	return "Removed all reminders";
    }
    
    /**
     * @param startDate
     * @param endDate
     * @return String - все записи за указанный промежуток
     */
    public String certainPeriodNotes (Date startDate, Date endDate) {
	return notes.showInACertainPeriod(startDate, endDate);
    }
    
    public String certainPeriodReminders (Date startDate, Date endDate) {
	return reminders.showInACertainPeriod(startDate, endDate);
    }
    
    public Date getOldestNoteDate() {
	return notes.getOldestNote();
    }
    
    public Date getOldestReminderDate() {
	return reminders.getOldestReminder();
    }

    public Date getLatestReminderDate () {
	return reminders.getLatestReminderDate();
    }
}
