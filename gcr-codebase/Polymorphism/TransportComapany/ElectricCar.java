public class ElectricCar extends Vehicle {

    public ElectricCar(String vehicleName) {
        super(vehicleName);
    }

    @Override
    public double fuelCost(int km) {
        return km * 2.0;
    }
}