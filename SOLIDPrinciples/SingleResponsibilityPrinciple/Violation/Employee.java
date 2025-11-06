package SOLIDPrinciples.SingleResponsibilityPrinciple.Violation;

/**
 * This Employee class violates SRP because:
 * - It calculates salary (business logic)
 * - Saves data to database (persistence)
 * - Generates payslip (report generation)
 * - Sends payslip via email (communication)
 *
 * Any change in these concerns will force this class to change.
 */
public class Employee {

    private String employeeName;
    private double baseSalary;

    public Employee(String employeeName, double baseSalary){
        this.employeeName = employeeName;
        this.baseSalary = baseSalary;
    }

    // Business Logic
    public double calculateSalary(){
        // Complex tax and deduction logic
        return baseSalary * 0.9;
    }

    // Persistence
    public void saveToDatabase(){
        // JDBC / ORM code or database schema changes
    }

    // Reporting
    public void generatePaySlip(){
        // Generate PDF/HTML/export format change
    }

    // Communication
    public void sendPaySlipToEmail(){
        // SMTP server settings / template changes
    }
}
