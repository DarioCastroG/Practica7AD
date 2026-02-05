package es.transportesamartin.exception;

public class OwnershipException extends RuntimeException {
    public OwnershipException(String message) {
        super(message);
    }

    public OwnershipException(String message, Throwable cause) {
        super(message, cause);
    }
}
