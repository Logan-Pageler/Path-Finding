/**
 * Represents a room in a maze. Rooms only know which rooms they are connected to.
 */
package maze;

import java.util.HashSet;
import java.util.Set;

public class Room {
    public final Set<Room> CONNECTED;
    private Location loc;

    public Room() {
        CONNECTED = new HashSet<Room>();
        loc = new Location();
    }

    public Room(int x, int y) {
        CONNECTED = new HashSet<Room>();
        loc = new Location(x, y);
    }

    public Room(Location loc) {
        CONNECTED = new HashSet<Room>();
        this.loc = loc;
    }

    public void setLocation(Location loc) {
        this.loc = loc;
    }

    public void setLocation(int x, int y) {
        this.loc = new Location(x, y);
    }

    public Location getLocation() {
        return loc;
    }

}
