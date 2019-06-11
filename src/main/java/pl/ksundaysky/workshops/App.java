package pl.ksundaysky.workshops;
import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.connectors.SessionConnector;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.*;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args)
    {
        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .addRecord(YOUR OBJECTS)
                .commitAndClose();
    }
    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
