public class Main {
    public static void main(String[] args) {
        GradStudent grad = new GradStudent(
                "Kishan Raghav",
                23,
                "ST101",
                8.9,
                "Artificial Intelligence"
        );

        System.out.println(grad);

        Student student = grad;
        Person person = grad;

        System.out.println(student instanceof Student);
        System.out.println(person instanceof Person);
    }
}