public class Main {

    public static void main(String[] args) {

        Vehicle[] fleet = {
                new Car("C101"),
                new Bus("B201"),
                new Bike("BK301"),
                new ElectricCar("EV401")
        };

        for (Vehicle v : fleet) {

            System.out.println(v.getClass().getSimpleName() + " Cost = " + v.fuelCost(100));

            if (v instanceof Car) {
                Car c = (Car) v;
            }
            if (v instanceof Bus) {
                Bus b = (Bus) v;
            }
            if (v instanceof Bike) {
                Bike bk = (Bike) v;
            }
            if (v instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) v;
            }
        }
    }
}