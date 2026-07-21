package LibraryMembership;

public class Main {
    public static void main(String[] args) {
        LibraryMember[] members = new LibraryMember[3];

        members[0] = new StudentMember("A", "S1");
        members[1] = new FacultyMember("B", "F1");
        members[2] = new GuestMember("C", "G1");

        String searchId = "F1";

        for (LibraryMember m : members) {
            m.display();
            System.out.println(m.calculateFine(5));

            if (m.memberId.equals(searchId)) {
                System.out.println("Found: " + m.memberName);
            }
        }
    }
}