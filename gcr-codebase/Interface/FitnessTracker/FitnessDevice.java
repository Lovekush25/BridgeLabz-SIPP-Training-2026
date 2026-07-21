public class FitnessDevice implements Trackable, Reportable, Notifiable {

    private String userName;
    private int steps;
    private int calories;

    public FitnessDevice(String userName, int steps, int calories) {
        this.userName = userName;
        this.steps = steps;
        this.calories = calories;
    }

    @Override
    public void logActivity() {
        System.out.println("User : " + userName);
        System.out.println("Steps : " + steps);
        System.out.println("Calories Burned : " + calories);
    }

    @Override
    public void generateReport() {
        System.out.println("----- Daily Report -----");
        System.out.println("User : " + userName);
        System.out.println("Total Steps : " + steps);
        System.out.println("Calories Burned : " + calories);
    }

    @Override
    public void sendAlert() {
        if (steps < 5000) {
            System.out.println("Alert : Walk more today.");
        } else {
            System.out.println("Great Job! Daily goal achieved.");
        }
    }
}