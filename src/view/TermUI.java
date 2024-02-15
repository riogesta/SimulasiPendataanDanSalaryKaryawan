package view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import commons.Allowance;
import commons.Salary;
import employees.Analyst;
import employees.Employee;
import employees.Programmer;
import employees.ProjectLeader;
import manage.EmployeeManagement;
import repositories.RepositoryEmployee;

public class TermUI {
    private static int pilihan;
    private static Scanner input = new Scanner(System.in);
    private static List<Employee> employeesList = new ArrayList<>();

    static {
        RepositoryEmployee repoEmployee = new RepositoryEmployee();
        repoEmployee.initializeDummyData();
        employeesList = Salary.calculateManySalary(repoEmployee.getAllEmployees());
        employeesList = Allowance.calculateManyAllowance(employeesList);
    }

    public static void getMenu() {
        System.out.println("");
        System.out.println("===================================================================");
        System.out.println(" Selamat datang di aplikasi pendataan karyawan PT. Secret Semut 79 ");
        System.out.println("===================================================================");
        System.out.println("");
        System.out.println("1. Add Employee");
        System.out.println("2. Edit Employee");
        System.out.println("3. Data Employee");
        System.out.println("4. Data Payroll");
        System.out.println("5. Delete Employee");
        System.out.println("6. Searching");
        System.out.println("0. Exit");
        System.out.print("Pilihan: ");
    }

