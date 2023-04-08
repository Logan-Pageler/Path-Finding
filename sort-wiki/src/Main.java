import compass.App;
import compass.http.Session;
import maze.generators.MazeGenerator;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        App<Session> app = new App<Session>(8000);

        app.getDefaultMessage().addHeader("Access-Control-Allow-Origin", "*");

        app.addRoute("/maze", (req, res, ses) -> {
            System.out.println(req);
            MazeGenerator gen2 = new MazeGenerator(5, 5);
            res.setBody("<html>" + gen2.generateMaze().toString().replace("\n", "<br>") +
                    "</html>");
        });

        app.addRoute("/ed", (req, res, ses) -> {
            res.setBody("Hi Edward!");
        });

        app.start();
    }
}