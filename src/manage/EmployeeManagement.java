package manage;

import commons.Allowance;
import commons.Salary;
import employees.*;

public class EmployeeManagement {

    public static Employee addEmployee(
        String nama,
        String address,
        String employeeId,
        int age,
        String jobDesc,
        String placement
    ) {
        int salary = Salary.calculateSalary(jobDesc, placement);
        Employee employee = new Employee(nama, address, age, employeeId, salary, jobDesc, placement);

        return employee;
    }

    public static Employee addProgrammer(
        String nama,
        String address,
        String employeeId,
        int age,
        String jobDesc,
        String placement,
        String programmingLanguage,
        int experience
    ) {
        String pekerjaan = "programmer";
        int salary = Salary.calculateSalary(pekerjaan, placement);
        int allowance = Allowance.calculateAllowance(pekerjaan, experience, salary);

        Programmer programmer = new Programmer(nama, address, age, employeeId, salary, jobDesc, placement, programmingLanguage, experience, allowance);

        return programmer;
    }

    public static Employee addProjectLeader(
        String nama,
        String address,
        String employeeId,
        int age,
        String jobDesc,
        String placement,
        int totalProject
    ) {
        String pekerjaan = "projectLeader".toLowerCase();
        int salary = Salary.calculateSalary(pekerjaan, placement);
        int allowance = Allowance.calculateAllowance(pekerjaan, totalProject, salary);

        ProjectLeader projectLead = new ProjectLeader(nama, address, age, employeeId, salary, jobDesc, placement, totalProject, allowance);

        return projectLead;
    }

    public static Employee addAnalyst(
        String nama,
        String address,
        String employeeId,
        int age,
        String jobDesc,
        String placement
    ) {
        String pekerjaan = "analyst";
        int salary = Salary.calculateSalary(pekerjaan, placement);
        int allowance = Allowance.calculateAllowance(pekerjaan, 0, salary);

        Analyst analyst = new Analyst(nama, address, age, employeeId, salary, jobDesc, placement, allowance);

        return analyst;
    }

}
