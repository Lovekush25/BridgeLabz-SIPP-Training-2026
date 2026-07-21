package VehicleTollManagement;

public class Main {

    public static double calculateTotalRevenue(Vehicle[] v) {
        double total = 0;
        for (Vehicle x : v) {
            total += x.calculateToll();
        }
        return total;
    }

    public static Vehicle searchVehicle(Vehicle[] v, String number) {
        for (Vehicle x : v) {
            if (x.vehicleNumber.equals(number)) {
                return x;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Vehicle[] v = new Vehicle[3];

        v[0] = new Car("C1", "A");
        v[1] = new Bus("B1", "B");
        v[2] = new Truck("T1", "C");

        System.out.println(calculateTotalRevenue(v));

        Vehicle max = v[0];

        for (Vehicle x : v) {
            if (x.calculateToll() > max.calculateToll()) {
                max = x;
            }
        }

        System.out.println(max.vehicleNumber);

        Vehicle found = searchVehicle(v, "B1");
        if (found != null) {
            System.out.println(found.ownerName);
        }
    }
}