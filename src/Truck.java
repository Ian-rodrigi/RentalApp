/**
* Class: Truck
* @author Ian Rodrigues Kmiliauskis (rodrigi@miamioh.edu)
* @version 1.0
* Course : CSE 201 Spring 2025
* Written: October 30, 2025
*
* Purpose: The Truck class represents a specific type of rentable Vehicle. 
* It inherits the base properties from Vehicle and adds the load 
* capacity (in tons). This class implements a custom rental cost
* calculation where the rate is adjusted by the truck's capacity, 
* reflecting higher costs for heavier-duty vehicles.
*/
public class Truck extends Vehicle{
    // Private variable specific to the Truck class
    private double loadCapacity;

    /**
     * Constructs a new Truck object, initializing its base 
     * vehicle properties and the maximum load capacity.
     * @param licensePlate The unique license plate string for the truck.
     * @param brand The manufacturer or brand name of the truck.
     * @param dailyRate The base cost to rent the truck per day.
     * @param loadCapacity The maximum load (in tons) the truck can carry.
     */
    public Truck(String licensePlate, String brand, double dailyRate, double loadCapacity) {
        super(licensePlate, brand, dailyRate);
        this.loadCapacity = loadCapacity;
    }

    /**
     * Calculates the total rental cost for the truck, applying a 
     * surcharge proportional to its load capacity.
     * 
     * The total cost is calculated by multiplying the base 
     * rental cost by a factor of (1 + loadCapacity). 
     * For example, a 1-ton truck doubles the cost (1 + 1).
     * 
     * @param days The number of days the truck is rented for.
     * @return The total cost of the rental including the load capacity surcharge.
     */
    @Override
    public double calculateRentalCost(int days) {
        return super.calculateRentalCost(days) * (1 + loadCapacity);
    }

    /**
     * Generates a detailed information string for the truck.
     * It extends the information provided by the  Vehicle 
     * superclass by appending the load capacity in tons.
     * @return A String containing the license plate, brand,
     *         daily rate, and load capacity.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + " | Load Capacity: " + loadCapacity + " Tons";
    }
}
