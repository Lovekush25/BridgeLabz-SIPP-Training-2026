import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public static void markAttendance(String subject, String student) {

        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        if (students.contains(student)) {
            System.out.println("Attendance Already Marked.");
        } else {
            students.add(student);
            System.out.println("Attendance Marked Successfully.");
        }
    }

    public static void displayAttendance() {

        if (attendance.isEmpty()) {
            System.out.println("No Attendance Records Found.");
            return;
        }

        System.out.println("\n===== Attendance Report =====");

        for (Map.Entry<String, ArrayList<String>> entry : attendance.entrySet()) {

            System.out.println("\nSubject : " + entry.getKey());

            ArrayList<String> students = entry.getValue();

            if (students.isEmpty()) {
                System.out.println("No Students Present.");
            } else {

                for (String student : students) {
                    System.out.println(student);
                }

                System.out.println("Total Students Present : " + students.size());
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Smart Classroom Attendance Tracker =====");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Display Attendance");
            System.out.println("3. Exit");
            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Subject Name : ");
                    String subject = sc.nextLine();

                    System.out.print("Enter Student Name : ");
                    String student = sc.nextLine();

                    markAttendance(subject, student);
                    break;

                case 2:

                    displayAttendance();
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