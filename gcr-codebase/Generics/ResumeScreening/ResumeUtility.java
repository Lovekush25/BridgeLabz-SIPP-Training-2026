import java.util.ArrayList;
import java.util.List;

public class ResumeUtility {

    public static <T extends JobRole> void screenResume(Resume<T> resume) {

        System.out.println("Candidate : " + resume.getCandidateName());
        System.out.println("Role      : " + resume.getJobRole());
        System.out.println("Experience: " + resume.getExperience() + " Years");

        if (resume.getExperience() >= 2) {
            System.out.println("Status    : Selected");
        } else {
            System.out.println("Status    : Rejected");
        }

        System.out.println();
    }

    public static void displayRoles(List<? extends JobRole> roles) {

        for (JobRole role : roles) {
            System.out.println(role);
        }
    }

    public static void main(String[] args) {

        Resume<SoftwareEngineer> r1 =
                new Resume<>("Kishan", new SoftwareEngineer(), 3);

        Resume<DataScientist> r2 =
                new Resume<>("Rahul", new DataScientist(), 1);

        Resume<ProductManager> r3 =
                new Resume<>("Anjali", new ProductManager(), 5);

        screenResume(r1);
        screenResume(r2);
        screenResume(r3);

        List<JobRole> roles = new ArrayList<>();

        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        roles.add(new ProductManager());

        System.out.println("Available Job Roles");

        displayRoles(roles);
    }
}