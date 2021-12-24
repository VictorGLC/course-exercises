package exercises.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import exercises.entities.files.Product;

public class IOExercise {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
			
			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));
				
				line = br.readLine();
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				
				for(Product p : list) {
					bw.write(p.getName() + "," + String.format("%.2f", p.total()));
					bw.newLine();
				}
				
				System.out.println(targetFileStr + " CREATED!");
			} catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			} 
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
			
		sc.close();
	}
	
}
