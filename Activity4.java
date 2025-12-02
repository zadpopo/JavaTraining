package ph.com.bpi.hello;

import java.util.Scanner;

public class if_else {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        System.out.print("Enter your age: ");
        int age = input.nextInt(); 
        
        if (age < 18){
        	System.out.print("Minor");
        } else if (age >= 18 && age <= 59  ) {
        	System.out.print("Adult");
        } else {
        	System.out.print("Senior");
        }
        
        
        input.close();
    }
	
}
