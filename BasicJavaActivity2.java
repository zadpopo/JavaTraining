import java.util.Scanner;

public class BasicJavaActivity2 {
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        String ageText = scanner.nextLine(); // Read age as a String

        // Parse the String to an int
        int age = 0;
        age = Integer.parseInt(ageText); // Convert String to int
        scanner.close();

        // Typecast int to double
        double ageAsDouble = (double) age;

        // Display results
        System.out.println("Your age as int: " + age);
        System.out.println("Your age as double: " + ageAsDouble);

        scanner.close(); // Close scanner

    } // end of main method

} // end of BasicJavaActivity2 class