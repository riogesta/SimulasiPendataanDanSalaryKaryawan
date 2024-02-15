package commons;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import employees.Employee;

public class Salary {
    // UMK PERCENTAGE
    private static Map<String, Double> jobDesc = new HashMap<>();

    static {
        jobDesc = Jobs.getJobDesc();
    }

    public static int calculateSalary(String pekerjaan, String placement) {
        // membuat teks pekerjaan menjadi lowercase
        String lowerCaseJobDesc = pekerjaan.toLowerCase();

        double total = 0;
        // mendapatkan umk untuk tiap penempatan
        int gaji = Placement.getUmk(placement);
        // mendapatkan persentase berdasarkan pekerjaannya.
        // jika tidak tersedia maka 0.0
        double persentase = jobDesc.getOrDefault(lowerCaseJobDesc, 0.0);
        // jika persentase bukan 0.0 / tersedia
        if (persentase != 0.0) {
            total = persentase * gaji;
            return (int) total; 
        } else {
            return (int) total;
        }
    }

    public static List<Employee> calculateManySalary(List<Employee> employeesList) {
        // sebuah list employee baru dengan gaji
        List<Employee> employeesWithSalary = new ArrayList<>();
        // melakukan kalkulasi gaji untuk semua employee
        for(Employee employee : employeesList) {
            String pekerjaan = employee.getClass().getSimpleName();
            String penempatan = employee.getPlacement();
            int gaji = calculateSalary(pekerjaan, penempatan);
            employee.setSalary(gaji);
            employeesWithSalary.add(employee);
        }

        return employeesWithSalary;
    }
}
