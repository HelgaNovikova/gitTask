package carParking.models.vehicles;


import carParking.exceptions.VehicleWasNotParkedException;
import carParking.models.ParkingFloor;
import carParking.models.ParkingLot;
import carParking.models.ParkingRow;
import carParking.models.parkingSpots.ParkingSpot;

import java.util.List;

public class Motorcycle extends Vehicle {

    public Motorcycle(String color, String plateNumber) {
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
                    if (spot.isAvailable()) {
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
