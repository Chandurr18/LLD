package Exceptions;

public class SeatNotAvailableExeception extends Throwable {
    public SeatNotAvailableExeception(String description) {
        super(description);
    }
}
