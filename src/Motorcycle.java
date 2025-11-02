/**
* Class: Motorcycle
* @author Ian Rodrigues Kmiliauskis (rodrigi@miamioh.edu)
* @version 1.0
* Course : CSE 201 Spring 2025
* Written: October 30, 2025
*
* Purpose: The Motorcycle class represents a specific type of 
* rentable Vehicle. 
* It inherits the base properties from Vehicle and adds the 
* engine displacement in cubic centimeters (CC). 
* This class implements a custom rental cost calculation
* where the rate is adjusted based on the engine size.
*/
public class Motorcycle extends Vehicle{
    // Private variable specific to the Motorcycle class
    private double engineCC;

    /**
     * Constructs a new Motorcycle object, initializing its base vehicle properties 
     * and the engine displacement.
     * @param licensePlate The unique license plate string for the motorcycle.
     * @param brand The brand name of the motorcycle.
     * @param dailyRate The base cost to rent the motorcycle per day.
     * @param engineCC The engine displacement in cubic centimeters (CC).
     */
    public Motorcycle(String licensePlate, String brand, 
                      double dailyRate, double engineCC) {
        super(licensePlate, brand, dailyRate);
        this.engineCC = engineCC;
    }
    
    /**
     * Calculates the total rental cost for the motorcycle, applying a surcharge
     * based on the engine size.
     * 
     * The total cost is calculated by multiplying the base rental cost by 
     * a factor of (1 + engineCC / 1000).
     * For example, a 500 CC engine adds a 50% surcharge (1 + 0.5).
     * 
     * @param days The number of days the motorcycle is rented for.
     * @return The total cost of the rental including the engine size surcharge.
     */
    @Override
    public double calculateRentalCost(int days) {
        return super.calculateRentalCost(days) * 
               (1 + engineCC / 1000);
    }

    /**
     * Generates a detailed information string for the motorcycle.
     * It extends the information provided by the Vehicle 
     * superclass by appending the engine displacement in CC.
     * @return A String containing the license plate, brand,   
     *         daily rate, and engine size.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + " | Engine: " + engineCC + " CC";
    }
}
