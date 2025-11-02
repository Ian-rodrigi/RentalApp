/**
* Class: Vehicle
* @author Ian Rodrigues Kmiliauskis (rodrigi@miamioh.edu)
* @version 1.0
* Course : CSE 201 Spring 2025
* Written: October 30, 2025
*
* Purpose: The Vehicle class serves as the superclass (base class)
* for all rentable vehicles in the agency 
* (Car, Truck, Motorcycle). 
* It holds the basic identifying information and rental rate
* common to all vehicle types. 
* It provides core methods for retrieving information 
* and calculating base rental costs.
*/
public class Vehicle {
    // Declaring private variables for the class    
    private String licensePlate;
    private String brand;
    private double dailyRate;

    /**
     * Constructs a new Vehicle object.
     * @param licensePlate The unique license plate the vehicle.
     * @param brand The brand name of the vehicle.
     * @param dailyRate The base cost to rent the vehicle per day.
     */
    public Vehicle(String licensePlate, String brand, 
                   double dailyRate) {
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.dailyRate = dailyRate;
    }

    /**
     * Retrieves the daily rental rate for this vehicle.
     * @return The cost (double) to rent the vehicle for one day.
     */
    public double getDailyRate() {
        return dailyRate;
    }

    /**
     * Calculates the total base cost of renting the vehicle for 
     * a specified number of days.
     * @param days The number of days the vehicle is rented for.
     * @return The total base cost (dailyRate * days).
     */
    public double calculateRentalCost(int days) {
        return days * dailyRate;
    }

    /**
     * Generates a simple string with the vehicle's info.
     * This method is used to display the vehicle to a customer 
     * list or on an invoice.
     * @return A String with license plate, brand, and daily rate.
     */
    public String getInfo() {
        return "LicensePlate: " + licensePlate + " | Brand: " + 
                brand + " | Daily Rate: " + dailyRate;
    }
}
