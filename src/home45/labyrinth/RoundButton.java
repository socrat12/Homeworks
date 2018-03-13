package home45.labyrinth;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

@SuppressWarnings ("serial")
public class RoundButton extends JButton {

    public RoundButton (String label) {
	setText(label);
	setBackground(Color.green);
	Dimension size = getPreferredSize();
	setLocation(100, 100);
	size.width = size.height = 10;
	setPreferredSize(size);
	setContentAreaFilled(false);
    }

    protected void paintComponent (Graphics g) {
	g.setColor(Color.GREEN);
	g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
	super.paintComponent(g);
    }

    protected void paintBorder (Graphics g) {
	g.setColor(getForeground());
	g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    public boolean contains (int x, int y) {
	Shape shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
	return shape.contains(x, y);
    }
}