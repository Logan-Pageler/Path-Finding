package compass.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Consumer;

/**
 * Class to handle http clients.
 * 
 * @author Logan Pageler
 * @since 4/7/2023
 * @param <E> session type when using sessions. Default use Session
 */
public class ClientHandler<E extends Session> implements Consumer<Socket> {

    protected ConcurrentMap<String, Conversation<E>> routes;

    protected Message pageNotFound, invalidRequest, defaultMessage;

    protected SessionGenerator<E> gen;
    protected E session;

    protected Message response, request;
    protected int timeout;

    protected BufferedReader in;
    protected PrintWriter out;

    /**
     * Creates a client handler with routes
     * 
     * @param routes routes to route to.
     */
    public ClientHandler(ConcurrentMap<String, Conversation<E>> routes) {
        this.routes = routes;
        session = null;
        gen = null;
    }

    /**
     * Client handler copy constructor.
     * 
     * @param handler handler to copy
     */
    public ClientHandler(ClientHandler<E> handler) {
        this.routes = handler.routes;
        this.pageNotFound = handler.pageNotFound;
        this.invalidRequest = handler.invalidRequest;
        this.defaultMessage = handler.defaultMessage;
        this.timeout = handler.timeout;
        session = null;
        gen = null;
        if (handler.gen != null) {
            this.gen = handler.gen;
        }

    }

    @Override
    public void accept(Socket connectionSocket) {
        boolean keepAlive = false;
        if (gen != null) {
            keepAlive = true;
            this.session = gen.apply();
            this.session.ip = connectionSocket.getRemoteSocketAddress().toString();
        }
        try {
            connectionSocket.setSoTimeout(timeout);
            in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream(), "UTF-8"));
            out = new PrintWriter(connectionSocket.getOutputStream(), true);
            do {

                readMessage();
                handleMessage();
                addHeaders(keepAlive);
                out.print(response);
                out.flush();

            } while (session != null);
            close();
        } catch (IOException e) {
            // e.printStackTrace();
        }

    }

    private Message readMessage() throws IOException {
        request = new Message();

        String line;
        while ((line = in.readLine()) != null && !request.parseLine(line))
            ;

        return request;
    }

    private void close() throws IOException {
        in.close();
        out.close();
    }

    private void handleMessage() throws IOException {
        // Invalid request
        if (!request.isValid()) {
            response = new Message(invalidRequest);
            return;
        }

        response = new Message(defaultMessage);

        if (routes.containsKey(request.getType() + " " + request.getRoute())) {
            routes.get(request.getType() + " " + request.getRoute()).apply(request, response, session);
        } else if (routes.containsKey(request.getRoute())) {
            routes.get(request.getRoute()).apply(request, response, session);
        } else {
            // Page not found
            response = new Message(pageNotFound);
            return;
        }

    }

    private void addHeaders(boolean keepAlive) throws UnsupportedEncodingException {
        String body = response.getBody();
        if (!response.getHeaders().containsKey("Content-Length") && body != null) {
            response.getHeaders().put("Content-Length", "" + body.getBytes("UTF-8").length);
        }

        if (keepAlive) {
            response.getHeaders().put("Connection", "keep-alive");
            response.getHeaders().put("Keep-Alive", "timeout=" + timeout / 1000 + ", max=1000");
        }

    }

}
