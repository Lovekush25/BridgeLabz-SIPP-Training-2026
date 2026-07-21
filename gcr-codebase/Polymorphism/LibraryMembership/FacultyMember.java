package LibraryMembership;

public class FacultyMember extends LibraryMember {

    public FacultyMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    public double calculateFine(int overdueDays) {
        return overdueDays * 1;
    }
}