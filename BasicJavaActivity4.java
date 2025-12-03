import java.util.Scanner;

public class BasicJavaActivity4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        if (age < 18) {
            System.out.println("Minor");
        } else if (age <= 59) {
            System.out.println("Adult");
        } else {
            System.out.println("Senior");
        }

        sc.close();

    } // end of main method

} // end of BasicJavaActivity4 class