package pl.ksundaysky.workshops.connectors.EntityManager;

/**
 * @author krzysztof.niedzielski
 */
public class H2Connector extends EntityManagerConnector {

    @Override
    void setPersistenceUnitName() {
        persistenceUnitName = PersistenceUnitName.H2.getPersistenceUnitName();
    }
}
