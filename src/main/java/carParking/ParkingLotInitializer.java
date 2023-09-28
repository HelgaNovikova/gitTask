package carParking;


import carParking.models.ParkingFloor;
import carParking.models.ParkingLot;
import carParking.models.ParkingRow;
import carParking.models.parkingSpots.ParkingSpot;
import carParking.models.parkingSpots.SpotType;

public class ParkingLotInitializer {
    private final int AMOUNT_OF_FLOORS = 5;
    private final int AMOUNT_OF_ROWS = 2;
    private ParkingLot parkingLot;

    public ParkingLot buildParkingLot() {
        int j = 0;
        parkingLot = new ParkingLot();
        do {
            ParkingFloor parkingFloor = new ParkingFloor();
            int i = 0;
            do {
                ParkingRow parkingRow = new ParkingRow();
                fillRow(parkingRow);
                parkingFloor.addRowToFloor(parkingRow);
                i++;
            } while (i < AMOUNT_OF_ROWS);
            parkingLot.addFloor(parkingFloor);
            j++;
        } while (j < AMOUNT_OF_FLOORS);
        return parkingLot;
    }

    private void fillRow(ParkingRow parkingRow) {
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.MOTORCYCLE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.LARGE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.MOTORCYCLE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.MOTORCYCLE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.MOTORCYCLE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.LARGE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.LARGE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.LARGE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.LARGE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.LARGE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.LARGE));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
        parkingRow.addSpotToRow(new ParkingSpot(SpotType.COMPACT));
    }
}
