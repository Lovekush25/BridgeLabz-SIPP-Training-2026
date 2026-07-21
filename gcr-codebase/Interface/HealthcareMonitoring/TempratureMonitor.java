public interface TemperatureMonitor {

    void checkTemperature(String patientName, double temperature);

    default void displayHealthTips() {
        System.out.println("Health Tip : Drink enough water and take proper rest.");
    }

    static boolean isPatientIdValid(String patientId) {
        return patientId.length() == 6;
    }
}