package VehicleTollManagement;

public class Truck extends Vehicle {

    public Truck(String v, String o) {
        super(v, o);
    }

    public double calculateToll() {
        return 150;
    }
}