package com.lld.practice.SplitWise.service;

import com.lld.practice.SplitWise.models.Group;
import com.lld.practice.SplitWise.models.Split;
import com.lld.practice.SplitWise.models.User;

import java.util.List;

public class BalanceSheetService {
    public void updateBalances(Group group, User paidBy, List<Split> splits){
        double totalAmount = splits.stream().mapToDouble(Split::getAmount).sum();

        group.getBalanceSheet(paidBy).addTotalPaid(totalAmount);

        for(Split split: splits){
            User user = split.getUser();
            double amt = split.getAmount();
            group.getBalanceSheet(user).addTotalExpense(amt);

            if(!user.equals(paidBy)){
                group.getBalanceSheet(user).addBalance(paidBy, -amt);
                group.getBalanceSheet(paidBy).addBalance(user, amt);
            }
        }
    }
}
