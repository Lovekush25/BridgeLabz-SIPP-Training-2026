public class Bike extends Vehicle {

    public Bike(String vehicleName) {
        super(vehicleName);
    }

    @Override
    public double fuelCost(int km) {
        return km * 3.0;
    }
}