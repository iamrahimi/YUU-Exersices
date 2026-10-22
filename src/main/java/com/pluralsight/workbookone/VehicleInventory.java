package com.pluralsight.workbookone;

import java.util.Scanner;

public class VehicleInventory {
    public static  Vehicle[] vehicle = new Vehicle[20];
    public static Scanner input = new Scanner(System.in);
    public static int vehicleCounter = 6;
    public static void main(String[] args) {


        // Preload the array with six vehicles.
        vehicle[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500.00);
        vehicle[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000.00);
        vehicle[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700.00);
        vehicle[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500.00);
        vehicle[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500.00);
        vehicle[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000.00);

        start();
    }

    public static void start() {
        System.out.println("What do you want to do?");
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by make/model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");
        System.out.println("Enter your command: ");

        switch(input.nextInt()) {
            case 1:
                listAllVehicles();
                break;
            case 2:
                findVehiclesByMakeModel();
                break;
            case 3:
                findVehiclesByPriceRange();
                break;

            case 4:
                findVehiclesByColor();
                break;
            case 5:
                addVehicule();
                break;
            case 6:
                System.out.println("Thank you for using the vehicle inventory application");
                break;

            default:
                System.out.println("Invalid input");

        }
    }

    public static void addVehicule(){
        input.nextLine();
        System.out.println("Please enter your vehicul ID: ");
        long vehicleId = input.nextLong(); input.nextLine();
        System.out.println("Please enter your make/Model: ");
        String makeModel = input.nextLine();
        System.out.println("Please enter your color: ");
        String color = input.nextLine();
        System.out.println("Please enter your odometer reading: ");
        int odometerReading = input.nextInt(); input.nextLine();
        System.out.println("Please enter your price: ");
        double price = input.nextDouble(); input.nextLine();

        vehicleCounter +=1;
        vehicle[vehicleCounter] = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
        listAllVehicles();

    }


    public static void listAllVehicles() {

        tableHeader(); // Only display the header for the table.
        for (int i = 0; i<vehicle.length; i++) {
            if(vehicle[i] != null) {
                viewVehicle(vehicle[i]);
            }

        }
        tableFooter();
        start();
    }

    public static void findVehiclesByMakeModel() {
        String makeModel;
        System.out.println("Please enter the make model: ");
//        input.nextLine();
        makeModel = input.nextLine().trim();
        tableHeader();
        for(int i = 0; i<vehicle.length; i++) {
            if(vehicle[i] != null) {
                if(vehicle[i].getMakeModel().equalsIgnoreCase(makeModel)) {
                    viewVehicle(vehicle[i]);
                }
            }

        }
        tableFooter();

        start();

    }

    public static void findVehiclesByPriceRange() {
        double minPriceRange;
        double maxPriceRange;
        System.out.println("Please enter the minimum price range: ");
//        input.nextLine();
        minPriceRange = input.nextDouble();
        System.out.println("Please enter the maximum price range: ");
        maxPriceRange = input.nextDouble();
        tableHeader();
        for(int i = 0; i<vehicle.length; i++) {
            if(vehicle[i] != null) {
                if(vehicle[i].getPrice() >= minPriceRange && vehicle[i].getPrice() <= maxPriceRange) {
                    viewVehicle(vehicle[i]);
                }
            }

        }
        tableFooter();
        start();
    }

    public static void findVehiclesByColor() {
        String searchKeyword;
        System.out.println("Please enter the color: ");
        input.nextLine();
        searchKeyword = input.nextLine().trim();
        tableHeader();
        for(int i = 0; i<vehicle.length; i++) {
            if(vehicle[i] != null) {
                if(vehicle[i].getColor().equalsIgnoreCase(searchKeyword)) {
                    viewVehicle(vehicle[i]);
                }
            }

        }
        tableFooter();

        start();
    }

    public static void tableHeader () {
        System.out.println();
        System.out.println("========= CAR INVENTORY");
        System.out.println("--------------------------------------------------------------------------");

        System.out.printf(
                "%-10s %-22s %-12s %12s %12s%n",
                "ID", "Make/Model", "Color", "Mileage", "Price"
        );

        System.out.println("--------------------------------------------------------------------------");
    }

    public static void tableFooter () {
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void viewVehicle(Vehicle vehicle) {
        System.out.printf(
                "%-10d %-22s %-12s %,12d $%,11.2f%n",
                vehicle.getVehicleId(),
                vehicle.getMakeModel(),
                vehicle.getColor(),
                vehicle.getOdometerReading(),
                vehicle.getPrice()
        );
    }
}
