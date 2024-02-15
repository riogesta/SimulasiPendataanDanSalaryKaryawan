package employees;

public class ProjectLeader extends Employee {
    private int totalProject;
    private int allowance;

    public ProjectLeader(
        String name,
        String address,
        int age,
        String employeeId,
        int salary,
        String jobDesc,
        String placement,
        int totalProject,
        int allowance
    ) {
        super(name, address, age, employeeId, salary, jobDesc, placement);
        this.totalProject = totalProject;
        this.allowance = allowance;
    }

    public int getTotalProject() {
        return this.totalProject;
    }

    public void setTotalProject(int totalProject) {
        this.totalProject = totalProject;
    }

    public int getAllowance() {
        return this.allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
}
