
package lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class activity1 {

    private static void printProducts(String header, List<String> products) {
        System.out.println(header);
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, products.get(i));
        }
        System.out.println();
    }

    private static boolean searchByLoop(List<String> products, String query) {
        for (String p : products) {
            if (p.equalsIgnoreCase(query)) {
                               return true;
            }
        }
        return false;
    }

    private static boolean searchByContains(List<String> products, String query) {
        String q = query.toLowerCase();
        for (String p : products) {
            if (p.toLowerCase().contains(q) && p.equalsIgnoreCase(query)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = new ArrayList<>();
        products.add("Laptop");
        products.add("Mouse");
        products.add("Keyboard");
        products.add("Monitor");
        products.add("Printer");

        printProducts("All products:", products);

        products.removeIf(p -> p.equalsIgnoreCase("Mouse"));
        products.add("Webcam");

        printProducts("After adding and removing products:", products);

        System.out.print("Enter product name to search: ");
        String query = scanner.nextLine().trim();
        System.out.println();

        boolean foundByLoop = searchByLoop(products, query);
        boolean foundByContains = searchByContains(products, query);

        if (foundByLoop || foundByContains) {
            System.out.printf("Product found: %s%n", query);
        } else {
            System.out.println("Product not found.");
        }

        scanner.close();
    }}
