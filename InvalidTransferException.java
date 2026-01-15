package M4Act9;

public class InvalidTransferException extends Exception {
	
    public InvalidTransferException(String message) {
        super(message);
    }
    
    public InvalidTransferException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
