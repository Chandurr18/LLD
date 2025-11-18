/**
 * BankAccountService (Problem)
 * No authorization checks; client directly invokes sensitive operations.
 */
public class BankAccountService {
    public boolean approveLoan(String userId, double amount) {
        System.out.println("[BankAccountService] Approving loan of " + amount + " for " + userId);
        return true;
    }
}
