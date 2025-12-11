package ph.com.bpi.hello;

import java.util.Scanner;

public class act5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        int sum = 0;
        
        for (int i = 1; i <=50; i++) {
        	sum += i;
        }
        System.out.println("Sum = " + sum);
        input.close();
    }
		

	
}