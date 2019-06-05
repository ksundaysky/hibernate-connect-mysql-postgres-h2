package pl.ksundaysky.workshops.connectors.Session;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.SessionCloseException;
import pl.ksundaysky.workshops.connectors.SessionInitializationException;

import java.util.ArrayList;

/**
 * @author krzysztof.kramarz
 */
public class SessionConnectorManager<T extends ISessionConnector> extends ConnectorManager<T> {
    private Transaction transaction;
    private Session session;

    private SessionConnectorManager(T connector) {
        super.connector = connector;
        records = new ArrayList<>();
    }

    public static <T extends ISessionConnector> ConnectorManager<T> of(T connector) {
        return new SessionConnectorManager<>(connector);
    }

    @Override
    public void commitAndClose() throws SessionInitializationException, SessionCloseException { //TODO dorobic wyrzucanie SessionCloseException
        initializeSession();
        for (Object r : records) {
            try {
                session.save(r);
            } catch (MappingException e) {
                System.err.println("Adding record failed -> " + r.toString());
            }
        }
        transaction.commit();
        closeSession();
    }

    private void initializeSession() throws SessionInitializationException {
        try {
            session = connector.getSession();
            transaction = session.beginTransaction();
        } catch (ServiceException e) {
            throw new SessionInitializationException("Session initialization failed!");
        }
    }

    private void closeSession() {
        session.close();
    } //TODO throws Hibernate Exception
}
