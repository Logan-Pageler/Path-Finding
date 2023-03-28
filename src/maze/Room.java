/**
 * Represents a room in a maze. Rooms only know which rooms they are connected to.
 */
package maze;

import java.util.ArrayList;
import java.util.List;

public class Room {
    public final List<Room> CONNECTED;

    public Room() {
        CONNECTED = new ArrayList<Room>();

    }
}
