package solvers;

import java.util.Arrays;

import maze.Location;

public class Path {

    public final Location[] PATH;

    public Path() {
        PATH = new Location[0];
    }

    public Path(Path other) {
        PATH = new Location[other.length()];
        copy(other);
    }

    private Path(int size) {
        PATH = new Location[size];
    }

    private void copy(Path other) {
        for (int i = 0; i < other.length(); i++) {
            PATH[i] = other.PATH[i];
        }
    }

    private int length() {
        return PATH.length;
    }

    public Path addLocation(int x, int y) {
        return addLocation(new Location(x, y));
    }

    private Path addLocation(Location location) {
        Path p = new Path(length() + 1);
        p.copy(this);
        p.PATH[length()] = location;
        return p;
    }

    @Override
    public String toString() {
        return Arrays.toString(PATH);

    }

}
