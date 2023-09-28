package carParking.exceptions;

public class VehicleWasNotParkedException extends RuntimeException {
    public VehicleWasNotParkedException() {
        super("This vehicle was not parked");
    }
}
