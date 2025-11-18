package DesignPatterns.StructuralPattern.Proxy.Solution.ProtectionProxy;

/**
 * Protection proxy enforcing role-based access.
 */
public class AccountServiceProxy implements AccountService {
    private final RealAccountService real = new RealAccountService();

    @Override
    public boolean approveLoan(String userId, double amount, String role) {
        if (!"ADMIN".equals(role)) {
            System.out.println("[AccountServiceProxy] Access denied for role: " + role);
            return false;
        }
        System.out.println("[AccountServiceProxy] Access granted for " + userId);
        return real.approveLoan(userId, amount, role);
    }
}
