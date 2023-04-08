package compass;

import java.util.Map;

import compass.http.HTTPServer;
import compass.http.Message;
import compass.http.Session;
import compass.http.SessionGenerator;
import compass.http.Conversation;

/**
 * API to make a java web server. The default message will be
 * the message given in each conversation for response. It is
 * useful when giving every response specific headers. The
 * pageNotFound message is for when a route doesn't exist. The
 * invalidRequest is for when a HTTP request doesn't match
 * standards. Note if a route is added with and without a type,
 * the one with type gets priority.
 * 
 * @author Logan Pageler
 * @since 3/30/2023
 * @param E session type when using sessions. Default use Session
 */
public class App<E extends Session> {

    private HTTPServer<E> server;

    /**
     * Create new HTTP server application
     * Default threads: 10
     * 
     * @param port port to listen on
     */
    public App(int port) {
        server = new HTTPServer<E>(port);
    }

    /**
     * Create new HTTP server application with certain number of threads.
     * 
     * @param port    port to listen on
     * @param threads number of threads
     */
    public App(int port, int threads) {
        server = new HTTPServer<E>(port, threads);
    }

    /**
     * Adds a route to list
     * 
     * @param route        route path
     * @param conversation route handling
     */
    public void addRoute(String route, Conversation<E> conversation) {
        server.getRoutes().put(route, conversation);
    }

    /**
     * Adds route to route list
     * 
     * @param type         request type
     * @param route        route path
     * @param conversation route handling
     */
    public void addRoute(String type, String route, Conversation<E> conversation) {
        server.getRoutes().put(type + " " + route, conversation);
    }

    /**
     * Sets all the routes
     * 
     * @param routes routes
     */
    public void setRoutes(Map<String, Conversation<E>> routes) {
        server.setRoutes(routes);
    }

    /**
     * Gets page not found message.
     * 
     * @return pageNotFound message
     */
    public Message getPageNotFound() {
        return server.getPageNotFound();
    }

    /**
     * Gets invalid request message.
     * 
     * @return invalid request message
     */
    public Message getInvalidRequested() {
        return server.getInvalidRequested();
    }

    /**
     * Gets default message.
     * 
     * @return default message
     */
    public Message getDefaultMessage() {
        return server.getDefaultMessage();
    }

    /**
     * Starts the application server
     */
    public void start() {
        server.start();
    }

    /**
     * Stops the application server
     */
    public void stop() {
        server.stop();
    }

    /**
     * Function for creating new sessions. If it isn't null
     * this server will follow Keep-Open
     * 
     * @param gen session generator function
     */
    public void addSessionGenerator(SessionGenerator<E> gen) {
        server.addSessionGenerator(gen);
    }

    /**
     * Sets socket timeout in milliseconds
     * 
     * @param timeout Connection timeout in milliseconds
     */
    public void setSoTimeout(int timeout) {
        server.setSoTimeout(timeout);
    }
}
