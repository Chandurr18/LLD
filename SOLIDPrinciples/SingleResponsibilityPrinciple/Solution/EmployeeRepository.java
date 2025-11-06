package SOLIDPrinciples.SingleResponsibilityPrinciple.Solution;

/**
 * Responsible ONLY for database operations related to Employee.
 */
public class EmployeeRepository {

    public void save(Employee employee){
        // JDBC / ORM code to save employee to database
        System.out.println("Employee saved to database.");
    }
}
