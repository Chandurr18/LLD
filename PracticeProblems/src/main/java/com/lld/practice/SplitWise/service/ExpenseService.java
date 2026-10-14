package com.lld.practice.SplitWise.service;

import com.lld.practice.SplitWise.enums.SplitType;
import com.lld.practice.SplitWise.factory.SplitStrategyFactory;
import lombok.AllArgsConstructor;
import com.lld.practice.SplitWise.models.Expense;
import com.lld.practice.SplitWise.models.Group;
import com.lld.practice.SplitWise.models.Split;
import com.lld.practice.SplitWise.models.User;
import com.lld.practice.SplitWise.strategy.splitStrategy.SplitStrategy;

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
