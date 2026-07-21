import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    static HashMap<String, Integer> trafficData = new HashMap<>();

    public static void addOrUpdateRoad(String roadName, int vehicleCount) {

        trafficData.put(roadName, vehicleCount);
        System.out.println("Traffic Data Updated Successfully.");
    }

    public static void displayTrafficReport() {

        if (trafficData.isEmpty()) {
            System.out.println("No Traffic Data Available.");
            return;
        }

        TreeMap<String, Integer> sortedRoads = new TreeMap<>(trafficData);

        System.out.println("\n===== Traffic Analysis Report =====");

        for (Map.Entry<String, Integer> entry : sortedRoads.entrySet()) {

            System.out.println("Road Name : " + entry.getKey());
            System.out.println("Vehicle Count : " + entry.getValue());

            if (entry.getValue() < 100) {
                System.out.println("Traffic Status : Low");
            } else if (entry.getValue() <= 300) {
                System.out.println("Traffic Status : Moderate");
            } else {
                System.out.println("Traffic Status : Heavy");
            }

            System.out.println("-----------------------------");
        }

        System.out.println("Total Roads Monitored : " + trafficData.size());
    }

    public static void displayBusiestRoad() {

        if (trafficData.isEmpty()) {
            System.out.println("No Traffic Data Available.");
            return;
        }

        String busiestRoad = "";
        int maxVehicles = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : trafficData.entrySet()) {

            if (entry.getValue() > maxVehicles) {
                maxVehicles = entry.getValue();
                busiestRoad = entry.getKey();
            }
        }

        System.out.println("\n===== Busiest Road =====");
        System.out.println("Road Name : " + busiestRoad);
        System.out.println("Vehicle Count : " + maxVehicles);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Smart City Traffic Monitoring System =====");
            System.out.println("1. Add/Update Vehicle Count");
            System.out.println("2. Display Traffic Report");
            System.out.println("3. Display Busiest Road");
            System.out.println("4. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Road Name : ");
                    String roadName = sc.nextLine();

                    System.out.print("Enter Vehicle Count : ");
                    int count = sc.nextInt();
                    sc.nextLine();

                    addOrUpdateRoad(roadName, count);
                    break;

                case 2:

                    displayTrafficReport();
                    break;

                case 3:

                    displayBusiestRoad();
                    break;

                case 4:

                    System.out.println("Thank You.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}