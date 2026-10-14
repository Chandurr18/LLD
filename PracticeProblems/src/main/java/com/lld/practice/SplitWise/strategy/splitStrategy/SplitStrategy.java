package com.lld.practice.SplitWise.strategy.splitStrategy;

import com.lld.practice.SplitWise.models.Split;
import com.lld.practice.SplitWise.models.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    List<Split> split(double totalAmount, List<User> participants, Map<User, Double> metadata);
}
