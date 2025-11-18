package DesignPatterns.StructuralPattern.Proxy.Solution.ProtectionProxy;

/**
 * Client demonstrates role checks via proxy.
 */
public class Client {
    public static void main(String[] args) {
        AccountService svc = new AccountServiceProxy();
        svc.approveLoan("cust-1", 100000.0, "USER");   // denied
        svc.approveLoan("cust-2", 200000.0, "ADMIN");  // allowed
    }
}
