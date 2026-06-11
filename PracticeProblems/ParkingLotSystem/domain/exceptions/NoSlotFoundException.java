package domain.exceptions;

public class NoSlotFoundException extends RuntimeException{
    public NoSlotFoundException(){
        super("No Parking Slot Found");
    }

    public NoSlotFoundException(String message){
        super(message);
    }
}
