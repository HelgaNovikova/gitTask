package carParking.models.vehicles;

import carParking.exceptions.VehicleWasNotParkedException;
import carParking.models.ParkingFloor;
import carParking.models.ParkingLot;
import carParking.models.ParkingRow;
import carParking.models.parkingSpots.ParkingSpot;
import carParking.models.parkingSpots.SpotType;

import java.util.List;

public class Bus extends Vehicle {

    private final int NECESSARY_SPOTS_AMOUNT = 5;

    public Bus(String color, String plateNumber) {
        super(color, plateNumber);
    }

    @Override
    public void park(ParkingLot parkingLot) {
        List<ParkingFloor> floorList = parkingLot.getFloors();
        for (ParkingFloor floor : floorList) {
            List<ParkingRow> rows = floor.getFloor();
            for (ParkingRow row : rows) {
                List<ParkingSpot> spots = row.getRow();
                for (int i = 0; i < spots.size(); i++) {
                    if (spots.get(i).getSpotType() == SpotType.LARGE
                            && spots.get(i).isAvailable()
                            && i <= spots.size() - NECESSARY_SPOTS_AMOUNT - 1) {
                        boolean canPark = true;
                        for (int j = i; j < i + NECESSARY_SPOTS_AMOUNT; j++) {
                            if (!spots.get(j).isAvailable()
                                    || spots.get(j).getSpotType() != SpotType.LARGE) {
                                canPark = false;
                                break;
                            }
                        }
                        if (canPark) {
                            for (int j = i; j < i + NECESSARY_SPOTS_AMOUNT; j++) {
                                spots.get(j).park(this);
                                this.parkingSpots.add(spots.get(j));
                            }
                            System.out.println("Successfully parked");
                            return;
                        }
                    }
                }
            }
        }
        throw new VehicleWasNotParkedException();
    }

}
