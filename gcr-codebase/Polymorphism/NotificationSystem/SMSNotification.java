package NotificationSystem;

public class SMSNotification extends Notification {

    public SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("SMS sent to " + recipientName + ": " + message);
    }
}