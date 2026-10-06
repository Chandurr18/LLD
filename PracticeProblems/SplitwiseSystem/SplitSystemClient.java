import enums.SplitType;
import models.User;
import repository.InMemoryGroupRepository;
import service.BalanceSheetService;
import service.DebtSimplificationService;
import service.ExpenseService;
import service.GroupService;

import java.util.List;

public class SplitSystemClient {
    public static void main(String[] args) {
        // Users
        User alice = new User("u1", "Alice");
        User bob = new User("u2", "Bob");
        User tom = new User("u1", "Tom");
        User jake = new User("u1", "Jake");

        InMemoryGroupRepository repo = new InMemoryGroupRepository();
        BalanceSheetService balanceSheetService = new BalanceSheetService();
        ExpenseService expenseService = new ExpenseService(balanceSheetService);
        DebtSimplificationService simplificationService = new DebtSimplificationService();

        GroupService groupService = new GroupService(repo, expenseService, simplificationService);

        /* ----------- Create Group ----------- */
        String goaGroupId = groupService.creatGroup("Goa Trip", List.of(alice, bob, tom));
        String miscGroup = groupService.creatGroup("Non-Expense Group", List.of(alice, bob, tom, jake));

        /* ----------- Add Expense ----------- */
        groupService.addExpense(goaGroupId, "Lunch Day-1", 100, alice, List.of(alice, bob), SplitType.EQUAL, null);
        groupService.addExpense(goaGroupId, "Lunch Day-2", 100, bob, List.of(bob, tom), SplitType.EQUAL, null);

        /* ----------- Simplify & Print ----------- */
        groupService.simplifyDebt(goaGroupId);
        groupService.printBalances(goaGroupId);
    }
}
