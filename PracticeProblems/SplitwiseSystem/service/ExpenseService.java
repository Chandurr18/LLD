package service;

import enums.SplitType;
import factory.SplitStrategyFactory;
import lombok.AllArgsConstructor;
import models.Expense;
import models.Group;
import models.Split;
import models.User;
import strategy.splitStrategy.SplitStrategy;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class ExpenseService {
    private final BalanceSheetService balanceSheetService;

    public void addExpense(Group group, String description, double amount, User paidBy, List<User> participants, SplitType splitType, Map<User, Double> metadata){
        SplitStrategy strategy = SplitStrategyFactory.getStrategy(splitType);
        List<Split> splits = strategy.split(amount, participants, metadata);

        Expense expense = new Expense(description, amount, paidBy, splits, splitType);
        group.addExpense(expense);

        balanceSheetService.updateBalances(group, paidBy, splits);

    }
}
