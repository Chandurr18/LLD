package controller.dto;

public class EntryResult {
    private final boolean isSuccess;
    private String ticketId;
    private int spotId;
    private String message;

    public EntryResult(boolean isSuccess, String ticketId, int spotid, String message) {
        this.isSuccess = isSuccess;
        this.ticketId = ticketId;
        this.spotId = spotid;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getTicketId() {
        return ticketId;
    }

    public int getSpotId() {
        return spotId;
    }

    public String getMessage() {
        return message;
    }
}