package pl.ksundaysky.workshops.connectors.Session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import pl.ksundaysky.workshops.model.*;

import java.util.Properties;

/**
 * @author Kamil Rojek
 */
public abstract class SessionConnector implements ISessionConnector {
    private SessionFactory sessionFactory;

    @Override
    public Session getSession() {
        return this.getSessionFactory().openSession();
    }

    private SessionFactory getSessionFactory() {
        if (sessionFactory != null)
            return sessionFactory;

        Configuration configuration = createConfiguration();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }

    private Configuration createConfiguration() {
        Properties settings = loadConnectorSettings();
        Configuration configuration = new Configuration();
        configuration.setProperties(settings);
        addEntites(configuration);
        return configuration;
    }

    private void addEntites(Configuration configuration) {
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Umowa.class);
        configuration.addAnnotatedClass(Book.class);
        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Bookstore.class);
        configuration.addAnnotatedClass(BookstoreBook.class);
    }

    abstract Properties loadConnectorSettings();
}
