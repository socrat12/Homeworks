package home45.labyrinth;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings ("serial")
public class Round extends JButton {
    int x, y;
    
    public Round(int rad, int x, int y) {
	this.x = x;
	this.y = y;
	System.out.println(x + " " + y);
        setSize(new Dimension(300, 200));
        System.out.println(getSize());
        setContentAreaFilled(false);
        //setBorderPainted(false);
    }
    
    protected void paintComponent(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillOval(x, y, 100, 100);
        super.paintComponent(g);
    }
    
    /*protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(x, y, 100, 100);
    }*/
}
