package src;

/**
 * Represents an exception thrown from a tree when operations fail.
 * 
 * @author Adam Khoukhi
 * @version 1.0
 */
public class TreeException extends RuntimeException {
    /**
     * Generated serial Version id
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs an exception object with a message
     * 
     * @param message A reference to an expcetion message
     */
    public TreeException(String message) {
        super(message);
    }
}
