public class Main {
    public static void main(String[] args) {

        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 220);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180);

        ev.display();
        ev.charge();

        System.out.println();

        pv.display();
        pv.refuel();
    }
}