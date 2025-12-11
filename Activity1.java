package ph.com.bpi.hello;

import java.util.Scanner;

public class act1 {

	
    public static void main(String[] args) {
    	
    	
        Scanner sc = new Scanner(System.in); 

        System.out.print("What is your name? ");
        String name = sc.nextLine();
        
        System.out.println("Hello, " + name + "!");

        sc.close();
    }
	
	
	
	
	
}
