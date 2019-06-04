package pl.ksundaysky.workshops;

import pl.ksundaysky.workshops.connectors.*;
import pl.ksundaysky.workshops.model.*;

import java.util.*;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) {
        ConnectorManager connectorManager = connect(new H2Connector());

        Author author = new Author("Aga", "Tuwim");
        Set<Author> authors = Set.of(new Author("Jan", "Brzechwa"));
        Book book = new Book("asd", authors, Genre.CLASSIC);
        connectorManager.addRecords(author);
        connectorManager.addRecords(authors);
        connectorManager.addRecords(book);

        try {
            connectorManager.commitAndClose();
        } catch (SessionInitializationException e) {
            e.getMessage();
        }
    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
