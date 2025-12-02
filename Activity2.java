
package ph.com.bpi.hello;

import java.util.Scanner;

public class HelloMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        System.out.print("Enter your age: ");
        String age = sc.nextLine(); 
        
        int intAge = Integer.parseInt(age);
        double doubleAge = Double.parseDouble(age);
        
        System.out.println("Your age as int: " + intAge);
        System.out.println("Your age as double: " + doubleAge);
        
        sc.close();
    }
}
