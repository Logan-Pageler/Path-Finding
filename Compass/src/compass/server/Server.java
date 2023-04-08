
package compass.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/**
 * Basic java server. Uses a Consumer passed a socket object
 * to handle connections. Listens for only 1 port,and can
 * only handle the threads amount of connections at a time.
 * Other connections will be forced to wait.
 * 
 * @author Logan Pageler
 * @since 3/30/2023
 */
public class Server implements Runnable {

    private int port, threads;
    private Consumer<Socket> clientHandler;
    private Thread serverThread;
    private AtomicBoolean running;

    /**
     * Create server to listen on port
     * Default threads: 10
     * 
     * @param port port to listen on
     */
    public Server(int port) {
        this.port = port;
        this.threads = 10;
        running = new AtomicBoolean(false);
    }

    /**
     * Create server to listen port with a certain amount of threads
     * 
     * @param port    port to listen on
     * @param threads max number of threads
     */
    public Server(int port, int threads) {

        this.threads = threads;
        this.port = port;
        running = new AtomicBoolean(false);
    }

    /**
     * Sets the handler on connection
     * 
     * @param clientHandler function to handle connections
     */
    public void SetHandler(Consumer<Socket> clientHandler) {
        this.clientHandler = clientHandler;
    }

    /**
     * Start the server
     */
    public void start() {
        serverThread = new Thread(this);
        serverThread.start();
        running.set(true);
    }

    /**
     * Stop the server
     */
    public void stop() {
        running.set(false);
    }

    /**
     * Check if server is running
     * 
     * @return boolean wether server is running
     */
    public boolean isRunning() {
        return running.get();
    }

    @Override
    public void run() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(threads);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (running.get()) {
                Socket connectionSocket = serverSocket.accept();
                executor.submit(() -> {
                    if (clientHandler != null)
                        clientHandler.accept(connectionSocket);
                    try {
                        connectionSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
