package pl.ksundaysky.workshops.connectors;

import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Kamil Rojek
 * @author Agnieszka Trzewik
 */
public class ConnectorManager<T extends ISession> {
    private T connector;
    private Transaction transaction;
    private Session session;
    private List<Object> records;

    private ConnectorManager(T connector) {
        this.connector = connector;
        records = new ArrayList<>();
    }

    public static <T extends ISession> ConnectorManager connect(T connector) {
        return new ConnectorManager<>(connector);
    }

    public ConnectorManager<T> addRecords(Collection<?> records) {
        for (Object r : records) {
            addRecord(r);
        }
        return this;
    }

    public <R> ConnectorManager<T> addRecords(R record) {
        addRecord(record);
        return this;
    }

    private <R> void addRecord(R record) {
        records.add(record);
    }

    public void commitAndClose() throws SessionInitializationException {
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

    private void closeSession() {
        session.close();
    }

    private void initializeSession() throws SessionInitializationException {
        try {
            session = connector.getSession();
            transaction = session.beginTransaction();
        } catch (ServiceException e) {
            throw new SessionInitializationException("Session initialization failed!");
        }
    }
}
