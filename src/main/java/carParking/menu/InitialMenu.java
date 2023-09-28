package carParking.menu;


import carParking.exceptions.*;
import carParking.models.ParkingLot;
import carParking.models.vehicles.Bus;
import carParking.models.vehicles.Car;
import carParking.models.vehicles.Motorcycle;
import carParking.models.vehicles.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

public class InitialMenu {
    private Map<Integer, MenuItem> initialMenu = new LinkedHashMap<>();

    private final ParkingLot parkingLot;

    public InitialMenu(Scanner sc, ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        createMenu();
        showMenu(initialMenu);
        runMenu(initialMenu, sc);
    }

    public void createMenu() {
        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem("Park a vehicle", 1) {
            @Override
            public void run(Scanner sc) {
                try {
                    System.out.println("Please enter M for parking a motorcycle, C - for a car, B - for a bus");
                    sc.nextLine();
                    String vehicleType = sc.nextLine();
                    Validations.validateVehicleType(vehicleType);
                    System.out.println("Please enter vehicle plate number:");
                    String plateNumber = sc.nextLine();
                    Validations.validateVehicleNumber(plateNumber);
                    System.out.println("Please enter vehicle color:");
                    String color = sc.nextLine();
                    Vehicle vehicle = parkingLot.findVehicle(plateNumber, color);
                    if (vehicle != null) {
                        throw new VehicleIsAlreadyParkedException();
                    }
                    switch (vehicleType.toLowerCase().charAt(0)) {
                        case 'm' -> new Motorcycle(color, plateNumber).park(parkingLot);
                        case 'c' -> new Car(color, plateNumber).park(parkingLot);
                        case 'b' -> new Bus(color, plateNumber).park(parkingLot);
                    }
                } catch (InvalidVehicleTypeException | NumberIsNotValidException | VehicleIsAlreadyParkedException |
                         VehicleWasNotParkedException e) {
                    System.out.println(e.getMessage());
                }
                showMenu(initialMenu);
            }
        });

        items.add(new MenuItem("Unpark a vehicle", 2) {
            @Override
            public void run(Scanner sc) {
                try {
                    System.out.println("Please enter vehicle plate number:");
                    String plateNumber = sc.next();
                    Validations.validateVehicleNumber(plateNumber);
                    System.out.println("Please enter vehicle color:");
                    String color = sc.next();
                    Vehicle vehicle = parkingLot.findVehicle(plateNumber, color);
                    if (vehicle == null) {
                        throw new VehicleWasNotFoundException();
                    }
                    vehicle.unpark();
                } catch (VehicleIsAlreadyParkedException | NumberIsNotValidException | VehicleWasNotFoundException e) {
                    System.out.println(e.getMessage());
                }
                showMenu(initialMenu);
            }
        });

        items.add(new MenuItem("Exit", 0) {
            @Override
            public void run(Scanner sc) {
                System.exit(0);
            }
        });

        initialMenu = buildMap(items);
    }

    public LinkedHashMap<Integer, MenuItem> buildMap(List<MenuItem> items) {
        return items.stream()
                .collect(Collectors.toMap(i -> i.index, i -> i, (menuItem, menuItem2) -> menuItem, LinkedHashMap::new));
    }

    public void showMenu(Map<Integer, MenuItem> baseMenu) {
        for (MenuItem item : baseMenu.values()) {
            System.out.println(item.toString());
        }
        System.out.print(">");
    }

    public void runMenu(Map<Integer, MenuItem> baseMenu, Scanner sc) {
        int choice = sc.nextInt();
        while (choice != 0) {
            getMenuItemByChoice(baseMenu, choice).run(sc);
            choice = sc.nextInt();
        }
    }

    public MenuItem getMenuItemByChoice(Map<Integer, MenuItem> baseMenu, Integer choice) {
        return baseMenu.get(choice);
    }
}
