public class GradStudent extends Student {
    private String thesis;

    public GradStudent(String name, int age, String studentId, double gpa, String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() + ", Thesis: " + thesis;
    }
}