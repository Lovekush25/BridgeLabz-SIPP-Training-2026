public class Main {
    public static void main(String[] args) {

        FitnessDevice device = new FitnessDevice();

        device.logActivity();
        device.generateReport();
        device.sendAlert();
        device.resetData();

        // Java supports multiple inheritance using interfaces,
        // not multiple classes.
    }
}