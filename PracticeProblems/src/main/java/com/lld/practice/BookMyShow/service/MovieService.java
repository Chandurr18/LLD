package com.lld.practice.BookMyShow.service;

import lombok.AllArgsConstructor;
import com.lld.practice.BookMyShow.model.Movie;
import com.lld.practice.BookMyShow.repository.MovieRepository;

@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepo;

    public Movie createMovie(String id, String title, int durationMin){
        Movie movie = new Movie(id, title, durationMin);
        movieRepo.save(movie);
        return movie;
    }

    public Movie getMovie(String id) {
        return movieRepo.get(id);
    }
}
