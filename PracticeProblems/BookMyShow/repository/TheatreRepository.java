package repository;

import model.Theatre;

import java.util.HashMap;
import java.util.Map;

public class TheatreRepository {
    private final Map<String, Theatre> theatres = new HashMap<>();

    public void save(Theatre theatre){
        theatres.put(theatre.getId(), theatre);
    }

    public Theatre get(String id){
        return theatres.get(id);
    }
}
