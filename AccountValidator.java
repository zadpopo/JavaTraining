package m4lesson;

public class AccountValidator {
    public static void validateAccountNumber(String accountNumber) throws Exception {
        if (accountNumber == null) {
            throw new NullPointerException("Cannot be null");
        }
        if (accountNumber.length() != 10) {
            throw new Exception("Must be 10 digits");
        }

        // If all checks pass
        System.out.println("Valid account: " + accountNumber);
    }
    public static void main(String[] args) {
        // Test cases 
        String[] tests = {
            "1234567890", // valid
            "123",        // too short
            null          // null
        };

        for (String test : tests) {
            try {
                validateAccountNumber(test);
            } catch (NullPointerException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

