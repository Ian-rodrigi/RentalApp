/**
* Class: Rental
* @author Ian Rodrigues Kmiliauskis (rodrigi@miamioh.edu)
* @version 1.0
* Course : CSE 201 Spring 2025
* Written: October 30, 2025
*
* Purpose: The Rental class represents a single transaction for renting a vehicle.
* It holds references to one Customer and one Vehicle,
* along with the duration of the rental. 
* Its primary responsibilities are to calculate 
* the total cost and to generate the final invoice.
*/
public class Rental {
    // Private fields representing the Aggregation relationship (Rental has a Customer and a Vehicle)
    private Customer customer;
    private Vehicle vehicle;
    private int days;

    /**
     * Constructs a new Rental transaction.
     * @param customer The Customer object who is renting the vehicle.
     * @param vehicle The specific Vehicle object being rented.
     * @param days The number of days for the rental duration.
     */
    public Rental(Customer customer, Vehicle vehicle, int days) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.days = days;
    }

    /**
     * Calculates the total cost of the rental transaction.
     * This method calls the specific Vehicle object 
     * (Car, Truck, or Motorcycle), ensuring any 
     * subclass-specific surcharges are included.
     * @return The final total cost (double) for the entire rental period.
     */
    public double getTotalCost() {
        return vehicle.calculateRentalCost(days);
    }

    /**
     * Prints a full, formatted invoice to the console.
     * The invoice includes customer details, vehicle 
     * information (using getInfo()), the rental summary,
     * and the final calculated total cost.
     */
    public void printInvoice() {
        System.out.println("RENTAL INVOICE:");

        // Customer Information
        System.out.println("CUSTOMER INFO:");
        System.out.println("  Name:    " + customer.getName());
        System.out.println("  License: " + customer.getDriverLicense());

        System.out.println("---------------------------------------------");
        
        // Vehicle Information
        System.out.println("VEHICLE RENTED:");
        System.out.println("  Type:    " + vehicle.getClass().getSimpleName());
        System.out.println("  Details: " + vehicle.getInfo());
        
        System.out.println("---------------------------------------------");
        
        // Cost Summary
        System.out.println("RENTAL SUMMARY:");
        System.out.println("  Rate per Day:  " + vehicle.getDailyRate());
        System.out.println("  Rental Days:   " + days);
        System.out.println("  ---------------------------------");
        System.out.println("  TOTAL COST:    " + getTotalCost());
        System.out.println("=============================================");
    }
}
