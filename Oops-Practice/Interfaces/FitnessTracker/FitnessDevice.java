class FitnessDevice implements Trackable, Reportable, Notifiable {

    @Override
    public void logActivity() {
        System.out.println("Logging today's activity...");
    }

    @Override
    public void generateReport() {
        System.out.println("Generating fitness report...");
    }

    @Override
    public void sendAlert() {
        System.out.println("Daily step goal not achieved!");
    }
}