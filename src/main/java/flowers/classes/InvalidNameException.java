package src.main.java.flowers.classes;

public class InvalidNameException extends Exception {
	public InvalidNameException() {
	}
	public InvalidNameException(String message, Throwable cause) {
		super(message, cause);
	}
	public InvalidNameException(String message) {
		super(message);
	}
	public InvalidNameException(Throwable cause) {
		super(cause);
	}
}