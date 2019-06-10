package ja.workshop.hibernate.connectors;

import org.hibernate.Session;

/**
 * @author Ola Podorska
 */
public abstract class Connector {

    public static Session getSessionFactory(){
        return null;
    }

}
