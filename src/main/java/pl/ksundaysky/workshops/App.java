package pl.ksundaysky.workshops;

import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.connectors.SessionConnector;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.Author;
import pl.ksundaysky.workshops.model.Book;
import pl.ksundaysky.workshops.model.Genre;

import java.util.Set;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) {
        Author author = new Author("Kamil", "R");
        Set<Author> authors = Set.of(new Author("Jan", "Brzechwa"), new Author("OLA", "POD"));
        Book book = new Book("BOOK", authors, Genre.CLASSIC);

        Author authorModification = new Author("ZMIENIONE", "ZMIENIONE");
        authorModification.setId(2L);

        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .updateRecord(author)
                .updateRecord(authors)
                .updateRecord(book)
                .commitAndClose();

        Author authorKamil = (Author) connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .readRecord(Author.class, 2L);

        authorKamil.setName("KamilSuper");

        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .updateRecord(authorKamil)
                .commitAndClose();

        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .deleteRecord(authorKamil);
    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
