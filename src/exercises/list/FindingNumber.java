package exercises.list;

import java.util.Scanner;

public class FindingNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insert the array size: ");
		int n = sc.nextInt();
		int[] vect = new int[n];
		
		System.out.print("Add the array list: ");
		for (int i=0; i<vect.length; i++) {
				vect[i]= sc.nextInt();
		}
		System.out.print("Insert the number to be found: ");
		int numberToFind= sc.nextInt();
		int sum = 0;
		
		for (int i=0; i<vect.length; i++) {
			if(vect[i] == numberToFind) {
				sum++;
			}
		}
		System.out.println("This vector has " + sum + " number " + numberToFind);
		
		sc.close();
	}
}
