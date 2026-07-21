public class Main {

    public static void main(String[] args) {

        Vehicle[] vehicles = {
                new Car("Honda City"),
                new Bus("Volvo Bus"),
                new Bike("Royal Enfield"),
                new ElectricCar("Tesla Model 3")
        };

        int distance = 100;

        for (Vehicle vehicle : vehicles) {

            vehicle.displayDetails();

            System.out.println("Fuel Cost for " + distance + " km : ₹" + vehicle.fuelCost(distance));

            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                System.out.println("Type : Car");
            } else if (vehicle instanceof Bus) {
                Bus bus = (Bus) vehicle;
                System.out.println("Type : Bus");
            } else if (vehicle instanceof Bike) {
                Bike bike = (Bike) vehicle;
                System.out.println("Type : Bike");
            } else if (vehicle instanceof ElectricCar) {
                ElectricCar electricCar = (ElectricCar) vehicle;
                System.out.println("Type : Electric Car");
            }

            System.out.println();

        }

    }

}