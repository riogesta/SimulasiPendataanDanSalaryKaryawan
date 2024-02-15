package repositories;

import java.util.ArrayList;
import java.util.List;

import employees.*;

public class RepositoryEmployee {
    private List<Employee> employees;

    public RepositoryEmployee() {
        employees = new ArrayList<>();
    }

    public void initializeDummyData() {
        employees.add(new Employee("Susi", "Bandung", 27, "Emp-001", 0, "Admin","Jakarta"));
        employees.add(new Employee("Anto", "Bandung", 35, "Emp-002", 0, "Office Boy", "Bandung"));
        employees.add(new Employee("Riman", "Jakarta", 28, "Emp-003", 0, "Human Resource Dev", "Bandung"));

        employees.add(new Programmer("Budi", "Bandung", 25, "Prog-001", 0, "Back End Dev", "Jakarta", "Java", 2, 0));
        employees.add(new Programmer("Ani", "Bandung", 30, "Prog-002", 0, "FrontEndDev", "Bandung", "React Js", 6, 0));
        employees.add(new Programmer("Ujang", "Bandung", 28, "Prog-003", 0, "Full Stack Dev", "Bandung", "Kotlin", 4, 0));

        employees.add(new ProjectLeader("Ahmad", "Bandung", 25, "PL-001", 0, "Project Leader", "Garut", 2, 0));
        employees.add(new ProjectLeader("Dani", "Bandung", 30, "PL-002", 0, "Scrum Master", "Bekasi", 1, 0));
        employees.add(new ProjectLeader("Cecep", "Jakarta", 28, "PL-003", 0, "Project Owner", "Bogor", 4, 0));

        employees.add(new Analyst("Indah", "Garut", 25, "AL-001", 0, "Analyst", "Jakarta", 0));
        employees.add(new Analyst("Puspa", "Bandung", 30, "AL-002", 0, "Analyst", "Bekasi", 0));
        employees.add(new Analyst("Sari", "Jakarta", 28, "AL-003", 0, "Analyst", "Bogor", 0));
    }

    public List<Employee> getAllEmployees() {
        return this.employees;
    }
}
