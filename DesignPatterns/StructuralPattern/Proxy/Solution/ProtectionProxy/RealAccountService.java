package DesignPatterns.StructuralPattern.Proxy.Solution.ProtectionProxy;

/**
 * RealAccountService - performs loan approval.
 */
public class RealAccountService implements AccountService {
    @Override
    public boolean approveLoan(String userId, double amount, String role) {
        System.out.println("[RealAccountService] Loan approved for " + userId + " amount " + amount);
        return true;
    }
}
