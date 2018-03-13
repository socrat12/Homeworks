package home27.calculator;

import java.util.*;

public class Polish {
    private final String OPERATORS = "+-*/^";
    List<String> polishEntry;
    List<String> stek;

    public double refactoring(String input) {
	int nextNumberStart = 0;
	stek = new LinkedList<String>();
	polishEntry = new LinkedList<String>();

	for (int i = 0; i < input.length(); i++) {
	    if (input.charAt(i) == '(') {
		stek.add("" + input.charAt(i));
		nextNumberStart++;
	    }

	    if (input.charAt(i) == ')') {
		polishEntryAdd(input.substring(nextNumberStart, i));
		while (!"(".equals(stek.get(stek.size() - 1))) {
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
		stek.remove(stek.size() - 1);
		nextNumberStart = i + 1;
	    }

	    if (input.charAt(i) == '+' || input.charAt(i) == '-') {
		if (input.charAt(i) == '-') {
		    if (i == 0 || OPERATORS.contains("" + input.charAt(i - 1))
			    || (!stek.isEmpty() && "(".equals(stek.get(stek.size() - 1)))) {
			continue;
		    }
		}
		polishEntryAdd(input.substring(nextNumberStart, i));
		if (!stek.isEmpty() && OPERATORS.contains(stek.get(stek.size() - 1))) {
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
		stek.add("" + input.charAt(i));
		nextNumberStart = i + 1;
	    }

	    if (input.charAt(i) == '*' || input.charAt(i) == '/') {
		polishEntryAdd(input.substring(nextNumberStart, i));
		if (!stek.isEmpty() && ("*".equals(stek.get(stek.size() - 1)) || "/".equals(stek.get(stek.size() - 1))
			|| "^".equals(stek.get(stek.size() - 1)))) {
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
		stek.add("" + input.charAt(i));
		nextNumberStart = i + 1;
	    }

	    if (input.charAt(i) == '^') {
		polishEntryAdd(input.substring(nextNumberStart, i));
		if (!stek.isEmpty() && "^".equals(stek.get(stek.size() - 1))) {
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
		stek.add("" + input.charAt(i));
		nextNumberStart = i + 1;
	    }

	    if (i == input.length() - 1) {
		polishEntryAdd(input.substring(nextNumberStart, i + 1));
		while (!stek.isEmpty()) {
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
	    }
	}
	return calculate();
    }

    private double calculate() {
	System.out.println();
	for (int i = 0; i < polishEntry.size(); i++) {
	    if (OPERATORS.contains(polishEntry.get(i))) {
		switch (polishEntry.get(i)) {
		case "+": {
		    polishEntry.set((i - 2), "" + (Double.parseDouble(polishEntry.get(i - 2))
			    + Double.parseDouble(polishEntry.get(i - 1))));
		    break;
		}
		case "-": {
		    polishEntry.set((i - 2), "" + (Double.parseDouble(polishEntry.get(i - 2))
			    - Double.parseDouble(polishEntry.get(i - 1))));
		    break;
		}
		case "*": {
		    polishEntry.set((i - 2), "" + (Double.parseDouble(polishEntry.get(i - 2))
			    * Double.parseDouble(polishEntry.get(i - 1))));
		    break;
		}
		case "/": {
		    polishEntry.set((i - 2), "" + (Double.parseDouble(polishEntry.get(i - 2))
			    / Double.parseDouble(polishEntry.get(i - 1))));
		    break;
		}
		case "^": {
		    polishEntry.set((i - 2), "" + Math.pow(Double.parseDouble(polishEntry.get(i - 2)),
			    Double.parseDouble(polishEntry.get(i - 1))));
		    break;
		}
		}
		polishEntry.remove(i);
		polishEntry.remove(i - 1);
		i = -1;
	    }
	}
	return Double.parseDouble(polishEntry.get(0));
    }

    private void polishEntryAdd(String substring) {
	if (substring.length() == 0) {
	    return;
	}

	polishEntry.add(substring);
    }
}
