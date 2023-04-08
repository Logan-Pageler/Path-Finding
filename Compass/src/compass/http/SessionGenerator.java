package compass.http;

/**
 * Function for generating new sessions.
 * 
 * @author Logan Pageler
 * @since 4/7/2023
 * @param <E> session type when using sessions. Default use Session
 */
@FunctionalInterface
public interface SessionGenerator<E extends Session> {
    /**
     * Generate session
     * 
     * @return return new session
     */
    public E apply();
}
