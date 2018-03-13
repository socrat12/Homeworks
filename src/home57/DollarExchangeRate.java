package home57;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DollarExchangeRate {

    private static final String DOLLAR = "1 Доллар США";

    public static void main(String[] args) {
	double rate = currentRate();
	System.out.println("Today dollar rate is " + rate);
    }

    private static double currentRate() {
	StringBuilder rate = new StringBuilder();
	String inputLine = "";
	
	try {
	    URL nbrb = new URL("https://www.nbrb.by/");
	    BufferedReader reader = new BufferedReader(new InputStreamReader(nbrb.openStream()));

	    while ((inputLine = reader.readLine()) != null) {
		if (inputLine.contains(DOLLAR)) {
		    reader.close();
		    break;
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	}

	for (int i = 0; i < inputLine.length(); i++) {
	    if (inputLine.charAt(i) == DOLLAR.charAt(0)) {
		i++;
		boolean coincidence = true;
		for (int j = 1; j < DOLLAR.length(); j++) {
		    if (inputLine.charAt(i) != DOLLAR.charAt(j)) {
			coincidence = false;
			break;
		    }
		    i++;
		}
		if (coincidence) {
		    while (!Character.isDigit(inputLine.charAt(++i)));
		    while (Character.isDigit(inputLine.charAt(i))) {
			rate.append(inputLine.charAt(i++));
			if (inputLine.charAt(i) == ',') {
			    rate.append('.');
			    i++;
			}
		    }
		    break;
		}
	    }
	}
	return Double.parseDouble(rate.toString());
    }
}