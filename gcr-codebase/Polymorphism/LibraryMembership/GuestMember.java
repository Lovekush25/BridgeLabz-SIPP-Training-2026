package LibraryMembership;

public class GuestMember extends LibraryMember {

    public GuestMember(String memberName, String memberId) {
        super(memberName, memberId);
    }

    public double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }
}