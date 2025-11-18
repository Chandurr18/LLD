/**
 * Client (Problem) - client directly calls approveLoan (sensitive)
 */
public class Client {
    public static void main(String[] args) {
        BankAccountService svc = new BankAccountService();
        svc.approveLoan("customer-123", 250000.0); // no role checks
    }
}
