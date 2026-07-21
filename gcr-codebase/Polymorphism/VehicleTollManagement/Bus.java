package VehicleTollManagement;

public class Bus extends Vehicle {

    public Bus(String v, String o) {
        super(v, o);
    }

    public double calculateToll() {
        return 100;
    }
}