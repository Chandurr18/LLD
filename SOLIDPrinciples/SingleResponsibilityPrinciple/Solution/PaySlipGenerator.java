package SOLIDPrinciples.SingleResponsibilityPrinciple.Solution;

/**
 * Responsible ONLY for generating payslips/reports.
 */
public class PaySlipGenerator {

    public String generate(Employee employee){
        // PDF/HTML formatting logic
        return "PaySlip for " + employee.getEmployeeName() +
                ": $" + employee.calculateSalary();
    }
}
