public interface HeartRateMonitor {

    void checkHeartRate(String patientName, int heartRate);

    default void displayHealthTips() {
        System.out.println("Health Tip : Exercise regularly and maintain a healthy lifestyle.");
    }
}