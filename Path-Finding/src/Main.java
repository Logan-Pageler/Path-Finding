import compass.App;
import maze.Maze;
import maze.generators.MazeGenerator;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Maze maze = new Maze(5, 5);
        System.out.println(maze);

        MazeGenerator gen = new MazeGenerator(5, 5);
        System.out.println(gen.generateMaze());

        gen = gen.setStart(0, 0).setEnd(4, 4);
        System.out.println(gen.generateMaze());

        App app = new App(80);

        app.getDefaultMessage().addHeader("Access-Control-Allow-Origin", "*");

        app.addRoute("/maze", (req, res) -> {
            MazeGenerator gen2 = new MazeGenerator(5, 5);
            res.setBody("<html>" + gen2.generateMaze().toString().replace("\n", "<br>") + "</html>");
        });

        app.addRoute("/ed", (req, res) -> {
            res.setBody("Hi Edward!");
        });

        app.start();
    }
}