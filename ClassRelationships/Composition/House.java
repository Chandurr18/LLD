package ClassRelationships.Composition;

import java.util.ArrayList;

public class House {
    ArrayList<Room> rooms;

    public House(){
        rooms = new ArrayList<>();
        rooms.add(new Room("BedRoom"));
        rooms.add(new Room("Kitchen"));
    }

    public void showRooms(){
        for(Room room : rooms){
            System.out.println("Room :" + room.getRoomName());
        }
    }
}