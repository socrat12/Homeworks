package home45.labyrinth;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings ("serial")
public class LabirinthMap extends JFrame{
    
    public LabirinthMap () {
	showLab (7, 7);
    }
    
    public LabirinthMap (int width, int heidth) {
	showLab (width, heidth);
    }
    
    private void showLab (int width, int heidth) {
	setTitle("Labirinth");
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setResizable(false);
	setSize(500,500);
	JPanel cells[][] = new JPanel[width][heidth];
	setLayout(new GridLayout(width, heidth));
	
	for (int i = 0; i < cells.length; i += cells.length - 1) {
	    for (int j = 0; j < cells[i].length; j++) {
		cells[i][j] = new JPanel();
		cells[i][j].setBackground(Color.BLACK);
		cells[j][i] = new JPanel();
		cells[j][i].setBackground(Color.BLACK);
	    }
	}
	
	for (int i = 1; i < cells.length - 1; i++) {
	    for (int j = 1; j < cells.length - 1; j++) {
		cells[i][j] = new JPanel();
	    }
	}
	wall(cells[1][3], cells[2][3], cells[3][2], cells[3][3], cells[4][4], cells[5][2]);
	cells[0][2].setBackground(getBackground());
	//int x = cells[3][4].getWidth()/2;
	//int y = cells[3][4].getHeight()/2;
	System.out.println(cells[3][4].getHeight()/2);
	RoundButton round = new RoundButton("");
	cells[3][4].add(round);
	
	for (int i = 0; i < cells.length; i++) {
	    for (int j = 0; j < cells.length; j++) {
		add(cells[i][j]);
	    }
	}
	System.out.println(cells[3][4].getBounds());
	setVisible(true);
    }

    private void wall (JPanel ...jPanel) {
	for (int i = 0; i < jPanel.length; i++) {
	    jPanel[i].setBackground(Color.BLACK);
	}
    }
}