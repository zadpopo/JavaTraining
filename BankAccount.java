package m4lesson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// ----- Custom Exceptions -----
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) { super(message); }
}

class InsufficientFundsException extends Exception {
    private final double balance;
    private final double requestedAmount;

    public InsufficientFundsException(String message, double balance, double requestedAmount) {
        super(message);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }

    public double getBalance() { return balance; }
    public double getRequestedAmount() { return requestedAmount; }
}

// ----- Functional Interface -----
interface BankTestOperation {
    void execute() throws InvalidAmountException, InsufficientFundsException;
}

public class BankAccount {
    private static final Logger logger = LoggerFactory.getLogger(BankAccount.class);

    
    // Initial balance
    private double balance = 10_000.0;

    // ----- Withdraw -----
    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        logger.info("Withdrawal requested: ₱{}", amount);

        if (amount < 0) {
            logger.error("Invalid withdrawal amount: ₱{}", amount);
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }

        if (amount > balance) {
            logger.warn("Insufficient funds: ₱{} available", balance);
            throw new InsufficientFundsException("Insufficient funds for withdrawal", balance, amount);
        }

        balance -= amount;
        logger.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance);
    }

    // ----- Deposit -----
    public void deposit(double amount) throws InvalidAmountException {
        logger.info("Deposit requested: ₱{}", amount);

        if (amount <= 0) {
            logger.error("Invalid deposit amount: ₱{}", amount);
            throw new InvalidAmountException("Deposit amount must be positive");
        }

        if (amount > 50_000) {
            // Warn but continue
            logger.warn("Large deposit: ₱{} - requires verification", amount);
        }

        balance += amount;
        logger.info("Deposit completed: ₱{}, New balance: ₱{}", amount, balance);
    }

    // ----- Helper test runner -----
    public static void runTest(BankTestOperation operation, String operationName) {
        try {
            operation.execute();
        } catch (InvalidAmountException e) {
            logger.error(operationName + " failed: " + e.getMessage(), e);
        } catch (InsufficientFundsException e) {
            logger.error(operationName + " failed: " + e.getMessage(), e);
        }
    }

  
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        //Deposit 5000  success
        runTest(() -> account.deposit(5000), "Deposit");

        //Withdraw 3000  success
        runTest(() -> account.withdraw(3000), "Withdrawal");

        //Deposit -500  InvalidAmountException
        runTest(() -> account.deposit(-500), "Deposit");

        //Withdraw 20000  InsufficientFundsException
        runTest(() -> account.withdraw(20000), "Withdrawal");

        //Deposit 60000  WARN then success
        runTest(() -> account.deposit(60000), "Deposit");
    }
}

