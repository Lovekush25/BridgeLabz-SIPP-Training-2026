package NotificationSystem;

public class PushNotification extends Notification {

    public PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("Push sent to " + recipientName + ": " + message);
    }
}