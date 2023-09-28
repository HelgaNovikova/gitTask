package carParking.exceptions;

public class Validations {

    public static void validateVehicleNumber(String number) {
        if (!number.matches("^[a-zA-Z0-9]+$")) {
            throw new NumberIsNotValidException();
        }
    }

    public static void validateVehicleType(String type) {
        char typeC = type.trim().toLowerCase().charAt(0);
        if (type.trim().length() > 1 || !(typeC == 'm' || typeC == 'c' || typeC == 'b')) {
            throw new InvalidVehicleTypeException();
        }
    }
}
