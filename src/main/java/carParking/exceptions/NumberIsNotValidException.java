package carParking.exceptions;

public class NumberIsNotValidException extends RuntimeException {

    public NumberIsNotValidException() {
        super("Entered number is not valid");
    }
}
