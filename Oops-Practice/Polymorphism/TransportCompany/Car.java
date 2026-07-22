class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double fuelCost(double km) {
        return km * 8;
    }
}