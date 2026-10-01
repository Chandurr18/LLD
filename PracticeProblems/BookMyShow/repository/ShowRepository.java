package repository;

import model.Show;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowRepository {
    private final Map<String, Show> shows = new HashMap<>();

    public void save(Show show){
        shows.put(show.getId(), show);
    }

    public Show get(String id){
        return shows.get(id);
    }

    public List<Show> getAll(){
        return new ArrayList<>(shows.values());
    }
}
