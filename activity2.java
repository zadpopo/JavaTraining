package lesson3;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class activity2 {


	    private static Set<String> initProducts() {
	        Set<String> products = new HashSet<>();
	        products.add("Laptop");
	        products.add("Monitor");
	        products.add("Mouse");
	        products.add("Keyboard");
	        products.add("Printer");
	        return products;
	    }


	    private static boolean containsIgnoreCase(Set<String> products, String query) {
	        for (String p : products) {
	            if (p.equalsIgnoreCase(query)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    private static String getStoredName(Set<String> products, String query) {
	        for (String p : products) {
	            if (p.equalsIgnoreCase(query)) {
	                return p;
	            }
	        }
	        return null;
	    }

	    private static void printMenu() {
	        System.out.println("Select an option:");
	        System.out.println("1. Search a product");
	        System.out.println("2. Add a product");
	        System.out.println("3. Print all products and count");
	        System.out.println("4. Exit");
	        System.out.print("> ");
	    }

	    private static void printAll(Set<String> products) {
	        System.out.println("All products:");
	        for (String p : products) {
	            System.out.println(p);
	        }
	        System.out.printf("Total unique products: %d%n", products.size());
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Set<String> products = initProducts();

	        boolean running = true;
	        while (running) {
	            printMenu();

	            String choiceLine = scanner.nextLine().trim();
	            int choice;
	            try {
	                choice = Integer.parseInt(choiceLine);
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter 1-4.\n");
	                continue;
	            }

	            switch (choice) {
	                case 1: // Search a product
	                    System.out.print("Enter product name to search: ");
	                    String searchQuery = scanner.nextLine().trim();

	                    if (containsIgnoreCase(products, searchQuery)) {
	                        String stored = getStoredName(products, searchQuery);
	                        System.out.printf("Product found: %s%n%n", stored);
	                    } else {
	                        System.out.println("Product not found.\n");
	                    }
	                    break;

	                case 2: // Add a product
	                    System.out.print("Enter product name to add: ");
	                    String productToAdd = scanner.nextLine().trim();

	                    // If it already exists (case-insensitive), do not add duplicate
	                    if (containsIgnoreCase(products, productToAdd)) {
	                        String stored = getStoredName(products, productToAdd);
	                        System.out.printf("Product already exists: %s%n%n", stored);
	                    } else {
	                        products.add(productToAdd);
	                        System.out.printf("Product added: %s%n%n", productToAdd);
	                    }
	                    break;

	                case 3: // Print all products and count
	                    printAll(products);
	                    break;

	                case 4: // Exit
	                    System.out.println("Exiting...");
	                    running = false;
	                    break;

	                default:
	                    System.out.println("Invalid option. Please enter 1-4.\n");
	                    break;
	            }
	        }

	        scanner.close();

	
	
	
	   
	
	
	
	    }
}
