public class Car extends Vehicle {

    public Car(String vehicleName) {
        super(vehicleName);
    }

    @Override
    public double fuelCost(int km) {
        return km * 7.5;
    }
}