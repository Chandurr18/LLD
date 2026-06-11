package controller.dto;

public class ExitResult {
    private final boolean isSuccess;
    private String ticketId;
    private double fee;
    private String message;

    public ExitResult(boolean isSuccess, String ticketId, double fee, String message) {
        this.isSuccess = isSuccess;
        this.ticketId = ticketId;
        this.fee = fee;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getFee() {
        return fee;
    }

    public String getMessage() {
        return message;
    }
}