    public static void conditionOption() {
        boolean loop = true;
        while(loop) {
            getMenu();
            pilihan = Integer.parseInt(input.nextLine());
            switch (pilihan) {
                case 1:
                    addEmployee();
                    break;
                
                case 2:
                    editEmployee();
                    break;
                
                case 3:
                    getDataEmployee();
                    break;
                
                case 4:
                    getDataPayroll();
                    break;

                case 5:
                    deleteEmploye();
                    break;

                case 6:
                    getSearchingMenu();
                    break;
            
                case 0:
                    loop = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static void addEmployee() {

        System.out.printf("(1: Pegawai, 2: Programmer, 3: Project Leader, 4: Analyst)\nPekerjaan yang akan dilamar: ");
        int pekerjaan = Integer.parseInt(input.nextLine());

        System.out.printf("masukkan nama: ");
        String name = input.nextLine();

        System.out.printf("masukkan alamat: ");
        String address = input.nextLine();

        System.out.printf("masukkan umur: ");
        int age = Integer.parseInt(input.nextLine());

        System.out.printf("masukkan id pagawai: ");
        String employeeId = input.nextLine();

        System.out.printf("job desc yang akan dilamar: ");
        String jobDesc = input.nextLine();

        System.out.printf("penempatan yang diinginkan: ");
        String placement = input.nextLine();

        // Employee
        if (pekerjaan == 1) {
            employeesList.add(EmployeeManagement.addEmployee(name, address, employeeId, age, jobDesc, placement));
        }

        // programmer
        if (pekerjaan == 2) {
            System.out.printf("bahasa pemrogramman yang dikuasai: ");
            String programmingLanguage = input.nextLine();

            System.out.printf("pengelaman kerja: ");
            int experience = Integer.parseInt(input.nextLine());

            employeesList.add(EmployeeManagement.addProgrammer(name, address, employeeId, age, jobDesc, placement, programmingLanguage, experience));
        }

        // project leader
        if (pekerjaan == 3) {
            System.out.print("total peoject yang pernah atau sedang dikerjakan:");
            int totalProject = Integer.parseInt(input.nextLine());

            employeesList.add(EmployeeManagement.addProjectLeader(name, address, employeeId, age, jobDesc, placement, totalProject));
        }

        // analyst
        if (pekerjaan == 4) {
            employeesList.add(EmployeeManagement.addAnalyst(name, address, employeeId, age, jobDesc, placement));
        }

    }

    public static void getDataEmployee() {
        int counter = 1;
        System.out.println("");
        System.out.println("Data Employee:");
        System.out.println("+-------+--------------+----------------------+---------------------------+------------+----------------------+----------------------+");
        System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-10s | %-20s | %-20s |\n", "No.", "Employee Id", "Name", "Address", "Age", "Job Desc", "Placement");
        System.out.println("+-------+--------------+----------------------+---------------------------+------------+----------------------+----------------------+");
        for (Employee employee : employeesList) {
            System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-10s | %-20s | %-20s |\n", 
                counter++,
                employee.getEmployeeId(),
                employee.getName(),
                employee.getAddress(),
                employee.getAge(),
                employee.getJobDesc(),
                employee.getPlacement()
            );
        }
        System.out.printf("+-------+--------------+----------------------+---------------------------+------------+----------------------+----------------------+\n");

        System.out.println("tekan enter untuk keluar...");
        input.nextLine();
    }

    public static void getDataPayroll() {
        int counter = 1;
        int totalSalary = 0;
        System.out.println("");
        System.out.println("Data Payroll:");
        System.out.println("+-------+--------------+----------------------+---------------------------+----------------------+-----------------+-----------------+");
        System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-20s | %-15s | %-15s |\n", "No.", "Employee Id", "Name", "Job Desc", "Placement", "Allowance", "Salary");
        System.out.println("+-------+--------------+----------------------+---------------------------+----------------------+-----------------+-----------------+");
        for (Employee employee : employeesList) {
            if (employee instanceof Programmer) {
                Programmer programmer = (Programmer) employee;
                System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-20s | %-15s | %-15s |\n", 
                    counter++,
                    programmer.getEmployeeId(),
                    programmer.getName(),
                    programmer.getJobDesc(),
                    programmer.getPlacement(),
                    programmer.getAllowance(),
                    programmer.getSalary()
                );
                totalSalary += programmer.getSalary();

            } else if (employee instanceof ProjectLeader) {
                ProjectLeader projectLead = (ProjectLeader) employee;
                System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-20s | %-15s | %-15s |\n", 
                    counter++,
                    projectLead.getEmployeeId(),
                    projectLead.getName(),
                    projectLead.getJobDesc(),
                    projectLead.getPlacement(),
                    projectLead.getAllowance(),
                    projectLead.getSalary()
                );
                totalSalary += projectLead.getSalary();

            } else if (employee instanceof Analyst) {
                Analyst analyst = (Analyst) employee;
                System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-20s | %-15s | %-15s |\n", 
                    counter++,
                    analyst.getEmployeeId(),
                    analyst.getName(),
                    analyst.getJobDesc(),
                    analyst.getPlacement(),
                    analyst.getAllowance(),
                    analyst.getSalary()
                );
                totalSalary += analyst.getSalary();
                
            } else {
                System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-20s | %-15s | %-15s |\n", 
                    counter++,
                    employee.getEmployeeId(),
                    employee.getName(),
                    employee.getJobDesc(),
                    employee.getPlacement(),
                    "-",
                    employee.getSalary()
                );
                totalSalary += employee.getSalary();
            }

        }
        System.out.println("+-------+--------------+----------------------+---------------------------+----------------------+-----------------+-----------------+");
        System.out.printf("| %-112s | %-15s |\n", "Total Payroll", totalSalary);
        System.out.println("+-------+--------------+----------------------+---------------------------+----------------------+-----------------+-----------------+\n");
        System.out.println("tekan enter untuk keluar...");
        input.nextLine();
    }

    public static void getSearchingMenu() {
        System.out.println("1. Searching by placement");
        System.out.println("0. back to menu");
        System.out.printf("pilihan: ");
        pilihan = Integer.parseInt(input.nextLine());
        switch (pilihan) {
            case 1:
                findByPlacement();
                break;
        
            case 0:
                conditionOption();
                break;

            default:
                break;
        }
    }

    public static void findByPlacement() {
        System.out.print("Masukkan kota penempetan: ");
        String placement = input.nextLine();
        
        int counter = 1;
        System.out.println("");
        System.out.println("Data Employee:");
        System.out.println("+-------+--------------+----------------------+---------------------------+------------+----------------------+----------------------+");
        System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-10s | %-20s | %-20s |\n", "No.", "Employee Id", "Name", "Address", "Age", "Job Desc", "Placement");
        System.out.println("+-------+--------------+----------------------+---------------------------+------------+----------------------+----------------------+");
        for (Employee employee : employeesList) {
            if (employee.getPlacement().equalsIgnoreCase(placement)) {
                System.out.printf("| %-5s | %-12s | %-20s | %-25s | %-10s | %-20s | %-20s |\n", 
                    counter++,
                    employee.getEmployeeId(),
                    employee.getName(),
                    employee.getAddress(),
                    employee.getAge(),
                    employee.getJobDesc(),
                    employee.getPlacement()
                );
            }
        }
        System.out.printf("+-------+--------------+----------------------+---------------------------+------------+----------------------+----------------------+\n");

        System.out.println("tekan enter untuk keluar...");
        input.nextLine();    
    }
    
    public static Employee findById(String emplyeeId) {
        for (Employee employee : employeesList) {
            if (employee.getEmployeeId().equalsIgnoreCase(emplyeeId)) {
                return employee;
            }
        }

        return null;
    }

    public static void editEmployee() {
        System.out.println("Masukkan Employee Id yang akan di edit: ");
        String employeeId = input.nextLine();

        Employee employeeWillEdited = findById(employeeId);

        if (employeeWillEdited != null) {
            System.out.print("Name: ");
            String nama = input.nextLine();
            employeeWillEdited.setName(nama);

            System.out.print("address: ");
            String address = input.nextLine();
            employeeWillEdited.setAddress(address);

            System.out.print("age: ");
            int age = Integer.parseInt(input.nextLine());
            employeeWillEdited.setAge(age);

            System.out.print("job desc: ");
            String jobDesc = input.nextLine();
            employeeWillEdited.setJobDesc(jobDesc);

            System.out.print("placement: ");
            String placement = input.nextLine();
            employeeWillEdited.setPlacement(placement);

            if (employeeWillEdited instanceof Programmer) {
                System.out.print("programming language: ");
                String lang = input.nextLine();
                ((Programmer)employeeWillEdited).setProgrammingLanguage(lang);

                System.out.print("experience: ");
                int expr = Integer.parseInt(input.nextLine());
                ((Programmer)employeeWillEdited).setExperience(expr);
            }

            if (employeeWillEdited instanceof ProjectLeader) {
                System.out.print("total project: ");
                int totalProject = Integer.parseInt(input.nextLine());
                ((ProjectLeader)employeeWillEdited).setTotalProject(totalProject);
            }
        } else {
            System.out.println("employee id tidak ditemukan!");
        }
    }

    public static void deleteEmploye() {
        System.out.print("masukkan emplye id yang akan di hapus: ");
        String emplyeeId = input.nextLine();

        Iterator<Employee> iterator = employeesList.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();

            if (employee.getEmployeeId().equalsIgnoreCase(emplyeeId)) {
                iterator.remove(); // Menghapus elemen dari list
                System.out.println("Employee dengan ID " + emplyeeId + " berhasil dihapus.");
                return; // Keluar dari metode setelah menghapus
            }
        }

        System.out.println("employee id tidak ditemukan!");

    }
}
