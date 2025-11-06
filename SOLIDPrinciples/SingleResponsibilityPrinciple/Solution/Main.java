package SOLIDPrinciples.SingleResponsibilityPrinciple.Solution;

public class Main {
    public static void main(String[] args) {

        Employee employee = new Employee("John", 50000);

        EmployeeRepository repository = new EmployeeRepository();
        PaySlipGenerator paySlipGenerator = new PaySlipGenerator();
        EmailService emailService = new EmailService();

        String payslip = paySlipGenerator.generate(employee);

        // Responsibilities handled by respective classes
        repository.save(employee);
        emailService.sendEmail(employee.getEmployeeName(), payslip);

        System.out.println(payslip);
    }
}
