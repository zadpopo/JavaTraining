package m4lesson;


public class ATMTransaction {

    public static void checkBalance(String accountNumber, double balance) {
        try {
            System.out.println("Processing balance inquiry...");

            Integer.parseInt(accountNumber);

            char accountType = accountNumber.charAt(0);
            if (accountType == '1') {
                System.out.println("Account Type: Savings");
            } else if (accountType == '2') {
                System.out.println("Account Type: Checking");
            } else {
                System.out.println("Account Type: Unknown");
            }

            System.out.println("Account Number: " + accountNumber);
            System.out.println("Current Balance: ₱" + balance);
            System.out.println("Balance inquiry successful!");

        } catch (NumberFormatException e) {
            // Invalid account number format (non-numeric)
            System.out.println("Error: Invalid account number format! Account numbers must be numeric.");
        } catch (StringIndexOutOfBoundsException e) {
            // Empty or invalid string (no first character)
            System.out.println("Error: Invalid account number format! Account numbers must be numeric.");
        } finally {
            // Always print the receipt
            System.out.println("\n========== RECEIPT ==========");
            System.out.println("Transaction Date: December 3, 2025");
            System.out.println("Transaction Type: Balance Inquiry");
            System.out.println("ATM Location: Main Branch");
            System.out.println("Thank you for banking with us!");
            System.out.println("==============================\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ATM BALANCE INQUIRY SYSTEM ===\n");

        // Test Case 1: Valid Savings Account
        System.out.println("--- Test Case 1: Valid Savings Account ---");
        checkBalance("100123456", 15000.00);

        // Test Case 2: Valid Checking Account
        System.out.println("--- Test Case 2: Valid Checking Account ---");
        checkBalance("200987654", 25000.00);

        // Test Case 3: Invalid Account Number Format
        System.out.println("--- Test Case 3: Invalid Account Number Format ---");
        checkBalance("ABC12345", 15000.00);

        // Test Case 4: Empty Account Number
        System.out.println("--- Test Case 4: Empty Account Number ---");
        checkBalance("", 15000.00);
    }
}
