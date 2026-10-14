package com.lld.practice.SplitWise.repository;

import com.lld.practice.SplitWise.models.Group;

import java.util.Optional;

// Dependency Inversion Principle
public interface GroupRepository {
    Optional<Group> findByid(String id);
    void save(Group group);
}
