package m4lesson;

public class ATMSystem {
    private static final double[] INITIAL_ACCOUNTS = {10000, 15000, 20000};


    public static void processWithdrawal(String accountIndex, String amountInput) {
        try {
            int index = Integer.parseInt(accountIndex);      
            double amount = Double.parseDouble(amountInput); 

            double balance = INITIAL_ACCOUNTS[index];


            System.out.printf("Current balance: ₱%.2f%n", balance);
            System.out.printf("Withdrawal: ₱%.2f%n", amount);

            if (amount > balance) {
                System.out.printf("Insufficient funds! Cannot withdraw ₱%.2f%n", amount);
            } else {
                double newBalance = balance - amount; 
                System.out.printf("New balance: ₱%.2f%n", newBalance);
                System.out.println("Withdrawal successful!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input! Please enter valid numbers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Account not found! Invalid account index.");
        } catch (Exception e) {
            System.out.println("Error: Transaction failed");
        }

        System.out.println(); 
    }

    public static void main(String[] args) {
        System.out.println("=== ATM Withdrawal System ===\n");

        // --- Test 1: Valid Withdrawal ---
        System.out.println("--- Test 1: Valid Withdrawal ---");
        System.out.println("Account=1, Amount=5000");
        processWithdrawal("1", "5000");

        // --- Test 2: Invalid Account Index ---
        System.out.println("--- Test 2: Invalid Account Index ---");
        System.out.println("Account=abc, Amount=5000");
        processWithdrawal("abc", "5000");

        // --- Test 3: Account Not Found ---
        System.out.println("--- Test 3: Account Not Found ---");
        System.out.println("Account=10, Amount=5000");
        processWithdrawal("10", "5000");

        // --- Test 4: Insufficient Funds ---
        System.out.println("--- Test 4: Insufficient Funds ---");
        System.out.println("Account=1, Amount=20000");
        processWithdrawal("1", "20000");

        System.out.println("=== All tests completed! ===");
    }
}

