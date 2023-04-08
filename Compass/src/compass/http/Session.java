package compass.http;

/**
 * Structure for storing data in a session.
 * 
 * @author Logan Pageler
 * @since 4/7/2023
 */
public class Session {
    protected String ip;

    /**
     * Creates new session
     */
    public Session() {

    }

    /**
     * Gets session ip
     * 
     * @return session ip
     */
    public String getIP() {
        return ip;
    }
}
