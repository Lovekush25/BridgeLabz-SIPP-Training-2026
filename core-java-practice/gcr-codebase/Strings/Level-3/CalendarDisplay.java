import java.util.Scanner;

public class CalendarDisplay {
    public static String monthName(int m) {
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        if (m >= 1 && m <= 12) return months[m-1];
        return "";
    }

    public static boolean isLeap(int y) {
        return (y%4==0 && y%100!=0) || (y%400==0);
    }

    public static int daysInMonth(int m, int y) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (m == 2 && isLeap(y)) return 29;
        return days[m-1];
    }

    // returns 0=Sunday .. 6=Saturday
    public static int firstDay(int month, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (1 + x + (31*m)/12) % 7;
        return d;
    }

    public static void printCalendar(int month, int year) {
        System.out.println("    " + monthName(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int start = firstDay(month, year);
        int days = daysInMonth(month, year);
        for (int i = 0; i < start; i++) System.out.print("    ");
        for (int d = 1; d <= days; d++) {
            System.out.printf("%3d ", d);
            if ((start + d) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();
        System.out.print("Enter year: ");
        int y = sc.nextInt();
        printCalendar(m,y);
        sc.close();
    }
}