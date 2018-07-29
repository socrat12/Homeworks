package com.itStep.home34.notebook.notepad;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Record {
    private long id;
    private Date plannedDate;
    private String content;
    private Date dateOfCreate;

    public long getId() {
	return id;
    }

    public Date getDateOfCreate() {
	return dateOfCreate;
    }

    public String getContent() {
	return content;
    }

    public Date getDate() {
	return plannedDate;
    }

    /**
     * @param id
     * @param dateOfCreate
     * @param content
     */
    public Record(long id, Date dateOfCreate, String content) {
	this.id = id;
	this.dateOfCreate = dateOfCreate;
	this.content = content;
    }

    /**
     * @param id
     * @param dateOfCreate
     * @param plannedDate
     * @param content
     */
    public Record(long id, Date dateOfCreate, Date plannedDate, String content) {
	this.id = id;
	this.dateOfCreate = dateOfCreate;
	this.plannedDate = plannedDate;
	this.content = content;
    }

    @Override
    public String toString() {
	SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);
	return "\tID: " + id + "\n" + (plannedDate != null ? "Date: " + format.format(plannedDate) + "\n" : "")
		+ "Content: " + content	+ "\n" + "Created: " + format.format(dateOfCreate) + "\n";
    }
}
