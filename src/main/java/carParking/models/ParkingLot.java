package carParking.models;


import carParking.models.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private final List<ParkingFloor> floors;

    public ParkingLot() {
        this.floors = new ArrayList<>();
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public Vehicle findVehicle(String plateNumber, String color) {
        for (ParkingFloor floor : floors) {
            return floor.findVehicle(plateNumber, color);
        }
        return null;
    }

}
