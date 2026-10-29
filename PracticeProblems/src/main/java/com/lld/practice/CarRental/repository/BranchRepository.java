package com.lld.practice.CarRental.repository;

import com.lld.practice.CarRental.model.Branch;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BranchRepository {
    private final Map<String, Branch> branches = new HashMap<>();

    public void addBranch(Branch branch) {
        branches.put(branch.getId(), branch);
    }

    public void removeBranch(Branch branch) {
        branches.remove(branch.getId());
    }

    public Optional<Branch> getBranchById(String id){
        return Optional.ofNullable(branches.get(id));
    }
}
