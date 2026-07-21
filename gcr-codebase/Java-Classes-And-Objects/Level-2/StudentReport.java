class Student {
    String name;
    int rollNumber;
    int marks;

    char grade() {
        if (marks >= 90) return 'A';
        else if (marks >= 75) return 'B';
        else if (marks >= 60) return 'C';
        else return 'D';
    }

    void display() {
        System.out.println(name);
        System.out.println(rollNumber);
        System.out.println(grade());
    }

    public static void main(String[] args) {
        Student s = new Student();
        s.name = "Ravi";
        s.rollNumber = 10;
        s.marks = 85;
        s.display();
    }
}