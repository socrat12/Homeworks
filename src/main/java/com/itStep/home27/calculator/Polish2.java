package com.itStep.home27.calculator;

import java.util.*;

public class Polish2 {
    // доступные операторы
    public static final String OPERATORS = "+-*/^";
    // преобразованная строка
    private static List<String> polishEntry;
    // временный стек для операторов и скобок
    private static List<String> stek;

    public static double refactoring(String input) {
	int nextNumberStart = 0;
	stek = new LinkedList<String>();
	polishEntry = new LinkedList<String>();

	for (int i = 0; i < input.length(); i++) {
	    // открывающая скобка просто помещается в стек
	    if (input.charAt(i) == '(') {
		stek.add("" + input.charAt(i));
		// начало следующего числа - после открывающей скобки
		nextNumberStart++;
	    } else if (input.charAt(i) == ')') {
		// добавить последнее число внутри скобок в polsihEntry
		polishEntryAdd(input.substring(nextNumberStart, i));
		// пока не встретится открывающая скобка - добавлять операторы
		// из стека в PolishEntry
		while (!"(".equals(stek.get(stek.size() - 1))) {
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
		// удалить открывающую скобку из стека
		stek.remove(stek.size() - 1);
		// начало следующего числа - после закрывающей скобки
		nextNumberStart = i + 1;
	    } else if (input.charAt(i) == '+' || input.charAt(i) == '-') {
		if (input.charAt(i) == '-') {
		    // если минус вначале выражения или после другого оператора
		    // или после открывающей скобки, то он часть числа, а не
		    // оператор в данном случае
		    if (i == 0 || OPERATORS.contains("" + input.charAt(i - 1)) || (input.charAt(i - 1) == '(')) {
			continue;
		    }
		}
		polishEntryAdd(input.substring(nextNumberStart, i));
		// если стек не пуст и последний элемент в нём - любой оператор,
		if (!stek.isEmpty() && OPERATORS.contains(stek.get(stek.size() - 1))) {
		    // переместить этот оператор в выходную строку,
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
		// а текущий оператор добавить в стек
		stek.add("" + input.charAt(i));
		// начало следующего числа после оператора
		nextNumberStart = i + 1;
	    } else if (input.charAt(i) == '*' || input.charAt(i) == '/') {
		polishEntryAdd(input.substring(nextNumberStart, i));
		// если стек не пуст и последний элемент в нём - оператор с
		// таким же или бОльшим приоритетом
		if (!stek.isEmpty() && ("*".equals(stek.get(stek.size() - 1)) || "/".equals(stek.get(stek.size() - 1))
			|| "^".equals(stek.get(stek.size() - 1)))) {
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
		stek.add("" + input.charAt(i));
		nextNumberStart = i + 1;
	    } else if (input.charAt(i) == '^') {
		polishEntryAdd(input.substring(nextNumberStart, i));
		if (!stek.isEmpty() && "^".equals(stek.get(stek.size() - 1))) {
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
		stek.add("" + input.charAt(i));
		nextNumberStart = i + 1;
	    }
	    // если выходная строка закончилась
	    if (i == input.length() - 1) {
		// добавить в выходную строку последнее число
		polishEntryAdd(input.substring(nextNumberStart, i + 1));
		while (!stek.isEmpty()) {
		    // и переместить все операторы из стека
		    polishEntry.add(stek.get(stek.size() - 1));
		    stek.remove(stek.size() - 1);
		}
	    }
	}
	return calculate();
    }

    private static double calculate() {
	//System.out.println();
	// for (String next : polishEntry) System.out.print(string + "|");
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

    private static void polishEntryAdd(String substring) {
	if (substring.length() == 0) {
	    return;
	}

	polishEntry.add(substring);
    }
}
