/**
 * Represents a room in a maze. Rooms only know which rooms they are connected to.
 */
package maze;

import java.util.HashSet;
import java.util.Set;

public class Room {
    public final Set<Room> CONNECTED;

    public Room() {
        CONNECTED = new HashSet<Room>();
    }
}
