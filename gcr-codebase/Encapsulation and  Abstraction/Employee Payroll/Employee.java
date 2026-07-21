abstract class Employee {

    private int employeeId;
    private String employeeName;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public abstract double calculateSalary();

    public void displayEmployeeInfo() {
        System.out.println("ID : " + employeeId);
        System.out.println("Name : " + employeeName);
    }
}