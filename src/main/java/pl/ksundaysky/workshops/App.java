package pl.ksundaysky.workshops;

import org.hibernate.Session;
import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.connectors.SessionConnector;
import pl.ksundaysky.workshops.connectors.SessionInitializationException;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.Author;
import pl.ksundaysky.workshops.model.Book;
import pl.ksundaysky.workshops.model.Genre;

import java.util.Set;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) throws SessionInitializationException {
        Author author = new Author("Kamil", "R");
        Set<Author> authors = Set.of(new Author("Jan", "Brzechwa"), new Author("OLA", "POD"));
        Book book = new Book("BOOK", authors, Genre.CLASSIC);

        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .updateRecord(author)
                .updateRecord(authors)
                .updateRecord(book)
                .commitAndClose();

        //TODO : You should implement methods listAll and listAllAuthorsWithSpecifiedName in all classes in package ...query
        // You can achieve this in several ways
        // In this package there are several classes that need implementation
        // Names of this classes are not random, they correspond to the way you should implement each class.
        // All test should pass

        Session session = connect(new H2Connector("update")).getSession();

    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
