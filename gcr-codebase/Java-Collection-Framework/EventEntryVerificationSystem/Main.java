import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static HashSet<String> participants = new HashSet<>();

    public static void registerParticipant(String email) {

        if (participants.add(email.toLowerCase())) {
            System.out.println("Registration Successful.");
        } else {
            System.out.println("Duplicate Registration Not Allowed.");
        }
    }

    public static void displayParticipants() {

        if (participants.isEmpty()) {
            System.out.println("No Participants Registered.");
            return;
        }

        System.out.println("\n----- Registered Participants -----");

        for (String email : participants) {
            System.out.println(email);
        }

        System.out.println("-----------------------------------");
        System.out.println("Total Eligible Participants : " + participants.size());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Event Entry Verification System =====");
            System.out.println("1. Register Participant");
            System.out.println("2. Display Registered Participants");
            System.out.println("3. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Email ID : ");
                    registerParticipant(sc.nextLine());
                    break;

                case 2:

                    displayParticipants();
                    break;

                case 3:

                    System.out.println("Thank You.");
                    sc.close();
                    return;

                default:

                    System.out.println("Invalid Choice.");
            }
        }
    }
}