package home34.notebook.graph;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import home34.notebook.UI;
import home34.notebook.graph.listeners.DateListener;
import home34.notebook.graph.listeners.StartEndListener;
import home34.notebook.graph.listeners.WindowListener;

@SuppressWarnings ("serial")
public class RemindersMenu extends JFrame {

    private JFrame parent;
    private JFrame current = this;
    public Date startDate;
    public UI ui = new UI();
    private WindowListener mLis = new WindowListener(this);
    private JScrollPane scrollPane;
    public JTextArea output;
    public JTextField input;
    public JTextField[] date = new JTextField[5];
    public JButton dateStartEnd;
    private JButton cancel;
    private JButton showAll;
    private JButton add;
    private JButton remove;
    private JButton period;
    private JButton back;
    private JLabel title;
    private final Font font = new Font("Segoe Print", Font.BOLD, 16);
    private static final int INTERVAL = 20;
    private final Dimension SIZE = new Dimension(640, 600);
    private final String TEXT = "Instruction: ";

    public RemindersMenu (JFrame parent) {
	this.parent = parent;
	window();
	title();
	output();
	showAll();
	add();
	remove();
	toPeriod();
	input();
	back();
	cancel();
	createTextFieldsforDate();
	dateStartEnd();
	addtoWindow();
    }

    /**
     * Настройки окна
     */
    private void window () {
	setSize(SIZE);
	setLocationRelativeTo(parent);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setTitle("Reminders");
	setResizable(false);
	addMouseListener(mLis);
	addMouseMotionListener(mLis);
	setUndecorated(true);
	setLayout(null);
	// setOpacity(0.6f);
    }

    private void title () {
	title = new JLabel("Reminders Menu");
	title.setFont(new Font("Segoe Print", Font.BOLD, 25));
	title.setSize(250, 54);
	title.setLocation(getWidth() / 2 - title.getWidth() / 2, 0);
    }

    private void output () {
	output = new JTextArea();
	output.setFont(new Font("Segoe Print", Font.BOLD, 14));
	output.setBounds(20, 60, getWidth() - 180, 460);
	output.setEditable(false);
	output.setAutoscrolls(true);
	output.setText(TEXT);
	output.setWrapStyleWord(true);
	scrollPane = new JScrollPane(output);
	scrollPane.setBounds(output.getBounds());
    }

    private void input () {
	input = new JTextField();
	input.setFont(font);
	input.setBounds(output.getX(), output.getY() + output.getHeight() + INTERVAL, output.getWidth(), 40);
	input.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped (KeyEvent e) {
		if (e.getKeyChar() == KeyEvent.VK_ENTER) {
		    reminderAdd();
		}
	    }
	});

    }

    private void createTextFieldsforDate () {
	int[] limits = { 31, 12, 3000, 23, 59 };
	for (int i = 0; i < 5; i++) {
	    date[i] = new JTextField();
	    date[i].setFont(font);
	    if (i != 0) date[i].setLocation(date[i - 1].getX() + date[i - 1].getWidth() + INTERVAL, date[i - 1].getY());
	    else date[i].setLocation(output.getX(), output.getY() + output.getHeight() + INTERVAL);
	    if (i != 2) date[i].setSize(input.getHeight() + 7, input.getHeight());
	    else date[i].setSize(input.getHeight() + 15, input.getHeight());
	    date[i].addKeyListener(new DateListener(date[i], limits[i]));
	}
    }

    private void showAll () {
	showAll = new JButton("Show All");
	showAll.setFont(font);
	showAll.setBounds(output.getX() + output.getWidth() + INTERVAL, output.getY() + INTERVAL, 120, 40);
	showAll.setLocation(output.getX() + output.getWidth() + INTERVAL, output.getY() + INTERVAL);
	showAll.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed (ActionEvent e) {
		output.setText(ui.showAllReminders());
	    }
	});
    }

    private void add () {
	add = new JButton("Add");
	add.setFont(font);
	add.setSize(showAll.getSize());
	add.setLocation(showAll.getX(), showAll.getY() + showAll.getHeight() + INTERVAL);
	add.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed (ActionEvent e) {
		reminderAdd();
	    }
	});
    }

    /**
     * 
     */
    private void reminderAdd () {
	if (input.getText().length() == 0) return;
	toPeriodChange("On date");
    }

    public void toTextArea (String content) {
	output.setText(content);
	input.setText("");
    }

    private void remove () {
	remove = new JButton("Remove");
	remove.setFont(font);
	remove.setSize(showAll.getSize());
	remove.setLocation(showAll.getX(), add.getY() + add.getHeight() + INTERVAL);
	remove.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed (ActionEvent e) {
		if (input.getText().length() == 0) return;
		if ("all".equals(input.getText().toLowerCase())) {
		    ui.removeAllReminders();
		    toTextArea("All reminders have been deleted");
		    return;
		}
		long id = 0;
		try {
		    id = Long.parseLong(input.getText());
		} catch (NumberFormatException e2) {
		    toTextArea("Wrong input");
		    return;
		}
		toTextArea(ui.removeReminder(id));
	    }
	});
    }

    private void toPeriod () {
	period = new JButton("Period");
	period.setFont(font);
	period.setSize(showAll.getSize());
	period.setLocation(showAll.getX(), remove.getY() + remove.getHeight() + INTERVAL);
	period.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered (MouseEvent e) {
		period.setToolTipText("Show reminders planned in a certain period");
	    }

	    @Override
	    public void mouseExited (MouseEvent e) {
		period.setToolTipText("");
	    }
	});
	period.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed (ActionEvent e) {
		toPeriodChange("Date start");
	    }
	});
    }

    private void toPeriodChange (String title) {
	remove(input);
	for (JTextField f : date) {
	    add(f);
	}
	add(cancel);
	dateStartEnd.setText(title);
	add(dateStartEnd);
	repaint();
    }

    private void back () {
	back = new JButton("Back");
	back.setFont(font);
	back.setSize(showAll.getSize());
	back.setLocation(showAll.getX(), input.getY());
	back.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed (ActionEvent e) {
		setVisible(false);
		parent.setLocationRelativeTo(current);
		parent.setVisible(true);
		parent.toFront();
	    }
	});
    }

    private void cancel () {
	cancel = new JButton("Cancel");
	cancel.setFont(font);
	cancel.setSize(showAll.getSize());
	cancel.setLocation(showAll.getX(), input.getY() - showAll.getHeight() - INTERVAL);
	cancel.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed (ActionEvent e) {
		cancelAction();
	    }
	});
    }

    /**
     * Действие при нажатии Cancel
     */
    public void cancelAction () {
	remove(cancel);
	for (JTextField f : date) {
	    f.setText("");
	    remove(f);
	}
	add(input);
	remove(dateStartEnd);
	repaint();
    }

    private void dateStartEnd () {
	dateStartEnd = new JButton();
	dateStartEnd.setFont(font);
	dateStartEnd.setLocation(date[date.length - 1].getX() + date[0].getWidth() + INTERVAL, input.getY());
	dateStartEnd.setSize(output.getX() + output.getWidth() - dateStartEnd.getX(), showAll.getHeight());
	dateStartEnd.addActionListener(new StartEndListener(current));
    }

    public boolean isEmptyFields () {
	boolean empty = true;
	for (JTextField f : date) {
	    if (f.getText().length() != 0) {
		empty = false;
	    }
	}
	return empty;
    }

    private void addtoWindow () {
	add(title);
	add(scrollPane, BorderLayout.CENTER);
	add(showAll);
	add(add);
	add(remove);
	add(period);
	add(input);
	add(back);
    }

    public void start () {
	setVisible(true);
    }
}
