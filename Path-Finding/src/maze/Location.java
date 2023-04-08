package maze;

import javax.print.DocFlavor.STRING;

public class Location {
    public final int X;
    public final int Y;

    public Location() {
        this.X = 0;
        this.Y = 0;
    }

    public Location(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public Location(Location loc) {
        this.X = loc.X;
        this.Y = loc.Y;
    }

    @Override
    public String toString() {
        return "[" + X + ", " + Y + "]";
    }
}
