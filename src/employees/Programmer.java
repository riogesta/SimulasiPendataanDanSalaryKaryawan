package employees;

public class Programmer extends Employee {
    private String programmingLanguage;
    private int experience;
    private int allowance;

    public Programmer(
        String name,
        String address,
        int age,
        String employeeId,
        int salary,
        String jobDesc,
        String placement,
        String programmingLanguage,
        int experience,
        int allowance
    ) {
        super(name, address, age, employeeId, salary, jobDesc, placement);
        this.programmingLanguage = programmingLanguage;
        this.experience = experience;
        this.allowance = allowance;
    }

    public String getProgrammingLanguage() {
        return this.programmingLanguage;
    }

    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAllowance() {
        return this.allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
}
