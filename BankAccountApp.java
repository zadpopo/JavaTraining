package m4lesson;


public class BankAccountApp {

    static class BankAccount {

        public String getAccountName(String accountNumber) {
            if ("ACC-001".equals(accountNumber)) {
                return "Juan Dela Cruz";
            } else if ("ACC-002".equals(accountNumber)) {
                return "Maria Santos";
            } else {
                // Not found
                return null;
            }
        }
    }

    // Reusable test method with exception handling
    public static void testCase(String accountNumber) {
        System.out.println("Looking up account: " + accountNumber);
        BankAccount service = new BankAccount();

        try {
            String name = service.getAccountName(accountNumber);
            String upper = name.toUpperCase();         
            System.out.println("Account holder: " + upper);
        } catch (NullPointerException e) {
            System.out.println("Error: Account not found!");
        }
        System.out.println(); 
    }

    //  Main method that runs two scenarios
    public static void main(String[] args) {
        System.out.println("=== Bank Account Name Display ===\n");
        testCase("ACC-001");

        testCase("ACC-999");
        System.out.println("=== Program completed successfully! ===");
    }
}
