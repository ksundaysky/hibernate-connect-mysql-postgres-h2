package pl.ksundaysky.workshops.connectors.EntityManager;

import pl.ksundaysky.workshops.connectors.ISession;

import javax.persistence.EntityManager;

/**
 * @author krzysztof.kramarz
 */
public interface IEntityManagerConnector extends ISession {
    EntityManager getEntityManager();

    void closeEntitymanagerFactory() throws IllegalStateException;

}
