package LibraryMembership;

public class LibraryMember {
    String memberName;
    String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public double calculateFine(int overdueDays) {
        return 0;
    }

    public void display() {
        System.out.println(memberName + " " + memberId);
    }
}