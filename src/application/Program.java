package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			System.out.println("Product #" + (i + 1) + " data:");
			System.out.printf("Common, used or imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			
			while (ch != 'c' && ch != 'u' && ch != 'i') {
				System.out.println("This option doesn't exist!");
				System.out.print("Please try Common, used or imported (c/u/i)? ");
				ch = sc.next().charAt(0);
			}			
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			else if (ch == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));				
			}
			else if (ch == 'c') {
				list.add(new Product(name, price));
			}			
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product p : list) {
			System.out.println(p.priceTag());
		}
		
		sc.close();
	}
}
