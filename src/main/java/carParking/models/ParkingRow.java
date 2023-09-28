package carParking.models;

import carParking.models.parkingSpots.ParkingSpot;
import carParking.models.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingRow {

    private final List<ParkingSpot> row;

    public ParkingRow() {
        this.row = new ArrayList<>();
    }

    public List<ParkingSpot> getRow() {
        return row;
    }

    public void addSpotToRow(ParkingSpot spot) {
        row.add(spot);
    }

    public Vehicle findVehicle(String plateNumber, String color) {
        for (ParkingSpot spot : row) {
            if (!spot.isAvailable() && spot.getParkedVehicle().getPlateNumber().equals(plateNumber)
                    && spot.getParkedVehicle().getColor().equals(color)) {
                return spot.getParkedVehicle();
            }
        }
        return null;
    }
}
