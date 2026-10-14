package com.lld.practice.BookMyShow.repository;

import java.util.HashMap;
import java.util.Map;

import com.lld.practice.BookMyShow.model.Movie;


public class MovieRepository {
    private final Map<String, Movie> movies = new HashMap<>();

    public void save(Movie movie){
        movies.put(movie.getId(), movie);
    }

    public Movie get(String id){
        return movies.get(id);
    }
}
