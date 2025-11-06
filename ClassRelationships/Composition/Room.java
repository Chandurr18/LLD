package ClassRelationships.Composition;

public class Room {
    private String roomName;

    Room(String roomName){
        this.roomName = roomName;
    }

    public String getRoomName(){
        return this.roomName;
    }
}