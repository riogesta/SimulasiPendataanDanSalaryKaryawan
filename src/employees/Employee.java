package employees;
import commons.Person;
public class Employee extends Person {
    private String employeeId;
    private int salary;
    private String jobDesc;
    private String placement;

    public Employee(
        String name,
        String address,
        int age,
        String employeeId,
        int salary,
        String jobDesc,
        String placement
    ) {
        super(name, address, age);
        this.employeeId = employeeId;
        this.salary = salary;
        this.jobDesc = jobDesc;
        this.placement = placement;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobDesc() {
        return this.jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getPlacement() {
        return this.placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }
}
