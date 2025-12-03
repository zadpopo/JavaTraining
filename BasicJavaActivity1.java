import java.util.Scanner;

public class BasicJavaActivity1 {
    public static void main(String[] args) {

        // Create Scanner object for user input
        Scanner input = new Scanner(System.in);

        System.out.print("Enter you name: ");
        String name = input.nextLine(); // Reads user input and reads the whole line as name

        System.out.println("Hello, " + name + "!");

    } // end of main method

} // end of BasicJavaActivity1 class