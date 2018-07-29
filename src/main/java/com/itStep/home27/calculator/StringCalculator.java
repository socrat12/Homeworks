package com.itStep.home27.calculator;

import java.util.List;
import java.util.LinkedList;

/**
 * @author Alexander Neznaev
 *
 */
public class StringCalculator implements Calculator {
    private final char[] OPERATORS = { '+', '-', '*', '/', '^' };
    List<Double> resultNumber;
    List<Character> operations;

    public double calculateStringExpression(String input) {
	int nextNumberStart = 0;
	resultNumber = new LinkedList<Double>();
	operations = new LinkedList<Character>();
	String tempString = new String();

	for (int i = 0; i < input.length(); i++) {
	    if (input.charAt(i) == '(') {
		int count = 1, bracketsEnd = 0;
		String inBrackets = new String();
		for (int k = i + 1; count > 0; k++) {
		    if (input.charAt(k) == '(') {
			count++;
		    }
		    if (input.charAt(k) == ')') {
			count--;
		    }
		    if (count != 0) {
			inBrackets += input.charAt(k);
		    } else {
			bracketsEnd = k + 1;
		    }
		}

		tempString += calculateStringExpression(inBrackets);
		tempString += input.substring(bracketsEnd, input.length());

		return calculateStringExpression(tempString);
	    }

	    tempString += input.charAt(i);

	    oper: for (int j = 0; j < OPERATORS.length; j++) {
		if (input.charAt(i) == OPERATORS[j]) {
		    if (input.charAt(i) == '-') {
			if (i == 0 || input.charAt(i - 1) == '(') {
			    break oper;
			}
			for (int k = 0; k < OPERATORS.length; k++) {
			    if (input.charAt(i - 1) == OPERATORS[k]) {
				break oper;
			    }
			}
		    }
		    operations.add(OPERATORS[j]);
		    nextNumberSet(input, nextNumberStart, i);
		    nextNumberStart = i + 1;
		    break;
		}

		if (i == input.length() - 1) {
		    nextNumberSet(input, nextNumberStart, ++i);
		    break;
		}
	    }
	}

	for (int i = 0; i < operations.size(); i++) {
	    // возведение в степень
	    if (operations.get(i) == '^') {
		resultNumber.set((i), Math.pow(resultNumber.get(i), resultNumber.get(i + 1)));
		resultNumber.remove(i + 1);
		operations.remove(i--);
		continue;
	    }
	}

	for (int i = 0; i < operations.size(); i++) {
	    // умножение
	    if (operations.get(i) == '*') {
		resultNumber.set((i), resultNumber.get(i) * resultNumber.get(i + 1));
		resultNumber.remove(i + 1);
		operations.remove(i--);
		continue;
	    }
	    // деление
	    if (operations.get(i) == '/') {
		resultNumber.set((i), resultNumber.get(i) / resultNumber.get(i + 1));
		resultNumber.remove(i + 1);
		operations.remove(i--);
		continue;
	    }
	}

	for (int i = 0; i < operations.size(); i++) {
	    // сложение
	    if (operations.get(i) == '+') {
		resultNumber.set((i), resultNumber.get(i) + resultNumber.get(i + 1));
		resultNumber.remove(i + 1);
		operations.remove(i--);
		continue;
	    }
	    // умножение
	    if (operations.get(i) == '-') {
		resultNumber.set((i), resultNumber.get(i) - resultNumber.get(i + 1));
		resultNumber.remove(i + 1);
		operations.remove(i--);
		continue;
	    }
	}

	return resultNumber.get(0);
    }

    private void nextNumberSet(String input, int nextNumber, int i) {
	String number = new String();

	number = input.substring(nextNumber, i);

	resultNumber.add(Double.parseDouble(number));
    }
}
