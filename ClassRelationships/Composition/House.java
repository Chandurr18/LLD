// Composition (owns-a, whole–part with dependent lifecycle) is a strong whole-part relationship where the part cannot logically or physically exist without the whole, and dies when the whole is destroyed.
// Composition → owns (strong ownership)

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