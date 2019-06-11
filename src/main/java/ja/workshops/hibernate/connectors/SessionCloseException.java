package ja.workshops.hibernate.connectors;

/**
 * @author Kamil Rojek
 */
public class SessionCloseException extends Exception {
    public SessionCloseException(String message) {
        super(message);
    }
}
