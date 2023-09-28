package carParking.models.vehicles;

import carParking.models.ParkingLot;
import carParking.models.parkingSpots.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected String color;
    protected String plateNumber;

    public abstract void park(ParkingLot parkingLot);

    public Vehicle(String color, String plateNumber) {
        this.color = color;
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void unpark() {
        for (ParkingSpot spot : parkingSpots) {
            spot.freeParkedVehicle();
        }
        this.parkingSpots = null;
        System.out.println("Successfully unparked");
    }

    protected List<ParkingSpot> parkingSpots = new ArrayList<>();
}
