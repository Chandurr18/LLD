package repository;

import models.Group;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryGroupRepository implements GroupRepository{
    private final Map<String, Group> store = new HashMap<>();

    public Optional<Group> findByid(String id){
        return Optional.ofNullable(store.get(id));
    }

    public void save(Group group){
        store.put(group.getId(), group);
    }
}
