package University;

public class UniversityMain {
    public static void main(String[] args) {

        GradStudent studentOne = new GradStudent(
                101 ,
                'Shaurya' ,
                123456 ,
                6.87 ,
                'Artificial Intelligence'
        );

        System.out.println(studentOne);

        GradStudent studentTwo = new GradStudent(
                102 ,
                'Sarthak' ,
                2468097 ,
                8.76 ,
                'Machine Learning'
        );
        System.out.println(studentTwo);

    }
}
