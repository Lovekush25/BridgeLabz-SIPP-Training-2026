abstract class Vehicle {

    protected String vehicleNumber;

    public Vehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public abstract double fuelCost(double km);
}