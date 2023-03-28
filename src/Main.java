import maze.Maze;
import maze.generators.MazeGenerator;

public class Main {
    public static void main(String[] args) {

        Maze maze = new Maze(5, 5);
        System.out.println(maze);

        MazeGenerator gen = new MazeGenerator(5, 5);
        System.out.println(gen.generateMaze());

        gen = gen.setStart(0, 0).setEnd(4, 4);
        System.out.println(gen.generateMaze());
    }
}