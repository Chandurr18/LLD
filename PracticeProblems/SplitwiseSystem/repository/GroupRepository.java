package repository;

import models.Group;

import java.util.Optional;

// Dependency Inversion Principle
public interface GroupRepository {
    Optional<Group> findByid(String id);
    void save(Group group);
}
