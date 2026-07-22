class ElectricCar extends Vehicle {

    public ElectricCar(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double fuelCost(double km) {
        return km * 2;
    }
}