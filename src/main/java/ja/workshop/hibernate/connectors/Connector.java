package ja.workshop.hibernate.connectors;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kamil Rojek
 */
public abstract class Connector {

    public static SessionFactory getSessionFactory(){
        return new Configuration().configure().buildSessionFactory();
    }

}
