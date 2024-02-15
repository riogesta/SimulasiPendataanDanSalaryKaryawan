package employees;

public class Analyst extends Employee {
    private int allowance;

    public Analyst(
        String name,
        String address,
        int age,
        String employeeId,
        int salary,
        String jobDesc,
        String placement,
        int allowance
    ) {
        super(name, address, age, employeeId, salary, jobDesc, placement);
        this.allowance = allowance;
    }

    public int getAllowance() {
        return this.allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
}
