class StudentMember extends LibraryMember {

    public StudentMember(String name, String id) {
        super(name, id);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2;
    }
}