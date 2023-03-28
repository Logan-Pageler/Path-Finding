/**
 * Represents a point in 2D space. This point can be of any type.
 */
package util;

public class Point2D<E> {

    public final E X, Y;

    public Point2D(E x, E y) {
        this.X = x;
        this.Y = y;
    }

    /**
     * Checks if tis point equals another point
     * 
     * @param x x value of other point
     * @param y y value of other point
     * @return boolean wether true
     */
    public boolean equals(E x, E y) {
        return this.X.equals(x) && this.Y.equals(y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point2D) {
            Point2D point = (Point2D) obj;
            return this.X.equals(point.X) && this.Y.equals(point.Y);
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getClass() + "(" + X + ", " + Y + ")";
    }
}
