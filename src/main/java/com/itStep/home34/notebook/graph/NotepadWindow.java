package com.itStep.home34.notebook.graph;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.itStep.home34.notebook.graph.listeners.ButtonListener;
import com.itStep.home34.notebook.graph.listeners.WindowListener;

@SuppressWarnings ("serial")
public class NotepadWindow extends JFrame {

    private Container cont;
    private final String IMAGE = "resources/notebook/Notepad2.png";
    private JFrame current = this;
    private WindowListener mLis = new WindowListener(this);
    private NotesMenu notes;
    private RemindersMenu reminders;
    private JButton note;
    private JButton reminder;
    private JButton exit;
    private JLabel title;
    private final Font font = new Font("Segoe Print", Font.BOLD, 25);
    private final Dimension SIZE = new Dimension(385, 506);

    public NotepadWindow () {
	window();
	title();
	note();
	reminder();
	exit();
	add();
    }

    /**
     * Настройки окна
     */
    private void window () {
	setSize(SIZE);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("Notepad v2.0");
	setResizable(false);
	addMouseListener(mLis);
	addMouseMotionListener(mLis);
	setUndecorated(true);
	setContentPane(new CPanel());
	cont = getContentPane();
	cont.setLayout(null);
	// setOpacity(0.6f);
    }

    private void title () {
	title = new JLabel("Main menu");
	title.setFont(new Font("Segoe Print", Font.BOLD, 35));
	title.setBounds(115, 30, 200, 54);
    }

    private void note () {
	Rectangle r = new Rectangle(164, 134, 104, 55);
	note = buttonsCreator(r, "Notes");
    }

    private void reminder () {
	Rectangle r = new Rectangle(132, 229, 167, 55);
	reminder = buttonsCreator(r, "Reminders");
    }

    private void exit () {
	Rectangle r = new Rectangle(270, 450, 83, 55);
	exit = buttonsCreator(r, "Exit");
    }

    /**
     * @param title Надпись на кнопке
     * @param r - координаты и размеры кнопки
     * @return Готовую кнопку с заданными параметрами
     * 
     */
    private JButton buttonsCreator (Rectangle r, String title) {
	JButton button = new JButton();
	button.setText(title);
	button.setFont(font);
	button.setBounds(r);
	button.setBorderPainted(false);
	button.setContentAreaFilled(false);
	button.setFocusPainted(false);
	button.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed (ActionEvent e) {
		if ("Exit".equals(title)) System.exit(0);

		if ("Notes".equals(title)) {
		    if (notes == null) {
			notes = new NotesMenu(current);
		    }
		    notes.start();
		} else {
		    if (reminders == null) {
			reminders = new RemindersMenu(current);
		    }
		    reminders.start();
		}		
		setVisible(false);
	    }
	});
	button.addMouseListener(new ButtonListener(button));
	return button;
    }

    private void add () {
	cont.add(title);
	cont.add(note);
	cont.add(reminder);
	cont.add(exit);
    }

    public void start () {
	setVisible(true);
    }

    class CPanel extends JPanel {
	public void paintComponent (Graphics g) {
	    Image im = null;
	    try {
		im = ImageIO.read(new File(IMAGE));
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    g.drawImage(im, 0, 0, null);
	}
    }
}
