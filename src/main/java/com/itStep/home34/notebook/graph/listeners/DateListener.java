package com.itStep.home34.notebook.graph.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class DateListener implements KeyListener {

    private JTextField field;
    private int limit;
    private boolean clear;

    public DateListener (JTextField field, int limit) {
	this.field = field;
	this.limit = limit;
    }

    @Override
    public void keyTyped (KeyEvent e) {
    }

    @Override
    public void keyPressed (KeyEvent e) {
	if (!Character.isDigit(e.getKeyChar())) {
	    clear = true;
	    return;
	}
	if (Integer.parseInt(field.getText() + e.getKeyChar()) > limit) {
	    clear = true;
	}
    }

    @Override
    public void keyReleased (KeyEvent e) {
	if (clear) field.setText(null);
	clear = false;
    }
}
