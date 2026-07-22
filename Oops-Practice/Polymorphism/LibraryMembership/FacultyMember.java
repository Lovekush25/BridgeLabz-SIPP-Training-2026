class FacultyMember extends LibraryMember {

    public FacultyMember(String name, String id) {
        super(name, id);
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 1;
    }
}