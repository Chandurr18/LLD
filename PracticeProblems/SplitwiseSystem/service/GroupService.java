package service;

import enums.SplitType;
import lombok.AllArgsConstructor;
import models.BalanceSheet;
import models.Group;
import models.User;
import repository.GroupRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final ExpenseService expenseService;
    private final DebtSimplificationService simplifier;

    public String creatGroup(String name, List<User> members){
        String id = UUID.randomUUID().toString();

        Group g = new Group(id, name);
        members.forEach(g::addMember);

        groupRepository.save(g);
        return id;
    }

    public void addMember(String groupId, User user){
        get(groupId).addMember(user);
    }

    public void addExpense(String groupId, String description, double amount, User paidBy, List<User> participants, SplitType splitType, Map<User, Double> meta){
        expenseService.addExpense(get(groupId), description, amount, paidBy, participants, splitType, meta);
    }

    public void simplifyDebt(String groupId){
        simplifier.simplifyDebts(get(groupId));
    }

    public Group get(String id){
        return groupRepository.findByid(id)
                .orElseThrow(() -> new IllegalArgumentException("Group now found: " + id));
    }

    public void printBalances(String groupId) {

        Group group = get(groupId);

        System.out.println("\n========================================");

        for (User user : group.getMembers()) {

            BalanceSheet sheet = group.getBalanceSheet(user);

            double totalOwe = 0.0;
            double totalGet = 0.0;

            // Calculate total owe / get
            for (Map.Entry<User, Double> entry : sheet.getBalances().entrySet()) {

                double amount = entry.getValue();

                if (amount > 0) {
                    totalGet += amount;
                } else {
                    totalOwe += -amount;
                }
            }

            System.out.println("👤 " + user.getName());

            System.out.printf(
                    "Paid: %.2f  Expense: %.2f%n",
                    sheet.getTotalPaid(),
                    sheet.getTotalExpense()
            );

            System.out.printf(
                    "You owe: %.2f, You get: %.2f%n",
                    totalOwe,
                    totalGet
            );

            // Print individual balances
            for (Map.Entry<User, Double> entry : sheet.getBalances().entrySet()) {

                User other = entry.getKey();
                double amount = entry.getValue();

                if (amount > 0) {
                    System.out.printf(
                            "   ← get %.2f %s%n",
                            amount,
                            other.getName()
                    );

                } else if (amount < 0) {
                    System.out.printf(
                            "   → owe %.2f %s%n",
                            -amount,
                            other.getName()
                    );
                }
            }

            System.out.println("----------------------------------------");
        }
    }
}
