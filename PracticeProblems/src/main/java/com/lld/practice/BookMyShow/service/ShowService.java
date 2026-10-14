package com.lld.practice.BookMyShow.service;

import lombok.AllArgsConstructor;
import com.lld.practice.BookMyShow.model.Movie;
import com.lld.practice.BookMyShow.model.Screen;
import com.lld.practice.BookMyShow.model.Show;
import com.lld.practice.BookMyShow.model.Theatre;
import com.lld.practice.BookMyShow.repository.MovieRepository;
import com.lld.practice.BookMyShow.repository.ShowRepository;
import com.lld.practice.BookMyShow.repository.TheatreRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ShowService {
    private final ShowRepository showRepo;
    private final TheatreRepository theatreRepo;
    private final MovieRepository movieRepo;

    public Show createShow(String showId, String movieId, String screenId, String theatreId, Date start){
        Movie movie = movieRepo.get(movieId);
        Theatre theatre = theatreRepo.get(theatreId);
        Screen screen = theatre.getScreen(screenId);

        Date end = new Date(start.getTime() + movie.getDurationMin() * 60L * 1000);

        Show show = new Show(showId, movie, screen, theatre, start, end);
        showRepo.save(show);

        return show;
    }

    public List<Show> getShowsByMovieTitle(String title){
        return showRepo.getAll().stream()
                .filter(show -> show.getMovie().getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }
}
