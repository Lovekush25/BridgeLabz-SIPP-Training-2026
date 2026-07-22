package University;

public class GradStudent extends Student {
    protected String thesis;

    public GradStudent(int id , String name , int studentId , double studentGpa , String thesis){
        super(id , name , studentId , studentGpa);
        this.thesis = thesis;
    }

    @Override
    public String toString(){
        return "GradStudent{" + "personId = " + personId + "personName = " + personName + "}";
    }
}
