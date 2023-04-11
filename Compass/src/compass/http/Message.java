package compass.http;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Class to represent standard HTTP message. Can handle
 * incoming and out going messages. Can handle messages
 * using "\n" and also "\r\n" to signify return lines.
 * Default message is a "200 OK" return message.
 * 
 * @author Logan Pageler
 * @since 3/30/2023
 */
public class Message {
    /**
     * Lists of valid types of http requests
     */
    public static final String[] TYPES = { "POST", "GET", "PUT", "PATCH", "DELETE", "HEAD", "CONNECT", "OPTIONS",
            "TRACE" };

    private final int HEAD = 0, HEADER = 1, BODY = 2, INVALID = 3;

    private String type;
    private String route;
    private int code;
    private String status;
    private String version;

    private int lineType = 0;

    private ConcurrentMap<String, String> headers;

    private String body;
    private ConcurrentMap<String, String> query;

    /**
     * Create basic HTTP message.
     * Basic http message has a status of OK and code 200.
     */
    public Message() {
        headers = new ConcurrentHashMap<String, String>();
        query = new ConcurrentHashMap<String, String>();
        version = "http/1.1";
        code = 200;
        status = "OK";
    }

    /**
     * Create message from string.
     * 
     * @param message http message
     */
    public Message(String message) {
        String[] lines = message.split("\n");
        headers = new ConcurrentHashMap<String, String>();
        query = new ConcurrentHashMap<String, String>();

        for (String line : lines) {
            parseLine(line);
        }
    }

    /**
     * Copy another message
     * 
     * @param message message to copy
     */
    public Message(Message message) {
        this.type = message.type;
        this.route = message.route;
        this.code = message.code;
        this.status = message.status;
        this.version = message.version;
        this.headers = new ConcurrentHashMap<String, String>(message.headers);
        this.query = new ConcurrentHashMap<String, String>(message.query);
        this.body = message.body;
    }

    /**
     * Parse HTML Line by line
     * 
     * @param line next line
     * @return boolean wether end of transmission
     */
    public boolean parseLine(String line) {
        if (lineType == HEAD) {
            String[] head = line.split(" ");

            if (head.length < 3) {
                lineType = INVALID;
                return true;
            }

            // head:
            // outgoing
            if (Arrays.stream(TYPES).anyMatch(head[0]::equals)) {
                type = head[0];
                String[] routeStr = head[1].split("\\?");
                route = routeStr[0];
                if (routeStr.length > 1) {

                    String[] queries = routeStr[1].replace("%20", " ")
                            .replace("%28", "(")
                            .replace("%29", ")")
                            .replace("%2B", "+")
                            .replace("%2F", "/")
                            .replace("%5E", "^")
                            .split("&");
                    for (String q : queries) {
                        String[] pair = q.split("=");
                        if (pair.length < 2) {
                            lineType = INVALID;
                            return true;
                        }
                        query.put(pair[0], pair[1]);
                    }
                }
                version = head[2];
            } else {
                // incoming
                version = head[0];
                code = Integer.parseInt(head[1]);
                status = head[2];
            }

            lineType = HEADER;
        } else if (lineType == HEADER) {
            if (line.isEmpty() || line.equals("\r")) {
                lineType = BODY;
                if (!headers.containsKey("Content-Length")) {
                    return true;
                }
            } else {
                String[] header = line.replace("\r", "").split(": ");
                if (header.length < 2) {
                    lineType = INVALID;
                    return true;
                }
                headers.put(header[0], header[1]);
            }
        } else {
            if (line.isEmpty() || line.equals("\r")) {
                return true;
            }
            body += "\n" + line;
        }

        return false;
    }

    /**
     * Determines is a http request is valid from parsed lines
     * 
     * @return boolean wether valid
     */
    public boolean isValid() {
        return lineType != INVALID;
    }

    /**
     * Get message type. Null for incoming.
     * 
     * @return message type
     */
    public String getType() {
        return type;
    }

    /**
     * Set message type. Null for incoming.
     * 
     * @param type message type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Get message route. Null for incoming.
     * 
     * @return message route
     */
    public String getRoute() {
        return route;
    }

    /**
     * Set message route. Null for incoming.
     * 
     * @param route Message route
     */
    public void setRoute(String route) {
        this.route = route;
    }

    /**
     * Get message code.
     * 
     * @return Message code
     */
    public int getCode() {
        return code;
    }

    /**
     * Set message code
     * 
     * @param code Message code
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Get message status. Null for outgoing.
     * 
     * @return message status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the message status. Null for outgoing
     * 
     * @param status message status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Get communication version
     * 
     * @return communication version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Set communication version
     * 
     * @param version communication version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Get list of headers
     * 
     * @return list of headers
     */
    public ConcurrentMap<String, String> getHeaders() {
        return headers;
    }

    /**
     * Set all headers
     * 
     * @param headers list of headers
     */
    public void setHeaders(ConcurrentMap<String, String> headers) {
        this.headers = new ConcurrentHashMap<String, String>(headers);
    }

    /**
     * Add header to message
     * 
     * @param header message header
     * @param val    header value
     */
    public void addHeader(String header, String val) {
        headers.put(header, val);
    }

    /**
     * Get message body
     * 
     * @return message body
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets message body
     * 
     * @param body message body
     */
    public void setBody(String body) {
        this.body = body.replaceAll("[^\r][\n]", "\n");
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        String out;
        if (type != null) {
            // Outgoing
            out = type + " " + route;

            if (query.keySet().size() > 0) {
                out += "?";
                String q = "";
                for (Entry<String, String> e : query.entrySet()) {
                    q += e.getKey() + "=" + e.getValue() + "&";
                }
                out += q.substring(0, q.length() - 1).replace(" ", "%20");

            }

            out += " " + version + "\r\n";
        } else {
            // Incoming
            out = version + " " + code + " " + status + "\r\n";
        }

        for (Map.Entry<String, String> header : headers.entrySet()) {
            out += header.getKey() + ": " + header.getValue() + "\r\n";
        }
        out += "\r\n";
        if (body != null) {
            out += body + "\r\n\r\n";
        }

        return out;
    }

    /**
     * Gets query arguments.
     * 
     * @return map of query arguments
     */
    public ConcurrentMap<String, String> getQuery() {
        return query;
    }
}
