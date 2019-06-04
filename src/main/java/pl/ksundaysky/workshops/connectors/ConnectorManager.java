package pl.ksundaysky.workshops.connectors;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;

/**
 * @author Kamil Rojek
 */
public class ConnectorManager <T extends Connector>{
    private T connector;

    public ConnectorManager(T connector) {
        this.connector = connector;
    }

    public void addRecords(Collection<?> records) {
        try (Session session = connector.getSession()) {
            Transaction transaction = session.beginTransaction();
            records.forEach(session::save);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
