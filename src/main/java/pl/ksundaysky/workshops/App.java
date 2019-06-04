package pl.ksundaysky.workshops;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.ksundaysky.workshops.connectors.Connector;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.model.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args) throws Exception {
        connect(new H2Connector());
    }

    static void connect(Connector connector) throws Exception {
        try (Session session = connector.getSession()) {
            Transaction transaction = session.beginTransaction();

            Author brzechwa = new Author("Jan", "Brzechwa");
            Author kupajki = new Author("Bartosz", "Kupajski");
            Author wrupek = new Author("Wiktor", "Wrupek");
            Set<Author> authors = new HashSet<>();
            authors.add(wrupek);
            authors.add(brzechwa);
            authors.add(kupajki);

            Book book1 = new Book("w pustyni i w puszczy", Collections.singleton(brzechwa), Genre.CLASSIC);
            Book book2 = new Book("angular in 5 minutes", authors, Genre.CLASSIC);
            Book book3 = new Book("todo list - html js", Collections.singleton(wrupek), Genre.CLASSIC);
            session.save(book1);
            session.save(book2);
            session.save(book3);
            session.save(brzechwa);
            session.save(kupajki);
            session.save(wrupek);

            transaction.commit();

        }
    }
}
