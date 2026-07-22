public class Main {
    public static void main(String[] args) {

        Notification[] notifications = {

                new EmailNotification("Rahul",
                        "Meeting at 5 PM"),

                new SMSNotification("Aman",
                        "OTP : 1234"),

                new PushNotification("Priya",
                        "Flash Sale!")
        };

        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}