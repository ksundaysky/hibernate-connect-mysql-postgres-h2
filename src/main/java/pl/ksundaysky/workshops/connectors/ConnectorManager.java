package pl.ksundaysky.workshops.connectors;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.service.spi.ServiceException;
import pl.ksundaysky.workshops.crud.CrudProvider;
import pl.ksundaysky.workshops.crud.ICrudMethods;

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
    private List<Object> recordsToAdd;
    private List<Object> recordsToUpdate;
    private ICrudMethods crudMethods;

    private ConnectorManager(T connector) {
        this.connector = connector;
        recordsToAdd = new ArrayList<>();
        recordsToUpdate = new ArrayList<>();
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
        recordsToAdd.add(record);
    }

    public ConnectorManager<T> updateRecords(Collection<?> records) {
        for (Object r : records) {
            updateRecords(r);
        }
        return this;
    }

    public <R> ConnectorManager<T> updateRecords(R record) {
        updateRecord(record);
        return this;
    }

    public <T> Object readRecord(Class clas, T id) {
        Session session = connector.getSession();
        Transaction transaction = session.getTransaction();
        return crudMethods.read(clas, id);
    }

    private <R> void updateRecord(R record) {
        recordsToUpdate.add(record);
    }

    public void commitAndClose() throws SessionInitializationException {
        initializeSession();
        recordsToAdd.forEach(crudMethods::create);
        recordsToUpdate.forEach(crudMethods::update);
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
            crudMethods = new CrudProvider(session);
        } catch (ServiceException e) {
            throw new SessionInitializationException("Session initialization failed!");
        }
    }
}
