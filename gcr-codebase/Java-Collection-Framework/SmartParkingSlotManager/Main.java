import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<String> vehicles = new ArrayList<>();

    public static void addVehicle(String number) {

        if (vehicles.contains(number)) {
            System.out.println("Vehicle is already parked.");
            return;
        }

        vehicles.add(number);
        System.out.println("Vehicle Entered Successfully.");
    }

    public static void removeVehicle(String number) {

        if (vehicles.remove(number)) {
            System.out.println("Vehicle Exited Successfully.");
        } else {
            System.out.println("Vehicle Not Found.");
        }
    }

    public static void searchVehicle(String number) {

        if (vehicles.contains(number)) {
            System.out.println("Vehicle is Currently Parked.");
        } else {
            System.out.println("Vehicle is Not Parked.");
        }
    }

    public static void displayVehicles() {

        if (vehicles.isEmpty()) {
            System.out.println("Parking Area is Empty.");
            return;
        }

        System.out.println("\n----- Parked Vehicles -----");

        for (String vehicle : vehicles) {
            System.out.println(vehicle);
        }

        System.out.println("---------------------------");
        System.out.println("Occupied Parking Slots : " + vehicles.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Smart Parking Slot Manager =====");
            System.out.println("1. Vehicle Entry");
            System.out.println("2. Vehicle Exit");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display Parked Vehicles");
            System.out.println("5. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Vehicle Registration Number : ");
                    addVehicle(sc.nextLine());
                    break;

                case 2:

                    System.out.print("Enter Vehicle Registration Number : ");
                    removeVehicle(sc.nextLine());
                    break;

                case 3:

                    System.out.print("Enter Vehicle Registration Number : ");
                    searchVehicle(sc.nextLine());
                    break;

                case 4:

                    displayVehicles();
                    break;

                case 5:

                    System.out.println("Thank You.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}