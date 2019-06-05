package ja.workshops.hibernate.parts.connectors.Session;

import ja.workshops.hibernate.parts.connectors.ISession;
import org.hibernate.Session;

/**
 * @author Kamil Rojek
 */
public interface ISessionConnector extends ISession {
    Session getSession();
}
