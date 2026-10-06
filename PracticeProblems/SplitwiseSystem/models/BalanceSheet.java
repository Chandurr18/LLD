package models;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class BalanceSheet {
    private double totalPaid = 0.0;
    private double totalExpense = 0.0;
    private final Map<User, Double> balances = new HashMap<>();

    public void addTotalPaid(double amount){
        this.totalPaid += amount;
    }

    public void addTotalExpense(double amount){
        this.totalExpense += amount;
    }

    public void addBalance(User other, double amount){
        balances.put(other, balances.getOrDefault(other, 0.0) + amount);
        if(Math.abs(balances.get(other)) < 1e-6) balances.remove(other);
    }

    public void clearBalances(){
        balances.clear();
    }


}
