import compass.App;
import compass.http.Session;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        App<Session> app = new App<Session>(8000);

        app.getDefaultMessage().addHeader("Access-Control-Allow-Origin", "*");

        app.addRoute("/", (req, res, ses) -> {
            System.out.println(req);
            res.setBody("Hello Word!");
        });

        app.addRoute("/ed", (req, res, ses) -> {
            res.setBody("Hi Edward!");
        });

        app.start();
    }
}