public class Main {
    public static void main(String[] args) {

        LibraryMember[] members = {

                new StudentMember(
                        "Rahul",
                        "S101"),

                new FacultyMember(
                        "Dr. Sharma",
                        "F201"),

                new GuestMember(
                        "Aman",
                        "G301")
        };

        String searchId = "F201";

        for (LibraryMember m : members) {

            m.printDetails();

            System.out.println("Fine = " + m.calculateFine(6));

            if (m.memberId.equals(searchId)) {
                System.out.println("Member Found : " + m.memberName);
            }

            System.out.println();
        }
    }
}