/**
* Class: Car
* @author Ian Rodrigues Kmiliauskis (rodrigi@miamioh.edu)
* @version 1.0
* Course : CSE 201 Spring 2025
* Written: October 30, 2025
*
* Purpose: The Car class represents a specific type of Vehicle. 
* It inherits the base attributes and methods from Vehicle and
* adds attributes specific to cars, such as the number of seats. 
* It overrides  methods like getInfo() to include number of seats.
*/
public class Car extends Vehicle{
    // Private variable specific to the Car class
    private int seats;

    /**
     * Constructs a new Car object, initializing its 
     * base vehicle properties and the number of seats.
     * @param licensePlate The unique license plate for the car.
     * @param brand The brand name of the car.
     * @param dailyRate The base cost to rent the car per day.
     * @param seats The number of seats the car has.
     */
    public Car(String licensePlate, String brand,
               double dailyRate, int seats) {
        super(licensePlate, brand, dailyRate);
        this.seats = seats;
    }

    /**
     * Calculates the total rental cost for the car for a 
     * specified number of days.
     *
     * Note: Currently, this method simply calls the superclass 
     * implementation, but it is included as an override 
     * placeholder to allow for car-specific rental logic 
     * (e.g., premium surcharge) to be added later.
     * 
     * @param days The number of days the car is rented for.
     * @return The total cost of the rental for a car.
     */
    @Override
    public double calculateRentalCost(int days) {
        return super.calculateRentalCost(days) * (1 + seats / 10);
    }

    /**
     * Generates a detailed information string for the car.
     * It extends the information provided by the Vehicle
     * superclass by appending the number of seats.
     *  @return A String with the license plate, brand, 
     *          daily rate, and number of seats.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + " | Seats: " + seats;
    }
}
