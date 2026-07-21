import java.util.ArrayList;
import java.util.List;

public class CourseUtility {

    public static void displayCourses(List<? extends CourseType> courses) {

        for (CourseType course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {

        Course<ExamCourse> examCourse =
                new Course<>(new ExamCourse("Operating Systems"));

        Course<AssignmentCourse> assignmentCourse =
                new Course<>(new AssignmentCourse("Java Programming"));

        Course<ResearchCourse> researchCourse =
                new Course<>(new ResearchCourse("Artificial Intelligence"));

        examCourse.displayCourse();
        assignmentCourse.displayCourse();
        researchCourse.displayCourse();

        List<CourseType> list = new ArrayList<>();

        list.add(examCourse.getCourseType());
        list.add(assignmentCourse.getCourseType());
        list.add(researchCourse.getCourseType());

        System.out.println();

        displayCourses(list);
    }
}