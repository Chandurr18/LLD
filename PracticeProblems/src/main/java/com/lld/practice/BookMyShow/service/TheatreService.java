package com.lld.practice.BookMyShow.service;

import com.lld.practice.BookMyShow.enums.BookingStatus;
import com.lld.practice.BookMyShow.enums.PaymentType;
import lombok.AllArgsConstructor;
import com.lld.practice.BookMyShow.model.Screen;
import com.lld.practice.BookMyShow.model.Seat;
import com.lld.practice.BookMyShow.model.Theatre;
import com.lld.practice.BookMyShow.repository.TheatreRepository;

import java.util.List;

@AllArgsConstructor
public class TheatreService {
    private final TheatreRepository theatreRepo;

    public Theatre createTheatre(String id, String name){
        Theatre theatre = new Theatre(id, name);
        theatreRepo.save(theatre);

        return theatre;
    }

    public Theatre getTheatre(String theatreId){
        return theatreRepo.get(theatreId);
    }

    public void addScreen(String theatreId, Screen screen){
        Theatre theatre = getTheatre(theatreId);
        theatre.addScreen(screen);
    }

    public void addSeat(String theatreId, String screenId, Seat seat){
        Theatre theatre = getTheatre(theatreId);
        Screen screen = theatre.getScreen(screenId);
        screen.addSeat(seat);
    }

}
