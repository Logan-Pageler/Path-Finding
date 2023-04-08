package compass.http;

import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import compass.server.Server;

/**
 * Simple java http server.
 * 
 * @author Logan Pageler
 * @since 3/30/2023
 * @param <E> session type when using sessions. Default use Session
 */
public class HTTPServer<E extends Session> {

    private Server server;
    private ClientHandler<E> handler;

    /**
     * Creates an HTTP port on given port
     * 
     * @param port port number
     */
    public HTTPServer(int port) {
        handler = new ClientHandler<E>(new ConcurrentHashMap<String, Conversation<E>>());
        server = new Server(port);
        setDefaults();
    }

    /**
     * Creates and HTTP port on given port with given amount of threads to listen
     * for.
     * 
     * @param port    port number
     * @param threads max number of threads to start
     */
    public HTTPServer(int port, int threads) {
        handler = new ClientHandler<E>(new ConcurrentHashMap<String, Conversation<E>>());
        server = new Server(port, threads);
        setDefaults();
    }

    private void setDefaults() {
        handler.defaultMessage = new Message();
        handler.defaultMessage.getHeaders().put("Content-Type", "text/html; charset=UTF-8");
        handler.defaultMessage.setBody("Success!");

        handler.invalidRequest = new Message();
        handler.invalidRequest.setCode(400);
        handler.invalidRequest.setStatus("Bad Request");
        handler.invalidRequest.setBody("Invalid Request");

        handler.pageNotFound = new Message();
        handler.pageNotFound.setCode(404);
        handler.pageNotFound.setStatus("Not Found");
        handler.pageNotFound.setBody("Page Not Found");

        handler.timeout = 100000;

        server.SetHandler((Socket connection) -> {
            new ClientHandler<E>(handler).accept(connection);
        });
    }

    /**
     * Sets routes
     * 
     * @param routes map of routes and there functions
     */
    public void setRoutes(Map<String, Conversation<E>> routes) {
        handler.routes.clear();
        handler.routes.putAll(routes);
    }

    /**
     * Gets map of all routes
     * 
     * @return map of all routes
     */
    public ConcurrentMap<String, Conversation<E>> getRoutes() {
        return handler.routes;
    }

    /**
     * Starts the server
     */
    public void start() {
        server.start();
    }

    /**
     * Stops the server
     */
    public void stop() {
        server.stop();
    }

    /**
     * Gets page not found message.
     * 
     * @return pageNotFound message
     */
    public Message getPageNotFound() {
        return handler.pageNotFound;
    }

    /**
     * Gets invalid request message.
     * 
     * @return invalid request message
     */
    public Message getInvalidRequested() {
        return handler.invalidRequest;
    }

    /**
     * Gets default message.
     * 
     * @return default message
     */
    public Message getDefaultMessage() {
        return handler.defaultMessage;
    }

    /**
     * Function for creating new sessions. If it isn't null
     * this server will follow Keep-Open
     * 
     * @param gen session generator function
     */
    public void addSessionGenerator(SessionGenerator<E> gen) {
        handler.gen = gen;
    }

    /**
     * Sets socket timeout in milliseconds
     * 
     * @param timeout Connection timeout in milliseconds
     */
    public void setSoTimeout(int timeout) {
        handler.timeout = timeout;
    }
}