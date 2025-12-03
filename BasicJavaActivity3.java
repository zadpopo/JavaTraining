import java.util.Scanner;

public class BasicJavaActivity3 {
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user for two integers
        System.out.print("Enter first integer: ");
        int firstNumber = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int secondNumber = scanner.nextInt();

        // Compute results of two integers
        int sum = firstNumber + secondNumber;
        int difference = firstNumber - secondNumber;
        int product = firstNumber * secondNumber;

        // Display results of computation
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);

        // Close Scanner
        scanner.close();

    } // end of main method

} // end of BasicJavaActivity3 class