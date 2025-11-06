package ClassRelationships.Composition;

/**
 * Composition:
 * Room cannot exist without the House that creates it.
 */
public class Room {

    private String roomName;

    public Room(String roomName) {
        this.roomName = roomName;
        System.out.println("Room created: " + roomName);
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void use() {
        System.out.println("Using room: " + roomName);
    }
}
