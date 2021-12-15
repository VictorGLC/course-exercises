package exercises.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercises.entities.polymorphism.Company;
import exercises.entities.polymorphism.Individual;
import exercises.entities.polymorphism.TaxPayer;

public class TaxExercise {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxList = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			if(type == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				taxList.add(new Individual(name, anualIncome, healthExpenditures));
			} else if (type == 'c') {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				taxList.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
		double sum = 0;
		System.out.println();
		System.out.println("TAXES PAID: ");
		for(TaxPayer tp : taxList) {
			sum += tp.tax();
			System.out.println(tp);
		}
		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));
		sc.close();
		
	}
}
