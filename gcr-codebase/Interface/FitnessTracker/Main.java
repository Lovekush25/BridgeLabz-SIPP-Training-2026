public class Main {

    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice("Kishan", 7200, 430);

        device.logActivity();

        System.out.println();

        device.generateReport();

        System.out.println();

        device.sendAlert();

        System.out.println();

        device.resetData();
    }
}