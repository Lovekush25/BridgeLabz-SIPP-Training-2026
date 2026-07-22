public class Main {

    public static void main(String[] args) {

        FullTimeEmployee emp1 = new FullTimeEmployee();
        emp1.setEmployeeId(101);
        emp1.setEmployeeName("Rahul");
        emp1.setMonthlySalary(50000);

        PartTimeEmployee emp2 = new PartTimeEmployee();
        emp2.setEmployeeId(102);
        emp2.setEmployeeName("Aman");
        emp2.setHoursWorked(80);
        emp2.setHourlyRate(300);

        emp1.displayEmployeeInfo();
        System.out.println("Salary = " + emp1.calculateSalary());

        System.out.println();

        emp2.displayEmployeeInfo();
        System.out.println("Salary = " + emp2.calculateSalary());
    }
}