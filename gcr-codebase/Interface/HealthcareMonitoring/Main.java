public class Main {

    public static void main(String[] args) {

        String[] patientNames = {
                "Kishan",
                "Rahul",
                "Priya",
                "Neha",
                "Aman"
        };

        String[] patientIds = {
                "PT1001",
                "P123",
                "PT1003",
                "PT1004",
                "ABC123"
        };

        int[] heartRates = {
                72,
                110,
                85,
                55,
                95
        };

        double[] temperatures = {
                36.8,
                38.4,
                37.1,
                35.9,
                36.9
        };

        HealthMonitoringSystem system = new HealthMonitoringSystem();

        system.displayHealthTips();

        System.out.println();

        system.generateHealthReport(
                patientNames,
                patientIds,
                heartRates,
                temperatures
        );

    }

}