package carParking.models.parkingSpots;


import carParking.models.vehicles.Vehicle;

public class ParkingSpot {
    public ParkingSpot(SpotType spotType) {
        this.spotType = spotType;
    }

    private final SpotType spotType;

    public SpotType getSpotType() {
        return spotType;
    }

    private Vehicle parkedVehicle;

    public void freeParkedVehicle() {
        this.parkedVehicle = null;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void park(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

}
