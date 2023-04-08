package compass.http;

/**
 * Function to handle incoming and outgoing requests.
 * Given two messages, the request and response.
 * Call response message to change what is sent back
 * 
 * @author Logan Pageler
 * @since 4/7/2023
 * @param <E> session type when using sessions. Default use Session
 */
@FunctionalInterface
public interface Conversation<E extends Session> {
    /**
     * Handle conversation
     * 
     * @param request  Incoming request message
     * @param response Outgoing request message
     * @param session  current session object
     */
    public void apply(Message request, Message response, E session);
}
