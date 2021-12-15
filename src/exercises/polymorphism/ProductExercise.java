package exercises.polymorphism;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercises.entities.polymorphism.ImportedProduct;
import exercises.entities.polymorphism.Product;
import exercises.entities.polymorphism.UsedProduct;


public class ProductExercise {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> productsList = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(type == 'c') {
				productsList.add(new Product(name, price));
			}else if(type == 'i') {
				System.out.print("Customs Fee: ");
				double customsFee = sc.nextDouble();
				productsList.add(new ImportedProduct(name, price, customsFee));
			} else if(type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				productsList.add(new UsedProduct(name, price, manufactureDate));
			}
			
		}
		System.out.println();
		System.out.println("PRICE TAGS:");
		for(Product products : productsList) {
			System.out.println(products.priceTag());
		}
		
		sc.close();
	}
}
