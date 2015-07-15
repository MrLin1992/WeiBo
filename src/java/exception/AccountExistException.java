package exception;

public class AccountExistException extends Exception {

    public AccountExistException() {
        
    }

    public AccountExistException(String msg) {
        super(msg);
    }

    public AccountExistException(Throwable cause) {
        super(cause);
    }

    public AccountExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
