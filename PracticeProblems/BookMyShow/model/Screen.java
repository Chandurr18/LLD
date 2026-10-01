package model;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Screen {
    private final String id;
    private final Map<String, Seat> seats;

    public Screen(String id){
        this.id = id;
        seats = new HashMap<>();
    }

    public void addSeat(Seat seat){
        seats.put(seat.getId(), seat);
    }

    public List<Seat> getSeats(){
        return new ArrayList<>(seats.values());
    }
}
