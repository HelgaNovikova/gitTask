package carParking.models;

import carParking.models.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private final List<ParkingRow> floor;

    public ParkingFloor() {
        this.floor = new ArrayList<>();
    }

    public List<ParkingRow> getFloor() {
        return floor;
    }

    public void addRowToFloor(ParkingRow row) {
        floor.add(row);
    }

    public Vehicle findVehicle(String plateNumber, String color) {
        for (ParkingRow row : floor) {
            return row.findVehicle(plateNumber, color);
        }
        return null;
    }
}
