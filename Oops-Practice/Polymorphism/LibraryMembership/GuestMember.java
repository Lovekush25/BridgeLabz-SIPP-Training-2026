class GuestMember extends LibraryMember {

    public GuestMember(String name, String id) {
        super(name, id);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5;
    }
}