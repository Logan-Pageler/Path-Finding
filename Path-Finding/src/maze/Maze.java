package maze;

import util.Point2D;

/**
 * Represents a maze. Mazes are composed of connected rooms. Mazes should have a
 * start and a finish. This maze is able to be printed as a 2D maze. It can
 * represent a more complex maze, but will not be able to print it properly (ie.
 * nonadjacent rooms could be connected, but its print will not reflect that).
 */

public class Maze {
    public static final String WALL = "X";
    public static final String EMPTY = "_";
    public static final String START = "S";
    public static final String END = "F";

    protected Room[][] grid;
    protected int width, height;
    private Point2D<Integer> start;
    private Point2D<Integer> end;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;

        this.start = new Point2D<Integer>(-1, -1);
        this.end = new Point2D<Integer>(-1, -1);

        grid = new Room[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                grid[y][x] = new Room();
            }
        }
    }

    /**
     * Set the start of maze
     * 
     * @param start point representation of starting room.
     */
    public void setStart(Point2D<Integer> start) {
        this.start = start;
    }

    /**
     * Set end of maze
     * 
     * @param end point representation of ending room.
     */
    public void setEnd(Point2D<Integer> end) {
        this.end = end;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        String out = " ";
        String row1 = " ";
        for (int x = 0; x < width; x++) {
            out += " " + x;
            row1 += WALL + WALL;
        }
        out += "\n" + row1 + WALL + "\n";

        for (int y = 0; y < height; y++) {
            out += rowToString(y);
        }

        return out;
    }

    /**
     * Helper to print 1 row of the maze
     * 
     * @param y the y level of the row
     * @return the row as a string
     */
    private String rowToString(int y) {
        String out = y + WALL;
        for (int x = 0; x < width - 1; x++) {
            // room

            if (start.equals(x, y)) {
                out += START;
            } else if (end.equals(x, y)) {
                out += END;
            } else {
                out += EMPTY;
            }

            // hallway
            if (grid[y][x].CONNECTED.contains(grid[y][x + 1])) {
                out += EMPTY;
            } else {
                out += WALL;
            }
        }

        if (start.equals(width - 1, y)) {
            out += START + WALL + "\n " + WALL;
        } else if (end.equals(width - 1, y)) {
            out += END + WALL + "\n " + WALL;
        } else {
            out += EMPTY + WALL + "\n " + WALL;
        }

        if (y < width - 1) {
            for (int x = 0; x < width; x++) {
                // hallway
                if (grid[y][x].CONNECTED.contains(grid[y + 1][x])) {
                    out += EMPTY + WALL;
                } else {
                    out += WALL + WALL;
                }
            }
        } else {
            for (int x = 0; x < width; x++) {
                out += WALL + WALL;
            }
        }
        out += "\n";
        return out;

    }
}
