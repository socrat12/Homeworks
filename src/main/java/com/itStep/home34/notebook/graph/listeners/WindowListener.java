package com.itStep.home34.notebook.graph.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class WindowListener extends MouseAdapter implements MouseListener, MouseMotionListener{

    private JFrame note;
    private int prevX;
    private int prevY;
    
    public WindowListener (JFrame note) {
	this.note = note;
    }

    @Override
    public void mousePressed (MouseEvent e) {
	prevX = e.getX();
	prevY = e.getY();
    }

    @Override
    public void mouseDragged (MouseEvent e) {	
	if (e.getModifiers() != MouseEvent.BUTTON1_MASK) return;
	int curX = e.getX();
	int curY = e.getY();
	int x = note.getLocation().x + (curX - prevX);
	int y = note.getLocation().y + (curY - prevY);
	note.setLocation(x,y);
    }
}
