package service;


import models.BalanceSheet;
import models.Group;
import models.User;

import java.util.*;

/**
 * Greedy Solution ----> Accurate + Factorial TC
 * DFS -----> Fails some EdgeCases + Fast O(N + KlogK)
 * **/

public class DebtSimplificationService {
    public void simplifyDebts(Group group){
        List<User> users = new ArrayList<>(group.getMembers());
        Map<User, BalanceSheet> sheets = group.getBalanceSheets();

        // Step-1 : Calculate net balances for each user
        Map<User, Double> netBalances = new HashMap<>();
        for(User user: users){
            double net = 0.0;
            Map<User, Double> balances = sheets.get(user).getBalances();

            for(double amount : balances.values()){
                net += amount;
            }

            netBalances.put(user, net);
            sheets.get(user).clearBalances(); // Clear old balances before recomputing;
        }

        // Step-2 : Separate creditors(MaxHeap) and debtors(MinHeap)
        PriorityQueue<User> creditors = new PriorityQueue<>((a, b) -> Double.compare(netBalances.get(b), netBalances.get(a)));
        PriorityQueue<User> debtors = new PriorityQueue<>((a, b) -> Double.compare(netBalances.get(a), netBalances.get(b)));

        for(User user: users){
            double net = netBalances.get(user);
            if(net > 0){
                creditors.offer(user);
            } else if(net  < 0){
                debtors.offer(user);
            }
        }

        // Step-3 : Match Min Debtor and Max Creditor to settle debts
        while(!creditors.isEmpty() && !debtors.isEmpty()) {
            User creditor = creditors.poll();
            User debtor = debtors.poll();

            double creditAmount = netBalances.get(creditor);
            double debitAmount = netBalances.get(debtor);

            double settledAmount = Math.min(creditAmount, -debitAmount);

            // update balances both sides
            sheets.get(creditor).addBalance(debtor, settledAmount);
            sheets.get(debtor).addBalance(creditor, -settledAmount);

            // update net balances after settlement
            netBalances.put(creditor, creditAmount - settledAmount);
            netBalances.put(debtor, debitAmount + settledAmount);

            // If still unsettled, re-add to queues
            if (netBalances.get(creditor) > 0) {
                creditors.offer(creditor);
            }

            if (netBalances.get(debtor) < 0) {
                debtors.offer(debtor);
            }
        }
    }
}
