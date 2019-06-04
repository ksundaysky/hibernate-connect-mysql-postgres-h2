package pl.ksundaysky.workshops;

import pl.ksundaysky.workshops.connectors.Connector;
import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.model.*;

import java.util.*;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args) throws Exception {
        connect();
    }

    static void connect() {
        ConnectorManager<Connector> connectorManager = new ConnectorManager<>(new H2Connector());
        Set<Author> authors = Set.of(new Author("Jan", "Brzechwa"));
        connectorManager.addRecords(authors);
    }
}
