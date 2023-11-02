package Test.exceptions;

public class TextException extends RuntimeException{
    public TextException() {
    }

    public TextException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextException(Throwable cause) {
        super(cause);
    }

    public TextException(String message) {
        super(message);
    }
}
