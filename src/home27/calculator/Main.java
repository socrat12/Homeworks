package home27.calculator;

public class Main {
    public static void main(String[] argv) {
	Calculator calc = new StringCalculator();

	String expression = "2.3+3.7-4*(5+6)";

	System.out.println(calc.calculateStringExpression(expression));

	expression = "((2+2)*2-2)^2/2+2";

	System.out.println(calc.calculateStringExpression(expression));

	expression = "10*3^2";

	System.out.println(calc.calculateStringExpression(expression));

	expression = "-10-2";

	System.out.println(calc.calculateStringExpression(expression));

	expression = "(8+2*5)/(1+(-3)*-2-4)";

	System.out.println(calc.calculateStringExpression(expression));

	expression = "9^-2";

	System.out.println(calc.calculateStringExpression(expression));
	
	expression = "3+4*2/(1-5)^2";
	Polish pol = new Polish();

	System.out.println(pol.refactoring(expression));
    }
}