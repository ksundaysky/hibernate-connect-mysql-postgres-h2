package pl.ksundaysky.workshops.connectors.Session;

import org.hibernate.Session;
import pl.ksundaysky.workshops.connectors.ISession;

/**
 * @author Kamil Rojek
 */
public interface ISessionConnector extends ISession {
    Session getSession();
}
