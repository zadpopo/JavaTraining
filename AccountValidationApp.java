package m4lesson;

public class AccountValidationApp {

 // Checked exception for "length must be exactly 10 digits"
 public static class InvalidAccountNumberException extends Exception {
     public InvalidAccountNumberException(String message) {
         super(message);
     }
 }

 // Unchecked exception for "contains non-digits"
 public static class InvalidAccountFormatException extends RuntimeException {
     public InvalidAccountFormatException(String message) {
         super(message);
     }
 }

 public static class AccountValidator {
     public void validateAccountNumber(String accountNumber)
             throws InvalidAccountNumberException {

         // Check for null
         if (accountNumber == null) {
             throw new NullPointerException("Account number cannot be null");
         }

         // Check for non-digits
         for (char c : accountNumber.toCharArray()) {
             if (!Character.isDigit(c)) {
                 throw new InvalidAccountFormatException("Account number must contain only digits");
             }
         }

         // Check length
         if (accountNumber.length() != 10) {
             throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
         }

         // If all checks pass
         System.out.println("Valid account number: " + accountNumber);
     }
 }

 private static void testValidation(String testName, String accountNumber) {
     System.out.println(testName);
     AccountValidator validator = new AccountValidator();
     try {
         validator.validateAccountNumber(accountNumber);
     } catch (InvalidAccountNumberException e) {
         // Checked: length error
         System.out.println("Error: " + e.getMessage());
     } catch (InvalidAccountFormatException e) {
         // Unchecked: format error 
         System.out.println("Warning: " + e.getMessage());
     } catch (NullPointerException e) {
         // Null
         System.out.println("Warning: " + e.getMessage());
     }
     System.out.println(); 

 public static void main(String[] args) {
     System.out.println("=== Account Number Validation Test ===\n");

     // 1. Valid (10 digits)
     testValidation("Test 1: Valid account (1234567890)", "1234567890");

     // 2. Too short
     testValidation("Test 2: Too short (123)", "123");

     // 3. Contains letters
     testValidation("Test 3: Contains letters (12345ABC90)", "12345ABC90");

     // 4. Contains space
     testValidation("Test 4: Contains space (1234 567890)", "1234 567890");

     // 5. Null
     testValidation("Test 5: Null value", null);
 }
}
