package lesson3;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class activity3 {

	


    private static Map<String, Integer> initProducts() {
        Map<String, Integer> products = new LinkedHashMap<>();
        products.put("Laptop", 5000);
        products.put("Monitor", 7000);
        products.put("Mouse", 500);
        products.put("Keyboard", 1000);
        products.put("Printer", 6000);
        return products;
    }

    private static boolean containsKeyIgnoreCase(Map<String, Integer> products, String key) {
        for (String k : products.keySet()) {
            if (k.equalsIgnoreCase(key)) {
                return true;
            }
        }
        return false;
    }

    private static String getStoredKey(Map<String, Integer> products, String key) {
        for (String k : products.keySet()) {
            if (k.equalsIgnoreCase(key)) {
                return k;
            }
        }
        return null;
    }

    private static void printMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Search a product");
        System.out.println("2. Add a product");
        System.out.println("3. Print all products and prices");
        System.out.println("4. Find the cheapest product");
        System.out.println("5. Exit");
        System.out.print("> ");
    }

    private static void printAll(Map<String, Integer> products) {
        System.out.println("All products and prices:");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }
        System.out.printf("Total products: %d%n%n", products.size());
    }

    private static void findCheapest(Map<String, Integer> products) {
        if (products.isEmpty()) {
            System.out.println("No products available.\n");
            return;
        }
        String cheapestProduct = null;
        int cheapestPrice = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() < cheapestPrice) {
                cheapestPrice = entry.getValue();
                cheapestProduct = entry.getKey();
            }
        }

        System.out.printf("Cheapest product: %s - %d%n%n", cheapestProduct, cheapestPrice);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> products = initProducts();

        boolean running = true;
        while (running) {
            printMenu();
            String choiceLine = scanner.nextLine().trim();

            // Validate numeric input
            if (!choiceLine.matches("\\d+")) {
                System.out.println("Invalid input. Please enter 1-5.\n");
                continue;
            }

            int choice = Integer.parseInt(choiceLine);

            switch (choice) {
                case 1: // Search a product
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine().trim();
                    if (containsKeyIgnoreCase(products, searchName)) {
                        String storedKey = getStoredKey(products, searchName);
                        int price = products.get(storedKey);
                        System.out.printf("Product found! Price: %d%n%n", price);
                    } else {
                        System.out.println("Product not found!\n");
                    }
                    break;

                case 2: // Add a product
                    System.out.print("Enter product name to add: ");
                    String newName = scanner.nextLine().trim();
                    if (newName.isEmpty()) {
                        System.out.println("Product name cannot be empty.\n");
                        break;
                    }

                    System.out.print("Enter price: ");
                    String priceInput = scanner.nextLine().trim();
                    if (!priceInput.matches("\\d+")) {
                        System.out.println("Invalid price. Please enter a positive number.\n");
                        break;
                    }

                    int price = Integer.parseInt(priceInput);

                    if (containsKeyIgnoreCase(products, newName)) {
                        String storedKey = getStoredKey(products, newName);
                        System.out.printf("Product already exists: %s - %d%n%n",
                                storedKey, products.get(storedKey));
                    } else {
                        products.put(newName, price);
                        System.out.printf("Product added: %s%n%n", newName);
                    }
                    break;

                case 3: // Print all products and prices
                    printAll(products);
                    break;

                case 4: // Find the cheapest product
                    findCheapest(products);
                    break;

                case 5: // Exit
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1-5.\n");
                                       break;
            }
        }

        scanner.close();

    }



}
