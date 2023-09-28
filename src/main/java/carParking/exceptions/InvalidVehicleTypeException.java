package carParking.exceptions;

public class InvalidVehicleTypeException extends RuntimeException {
    public InvalidVehicleTypeException() {
        super("This vehicle type cannot be parked here");
    }
}
