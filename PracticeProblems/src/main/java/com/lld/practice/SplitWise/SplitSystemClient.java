package com.lld.practice.SplitWise;

import com.lld.practice.SplitWise.enums.SplitType;
import com.lld.practice.SplitWise.models.User;
import com.lld.practice.SplitWise.repository.InMemoryGroupRepository;
import com.lld.practice.SplitWise.service.BalanceSheetService;
import com.lld.practice.SplitWise.service.DebtSimplificationService;
import com.lld.practice.SplitWise.service.ExpenseService;
import com.lld.practice.SplitWise.service.GroupService;

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
