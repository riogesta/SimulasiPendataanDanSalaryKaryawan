package commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import employees.Analyst;
import employees.Employee;
import employees.Programmer;
import employees.ProjectLeader;

public class Allowance {
    private static Map<String, Double> jobDesc = Jobs.getJobDesc();

    public static int calculateAllowance(String pekerjaan, int pengalaman, int salary) {
        double allowance = 0.0;
        // cek apakah pekerjaan ada pada jobDesc
        if(jobDesc.containsKey(pekerjaan.toLowerCase())) {
            // jika pekerjaan adalah programmer
            if (pekerjaan.equalsIgnoreCase("programmer")) {
                // jika pengelaman lebih dari 4 tahun
                if(pengalaman > 4) allowance = 0.20;
                // jika pengalaman lebih dari 5
                if (pengalaman < 5) allowance = 0.10;
            }

            // jika pekerjaan adalah project leader
            if (pekerjaan.equalsIgnoreCase("projectLeader".toLowerCase())) {
                // jika project yang sedang ditangani 2 atau lebih
                if (pengalaman >= 2) allowance = 0.15;
                // jika project yang sedang ditangani kurang dari 2
                if (pengalaman < 2) allowance = 0.05;
            }

            // jika pekerjaan analyst
            if (pekerjaan.equalsIgnoreCase("analyst")) allowance = 0.05;

        }

        double tambahan = allowance * salary;
        return (int) tambahan;
    }

    public static List<Employee> calculateManyAllowance(List<Employee> employeeList) {
        List<Employee> employeeWithAllowance = new ArrayList<>();
        for(Employee employee : employeeList) {
            if (employee instanceof Programmer) {
                Programmer programmer = (Programmer) employee;
                String pekerjaan = programmer.getClass().getSimpleName();
                int pengalaman = programmer.getExperience();
                int gaji = programmer.getSalary();
                int allowance = calculateAllowance(pekerjaan, pengalaman, gaji);
                programmer.setAllowance(allowance);
                employeeWithAllowance.add(programmer);

            } else if (employee instanceof ProjectLeader) {
                ProjectLeader projectLead = (ProjectLeader) employee;
                String pekerjaan = projectLead.getClass().getSimpleName();
                int totalProject = projectLead.getTotalProject();
                int gaji = projectLead.getSalary();
                int allowance = calculateAllowance(pekerjaan, totalProject, gaji);
                projectLead.setAllowance(allowance);
                employeeWithAllowance.add(projectLead);

            } else if (employee instanceof Analyst) {
                Analyst analyst = (Analyst) employee;
                String pekerjaan = analyst.getClass().getSimpleName();
                int gaji = analyst.getSalary();
                int allowance = calculateAllowance(pekerjaan, 0, gaji);
                analyst.setAllowance(allowance);
                employeeWithAllowance.add(analyst);

            } else {
                employeeWithAllowance.add(employee);
            }
        }

        return employeeWithAllowance;
    }
}
