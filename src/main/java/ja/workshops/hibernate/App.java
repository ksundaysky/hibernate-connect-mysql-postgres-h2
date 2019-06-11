package ja.workshops.hibernate;

import ja.workshops.hibernate.connectors.ConnectorManager;
import ja.workshops.hibernate.connectors.SessionConnector;
import ja.workshops.hibernate.model.Author;

import java.util.Set;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) {
        Author author = new Author("Kamil", "R");
        Set<Author> authors = Set.of(new Author("Jan", "Brzechwa"), new Author("OLA", "POD"));

/*
        //I Stage - creating data base.
        connect(new H2Connector())
                .openCrudSession(YOUR CRUD CLASS)
                .updateRecord(author)
                .updateRecord(authors)
                .commitAndClose();
*/
/*
        //II Stage - read record.
        Author authorKamil = (Author) connect(new H2Connector())
                .openCrudSession(YOUR CRUD CLASS)
                .readRecord(Author.class, 2L);

        System.out.println(authorKamil);
*/
/*
        //III Stage - update record.
        authorKamil.setName("Kamil");
        authorKamil.setName("Rojek");

        connect(new H2Connector())
                .openCrudSession(YOUR CRUD CLASS)
                .updateRecord(authorKamil)
                .commitAndClose();

*/
/*

        //IV Stage - remove record.
        connect(new H2Connector())
                .openCrudSession(YOUR CRUD CLASS)
                .deleteRecord(authorKamil);

*/
    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
