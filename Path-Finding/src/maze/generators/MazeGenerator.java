/**
 * Generates a new maze based of algorithm and parameter. Maze Generators should be immutable.
 */
package maze.generators;

import maze.Maze;
import util.Point2D;

public class MazeGenerator {

    protected int mutationChance, width, height;
    protected Point2D<Integer> start;
    protected Point2D<Integer> end;

    public MazeGenerator(int width, int height) {
        mutationChance = 0;
        this.width = width;
        this.height = height;

        this.start = new Point2D<Integer>(
                (int) (Math.random() * width),
                (int) (Math.random() * height));

        this.end = new Point2D<Integer>(
                (int) (Math.random() * width),
                (int) (Math.random() * height));

        while (this.end.equals(this.start)) {
            this.end = new Point2D<Integer>(
                    (int) (Math.random() * width),
                    (int) (Math.random() * height));
        }
    }

    protected MazeGenerator(MazeGenerator old) {
        this.mutationChance = old.mutationChance;
        this.width = old.width;
        this.height = old.height;
        this.start = old.start;
        this.end = old.end;
    }

    /**
     * Creates new MazeGenerator with given mutation chance
     * 
     * @param mutationChance chance for a random hallway connection to create
     * @return New MazeGenerator with given property
     */
    public MazeGenerator setMutationChance(int mutationChance) {
        MazeGenerator newGen = new MazeGenerator(this);
        newGen.mutationChance = mutationChance;
        return newGen;
    }

    /**
     * Creates new MazeGenerator with given start
     * 
     * @param x x position of start
     * @param y y position of start
     * @return New MazeGenerator with given property
     */
    public MazeGenerator setStart(int x, int y) {
        MazeGenerator newGen = new MazeGenerator(this);
        newGen.start = new Point2D<Integer>(x, y);
        return newGen;
    }

    /**
     * Creates new MazeGenerator with given end
     * 
     * @param x x position of end
     * @param y y position of end
     * @return New MazeGenerator with given property
     */
    public MazeGenerator setEnd(int x, int y) {
        MazeGenerator newGen = new MazeGenerator(this);
        newGen.end = new Point2D<Integer>(x, y);
        return newGen;
    }

    /**
     * Generates a new maze based off the algorithm implemented.
     * 
     * @return New maze
     */
    public Maze generateMaze() {
        System.out.println(end);
        Maze maze = new Maze(width, height);
        maze.setStart(start);
        maze.setEnd(end);
        return maze;
    }

}