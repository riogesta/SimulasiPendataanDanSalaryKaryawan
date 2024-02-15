import repositories.RepositoryEmployee;
import view.TermUI;

public class App {
    public static void main(String[] args) throws Exception {
        RepositoryEmployee employees = new RepositoryEmployee();
        employees.initializeDummyData();

        TermUI.conditionOption();
    }
}
