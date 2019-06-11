package ja.workshops.hibernate;

import ja.workshops.hibernate.connectors.ConnectorManager;
import ja.workshops.hibernate.connectors.H2Connector;
import ja.workshops.hibernate.connectors.SessionConnector;
import ja.workshops.hibernate.crud.CrudMethods;
import ja.workshops.hibernate.model.Author;
import ja.workshops.hibernate.model.Book;
import ja.workshops.hibernate.model.Genre;

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
