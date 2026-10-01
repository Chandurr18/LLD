package repository;

import java.util.HashMap;
import java.util.Map;

import model.Movie;


public class MovieRepository {
    private final Map<String, Movie> movies = new HashMap<>();

    public void save(Movie movie){
        movies.put(movie.getId(), movie);
    }

    public Movie get(String id){
        return movies.get(id);
    }
}
