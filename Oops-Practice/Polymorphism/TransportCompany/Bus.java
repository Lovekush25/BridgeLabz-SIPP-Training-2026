class Bus extends Vehicle {

    public Bus(String vehicleNumber) {
        super(vehicleNumber);
    }

    @Override
    public double fuelCost(double km) {
        return km * 20;
    }
}