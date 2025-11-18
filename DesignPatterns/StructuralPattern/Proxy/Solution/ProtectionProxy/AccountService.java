package DesignPatterns.StructuralPattern.Proxy.Solution.ProtectionProxy;

/**
 * Subject: AccountService - sensitive banking operations.
 */
public interface AccountService {
    boolean approveLoan(String userId, double amount, String role);
}
