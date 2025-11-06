package SOLIDPrinciples.SingleResponsibilityPrinciple.Solution;

/**
 * Employee now has a single responsibility:
 * Represent employee data + calculate salary.
 */
public class Employee {

    private String employeeName;
    private double baseSalary;

    public Employee(String employeeName, double baseSalary){
        this.employeeName = employeeName;
        this.baseSalary = baseSalary;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Business logic
    public double calculateSalary(){
        // Complex tax and deduction logic
        return baseSalary * 0.9;
    }
}
