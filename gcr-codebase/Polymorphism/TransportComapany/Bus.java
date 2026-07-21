public class Bus extends Vehicle {

    public Bus(String vehicleName) {
        super(vehicleName);
    }

    @Override
    public double fuelCost(int km) {
        return km * 15.0;
    }
}