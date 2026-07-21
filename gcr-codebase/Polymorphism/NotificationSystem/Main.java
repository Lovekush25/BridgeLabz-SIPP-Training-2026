package NotificationSystem;

public class Main {
    public static void main(String[] args) {
        Notification[] arr = new Notification[3];

        arr[0] = new EmailNotification("Amit", "Hello Email");
        arr[1] = new SMSNotification("Ravi", "Hello SMS");
        arr[2] = new PushNotification("Neha", "Hello Push");

        for (Notification n : arr) {
            n.sendNotification();
        }
    }
}