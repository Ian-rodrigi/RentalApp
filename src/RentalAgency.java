import java.util.ArrayList;
import java.util.Scanner;

/**
* Class: RentalAgency
* @author Ian Rodrigues Kmiliauskis (rodrigi@miamioh.edu)
* @version 1.0
* Course : CSE 201 Spring 2025
* Written: October 30, 2025
*
* Purpose: The RentalAgency class acts as the main application container 
* and business logic manager. It handles vehicle inventory management, 
* user input for rentals, and maintains a list of completed or ongoing 
* Rental transactions. It contains the application's entry point (main method).
*/
public class RentalAgency {
    /**
     * Gathers customer identifying information from the user via the console.
     * @param userInput The Scanner object used for reading input.
     * @return A newly created Customer object.
     */
    private static Customer getCustomerInfo(Scanner userInput) {
        System.out.print("Enter your Name: ");
        String name = userInput.nextLine();
        System.out.print("Enter your Driver's License ID (e.g., A123B456): ");
        String license = userInput.nextLine();
        System.out.println();
        return new Customer(name, license);
    }

    // Aggregation: Static list to hold all available vehicles in the inventory
    private static ArrayList<Vehicle> vehicles = new ArrayList<>();

    /**
     * Initializes the available vehicle inventory by creating concrete 
     * instances of Car, Truck, and Motorcycle and 
     * adding them to the static list.
     * This method fulfills the project requirement to create at least 
     * one of each vehicle type.
     */
    private static void setupInventory() {
        // At least one of each: Car, Truck, Motorcycle
        vehicles.add(new Car("ABC 1234",
                    "BMW", 45.00, 2));
        vehicles.add(new Car("XYZ 9876",
                    "Mercedes", 40.00, 5));
        vehicles.add(new Truck("QWE 5678",
                    "Ford", 80.00, 2.5));
        vehicles.add(new Truck("RTY 1111", 
                    "Chevrolet", 75.00, 1.5));
        vehicles.add(new Motorcycle("FGH 2468", 
                    "Ducati", 30.00, 900.0));
        vehicles.add(new Motorcycle("JKL 0001", 
                    "Harley", 25.00, 750.0));
    }

    /**
     * Prints the list of all available vehicles to the console for the user to choose from.
     * It uses polymorphism by calling the specific getInfo() method of each vehicle subclass.
     */
    private static void printAllVehicles() {
        for (int i = 1; i < vehicles.size() + 1; i++) {
            System.out.println(i + ". Type: " + 
            vehicles.get(i - 1).getClass().getSimpleName());
            System.out.println("   Details: " + vehicles.get(i - 1).getInfo());
        }
        System.out.println();
    }

    /**
     * Prompts the user to select a vehicle by its displayed number (1-based index).
     * @param userInput The Scanner object used for reading input.
     * @return The selected {@link Vehicle} object.
     */
    private static Vehicle findVehicle(Scanner userInput) {
        System.out.print("Choose the number of your vehicle: ");
        int vehicleIndex = userInput.nextInt();
        while (vehicleIndex > vehicles.size() || vehicleIndex <= 0) {
            System.out.println("Invalid number for vehicle. Try again!");
            System.out.print("Choose the number of your vehicle: ");
            vehicleIndex = userInput.nextInt();
        }
        return vehicles.get(vehicleIndex - 1);
    }

    /**
     * Prompts the user for the number of days for the rental.
     * This implementation should handle negative/zero input.
     * @param scanner The Scanner object used for reading input.
     * @return The valid number of rental days (integer > 0).
     */
    private static int getRentalDays(Scanner scanner) {
        System.out.print("Enter the number of rental days: ");
        int days = scanner.nextInt();

        while (days <= 0) {
            System.out.println("Rental must be for at least one day. Try again.");
            days = scanner.nextInt();
        }
        System.out.println();
        return days;
    }

    /**
     * The main entry point for the Rental Agency application.
     * It drives the entire program flow: setup, user input, transaction, and invoicing.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create at least one car, truck, and motorcycle choice
        setupInventory();

        // Prompt user for name, driver license info
        Scanner userInput = new Scanner(System.in);
        Customer customer = getCustomerInfo(userInput);

        // Show the user a list of available vehicles 
        // and allow the user to choose one
        printAllVehicles();

        //Find the vehicle in the list
        Vehicle vehicle = findVehicle(userInput);

        // Allow the user to enter how many days they want the rental for
        int rentalDays = getRentalDays(userInput);

        // Create a rental for the vehicle
        Rental rental = new Rental(customer, vehicle, rentalDays);

        // Close scanner
        userInput.close();

        // Calculate the costs
        rental.getTotalCost();
        
        // Print an invoice to the screen.
        rental.printInvoice();
    } 
}
