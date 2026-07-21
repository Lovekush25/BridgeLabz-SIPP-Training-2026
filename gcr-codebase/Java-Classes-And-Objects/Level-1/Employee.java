class Employee {
    String name;
    int id;
    double salary;

    void display() {
        System.out.println(name);
        System.out.println(id);
        System.out.println(salary);
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Aman";
        e.id = 101;
        e.salary = 50000;
        e.display();
    }
}