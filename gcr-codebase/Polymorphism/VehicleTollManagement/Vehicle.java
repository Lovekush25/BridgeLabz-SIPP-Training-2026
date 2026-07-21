package VehicleTollManagement;

public class Vehicle {
    String vehicleNumber;
    String ownerName;

    public Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public double calculateToll() {
        return 0;
    }
}