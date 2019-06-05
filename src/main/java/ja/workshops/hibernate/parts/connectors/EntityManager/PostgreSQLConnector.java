package ja.workshops.hibernate.parts.connectors.EntityManager;

/**
 * @author krzysztof.niedzielski
 */
public class PostgreSQLConnector extends EntityManagerConnector {

    @Override
    void setPersistenceUnitName() {
        persistenceUnitName = PersistenceUnitName.PostgreSQL.getPersistenceUnitName();
    }
}
