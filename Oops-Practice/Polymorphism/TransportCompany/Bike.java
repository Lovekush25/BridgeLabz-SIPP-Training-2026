class Bike extends Vehicle {

    public Bike(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double fuelCost(double km) {
        return km * 3;
    }
}