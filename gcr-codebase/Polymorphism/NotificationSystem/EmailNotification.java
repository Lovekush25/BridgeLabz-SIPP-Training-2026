package NotificationSystem;

public class EmailNotification extends Notification {

    public EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    public void sendNotification() {
        System.out.println("Email sent to " + recipientName + ": " + message);
    }
}