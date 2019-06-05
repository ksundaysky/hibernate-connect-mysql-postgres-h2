package ja.workshops.hibernate.parts.connectors.EntityManager;



import ja.workshops.hibernate.parts.connectors.ISession;

import javax.persistence.EntityManager;

/**
 * @author krzysztof.kramarz
 */
public interface IEntityManagerConnector extends ISession {
    EntityManager getEntityManager();

    void closeEntitymanagerFactory() throws IllegalStateException;

}
