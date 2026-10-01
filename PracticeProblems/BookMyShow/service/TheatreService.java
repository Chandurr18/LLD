package service;

import enums.BookingStatus;
import enums.PaymentType;
import lombok.AllArgsConstructor;
import model.Screen;
import model.Seat;
import model.Theatre;
import repository.TheatreRepository;

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
