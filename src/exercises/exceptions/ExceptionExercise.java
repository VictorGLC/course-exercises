package exercises.exceptions;

import java.util.Locale;
import java.util.Scanner;

import exercises.entities.exceptions.Account;
import exercises.entities.exceptions.DomainException;

public class ExceptionExercise {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Account Data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.next();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account ac = new Account(number, holder, withdrawLimit, initialBalance);
			System.out.println();
			
			System.out.print("Enter the amount for withdraw: ");
			double amount = sc.nextDouble();
			ac.withdraw(amount);
			System.out.println(ac);
		} catch (DomainException e) {
			System.out.println("Withdraw Error: " + e.getMessage());
		} finally {
			sc.close();
		}
		
	}

}
