package exercises.list;

import java.util.Scanner;

public class CalculatorExercise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] vect = new String[2];
		String calculation = sc.nextLine();
		
		vect = calculation.split(" ");
		
		double numberOne = Double.parseDouble(vect[0]);
		String symbol = vect[1];
		double numberTwo = Double.parseDouble(vect[2]);
		calculate(numberOne, symbol, numberTwo);
		
		sc.close();
	}
	
	public static void calculate(double numberOne, String symbol, double numberTwo) {
		System.out.print("O resultado da sua equação é: ");
		if("+".equals(symbol)) {
			System.out.print(numberOne + numberTwo);
		} else if("-".equals(symbol)) {
			System.out.print(numberOne - numberTwo);
		}else if("*".equals(symbol)) {
			System.out.print(numberOne * numberTwo);
		} else if("/".equals(symbol)) {
			System.out.print(numberOne / numberTwo);
		}
	}
}
