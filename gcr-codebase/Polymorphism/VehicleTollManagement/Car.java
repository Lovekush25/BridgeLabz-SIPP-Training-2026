package VehicleTollManagement;

public class Car extends Vehicle {

    public Car(String v, String o) {
        super(v, o);
    }

    public double calculateToll() {
        return 50;
    }
}