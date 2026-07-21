package LibraryMembership;

public class StudentMember extends LibraryMember {

    public StudentMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    public double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }
}