package carParking.exceptions;

public class VehicleWasNotFoundException extends RuntimeException {
    public VehicleWasNotFoundException() {
        super("This vehicle was not found on this parking");
    }
}
