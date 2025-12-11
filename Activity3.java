package ph.com.bpi.hello;
import java.util.Scanner;
public class activity3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 

        System.out.print("Enter First interger: ");
        int firstInt = input.nextInt(); 
        
        System.out.print("Enter Second interger: ");
        int SecondInt = input.nextInt();         
     
        int sum  = firstInt + SecondInt; 
        int sub  = firstInt - SecondInt;
        int pro  = firstInt * SecondInt;
        
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + sub);
        System.out.println("Product: " + pro );
        input.close();
    }
	
	
	
	
	
}
