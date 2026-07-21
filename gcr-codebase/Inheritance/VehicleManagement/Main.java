public class Main {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3",250);
        PetrolVehicle pv = new PetrolVehicle("Honda City",180);

        ev.charge();
        pv.refuel();
    }
}