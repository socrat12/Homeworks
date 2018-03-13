package home34.notebook.graph.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTextField;

import home34.notebook.graph.NotesMenu;
import home34.notebook.graph.RemindersMenu;

public class StartEndListener implements ActionListener {

    NotesMenu note;
    RemindersMenu rem;

    public StartEndListener (JFrame frame) {
	if ("Notes".equals(frame.getTitle())) {
	    note = (NotesMenu) frame;
	} else {
	    rem = (RemindersMenu) frame;
	}
    }

    @SuppressWarnings ("deprecation")
    @Override
    public void actionPerformed (ActionEvent e) {
	if ("Date start".equals(rem.dateStartEnd.getText())) {
	    if (rem.isEmptyFields()) {
		rem.startDate = rem.ui.getOldestReminderDate();
	    } else {
		rem.startDate = new Date();
		rem.startDate.setDate(rem.date[0].getText().length() != 0 ? Integer.parseInt(rem.date[0].getText()) : 1);
		rem.startDate.setMonth(rem.date[1].getText().length() != 0 ? Integer.parseInt(rem.date[1].getText()) - 1 : 0);
		if (rem.date[2].getText().length() != 0) rem.startDate.setYear(Integer.parseInt(rem.date[2].getText()) - 1900);
		rem.startDate.setHours(rem.date[3].getText().length() != 0 ? Integer.parseInt(rem.date[3].getText()) : 0);
		rem.startDate.setMinutes(rem.date[4].getText().length() != 0 ? Integer.parseInt(rem.date[4].getText()) : 0);
	    }
	    rem.dateStartEnd.setText("Date end");
	    for (JTextField f : rem.date) {
		f.setText("");
	    }
	} else if ("Date end".equals(rem.dateStartEnd.getText())) {
	    Date endDate = new Date();
	    if (rem.isEmptyFields()) {
		endDate = rem.ui.getLatestReminderDate();
	    } else {
		if (rem.date[0].getText().length() != 0) endDate.setDate(Integer.parseInt(rem.date[0].getText()));
		if (rem.date[1].getText().length() != 0) endDate.setMonth(Integer.parseInt(rem.date[1].getText()) - 1);
		if (rem.date[2].getText().length() != 0) endDate.setYear(Integer.parseInt(rem.date[2].getText()) - 1900);
		if (rem.date[3].getText().length() != 0) endDate.setHours(Integer.parseInt(rem.date[3].getText()));
		if (rem.date[4].getText().length() != 0) endDate.setMinutes(Integer.parseInt(rem.date[4].getText()));
	    }

	    if (endDate.before(rem.startDate)) {
		rem.output.setText("End date can't be earlier than start end");
		return;
	    }
	    String t = rem.ui.certainPeriodReminders(rem.startDate, endDate);
	    rem.output.setText(t);
	    rem.cancelAction();
	} else {
	    if (rem.isEmptyFields()) {
		rem.output.setText("You need to input planned date");
	    } else {
		Date plannedDate = new Date();
		if (rem.date[0].getText().length() != 0) plannedDate.setDate(Integer.parseInt(rem.date[0].getText()));
		else {
		    rem.output.setText("You need to input at least day and hour");
		    return;
		}
		if (rem.date[1].getText().length() != 0) plannedDate.setMonth(Integer.parseInt(rem.date[1].getText()) - 1);
		if (rem.date[2].getText().length() != 0) plannedDate.setYear(Integer.parseInt(rem.date[2].getText()) - 1900);
		if (rem.date[3].getText().length() != 0) plannedDate.setHours(Integer.parseInt(rem.date[3].getText()));
		else {
		    rem.output.setText("You need to input at least day and hour");
		    return;
		}
		if (rem.date[4].getText().length() != 0) plannedDate.setMinutes(Integer.parseInt(rem.date[4].getText()));

		if (plannedDate.before(new Date())) {
		    rem.output.setText("Planned date can't be earlier than now");
		    return;
		}

		rem.ui.addReminders(plannedDate, rem.input.getText());
		rem.toTextArea("Reminder \"" + rem.input.getText() + "\" added");
		rem.cancelAction();
	    }
	}
    }
}
