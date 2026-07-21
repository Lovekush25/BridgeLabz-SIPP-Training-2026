public class Vehicle {

    protected String vehicleName;

    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public double fuelCost(int km) {
        return 0;
    }

    public void displayDetails() {
        System.out.println("Vehicle : " + vehicleName);
    }
}