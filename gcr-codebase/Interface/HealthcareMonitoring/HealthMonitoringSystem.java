public class HealthMonitoringSystem implements HeartRateMonitor, TemperatureMonitor {

    @Override
    public void checkHeartRate(String patientName, int heartRate) {

        System.out.print("Heart Rate : " + heartRate + " bpm");

        if (heartRate >= 60 && heartRate <= 100) {
            System.out.println(" (Normal)");
        } else {
            System.out.println(" (Abnormal)");
        }

    }

    @Override
    public void checkTemperature(String patientName, double temperature) {

        System.out.print("Temperature : " + temperature + " °C");

        if (temperature >= 36.5 && temperature <= 37.5) {
            System.out.println(" (Normal)");
        } else {
            System.out.println(" (Abnormal)");
        }

    }

    @Override
    public void displayHealthTips() {

        HeartRateMonitor.super.displayHealthTips();
        TemperatureMonitor.super.displayHealthTips();

    }

    public void generateHealthReport(String[] names,
                                     String[] patientIds,
                                     int[] heartRates,
                                     double[] temperatures) {

        for (int i = 0; i < names.length; i++) {

            System.out.println();

            System.out.println("Patient Name : " + names[i]);

            if (TemperatureMonitor.isPatientIdValid(patientIds[i])) {
                System.out.println("Patient ID : " + patientIds[i] + " (Valid)");
            } else {
                System.out.println("Patient ID : " + patientIds[i] + " (Invalid)");
            }

            checkHeartRate(names[i], heartRates[i]);
            checkTemperature(names[i], temperatures[i]);

        }

    }

}