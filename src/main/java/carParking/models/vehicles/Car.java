package carParking.models.vehicles;


import carParking.exceptions.VehicleWasNotParkedException;
import carParking.models.ParkingFloor;
import carParking.models.ParkingLot;
import carParking.models.ParkingRow;
import carParking.models.parkingSpots.ParkingSpot;
import carParking.models.parkingSpots.SpotType;

import java.util.List;

public class Car extends Vehicle {

    public Car(String color, String plateNumber) {
        super(color, plateNumber);
    }

    @Override
    public void park(ParkingLot parkingLot) {
        List<ParkingFloor> floorList = parkingLot.getFloors();
        for (ParkingFloor floor : floorList) {
            List<ParkingRow> rows = floor.getFloor();
            for (ParkingRow row : rows) {
                List<ParkingSpot> spots = row.getRow();
                for (ParkingSpot spot : spots) {
                    if (spot.getSpotType() != SpotType.MOTORCYCLE && spot.isAvailable()) {
                        spot.park(this);
                        this.parkingSpots.add(spot);
                        System.out.println("Successfully parked");
                        return;
                    }
                }
            }
        }
        throw new VehicleWasNotParkedException();
    }
}
