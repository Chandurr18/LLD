package model;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class Show {
    private final String id;
    private final Movie movie;
    private final Screen screen;
    private final Theatre theatre;
    private final Date start;
    private final Date end;

    public List<Seat> getSeats() {
        return screen.getSeats();
    }


}
