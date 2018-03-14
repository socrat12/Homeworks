package home60;

public class Pomogator {

    private static final String WIDTH = " width=";
    private static final String HEIGHT = " height=";
    private static final String CELLSIZE = "\"100\"";
    private static final String DARKCOLOR = " bgcolor=\"#769656\"";
    private static final String LIGHTCOLOR = " bgcolor=\"#EEEED2\"";
    private static final String[] BLACK = { "BP", "BR", "BH", "BB", "BQ", "BK", "BB", "BH", "BR" };
    private static final String[] WHITE = { "WP", "WR", "WH", "WB", "WQ", "WK", "WB", "WH", "WR" };

    public static void main (String[] args) {
	for (int i = 0; i < 9; i++) {
	    System.out.print("<tr" + HEIGHT + CELLSIZE + ">");
	    if (i == 0) {
		System.out.print("<td align=\"center\"" + WIDTH + CELLSIZE + "><i><b>" + 8 + "</b></i></td>");
	    } else {
		if (i != 8) System.out.print("<td align=\"center\"><i><b>" + (8 - i) + "</b></i></td>");
		else System.out.print("<td></td>");
	    }

	    for (int j = 1; j < 9; j++) {
		if (i == 8) {
		    System.out.print("<td align=\"center\"><i><b>" + (char) ('A' - 1 + j) + "</b></i></td>");
		    continue;
		}
		if (i == 0) {
		    if (j % 2 != 0) System.out.print("<td" + WIDTH + CELLSIZE + LIGHTCOLOR + "background=\"Images//"
			    + BLACK[j] + ".png\"></td>");
		    else System.out.print("<td" + WIDTH + CELLSIZE + DARKCOLOR + "background=\"Images//" 
			    + BLACK[j] + ".png\"></td>");
		    continue;
		}
		if (i == 1 || i == 6) {
		    if (i % 2 - j % 2 != 0) System.out.print("<td" + LIGHTCOLOR + "background=\"Images//" + 
			    (i == 1 ? BLACK[0] : WHITE[0]) + ".png\"></td>");
		    else System.out.print("<td" + DARKCOLOR + "background=\"Images//" + 
			    (i == 1 ? BLACK[0] : WHITE[0]) + ".png\"></td>");
		    continue;
		}
		if (i == 7) {
		    if (i % 2 - j % 2 != 0) System.out.print("<td" + LIGHTCOLOR + "background=\"Images//" + 
			    WHITE[j] + ".png\"></td>");
		    else System.out.print("<td" + DARKCOLOR + "background=\"Images//" + 
			    WHITE[j] + ".png\"></td>");
		    continue;
		}
		if (i % 2 - j % 2 != 0) System.out.print("<td" + LIGHTCOLOR + "></td>");
		else System.out.print("<td" + DARKCOLOR + "></td>");
	    }
	    System.out.print("</tr>");
	}
    }
}
