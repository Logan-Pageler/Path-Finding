import compass.App;
import compass.http.Session;

public class Test {
    public static void main(String[] args) {
        App<Session> app = new App<>(8080);

        app.addRoute("/stack", (req, res, ses) -> {
            System.out.println(req.toString());
            res.setBody("20");
        });

        app.start();
    }
}
