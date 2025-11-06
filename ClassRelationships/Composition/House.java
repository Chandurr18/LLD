package ClassRelationships.Composition;

import java.util.ArrayList;
import java.util.List;

/**
 * Composition (OWNS-A):
 * House strongly owns Rooms.
 * If House is destroyed, Rooms cannot logically exist.
 */
public class House {

    private List<Room> rooms;

    public House() {
        rooms = new ArrayList<>();
        rooms.add(new Room("Bedroom"));
        rooms.add(new Room("Kitchen"));

        System.out.println("House created with default rooms.");
    }

    public void showRooms() {
        System.out.println("Rooms in this house:");
        for (Room room : rooms) {
            System.out.println("- " + room.getRoomName());
        }
    }

    /**
     * Emulates destruction of the house.
     * Rooms lose meaning afterward.
     */
    public void demolishHouse() {
        System.out.println("House demolished. Rooms destroyed.");
        rooms.clear();
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
