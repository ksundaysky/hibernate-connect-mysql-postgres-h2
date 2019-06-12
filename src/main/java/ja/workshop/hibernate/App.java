package ja.workshop.hibernate;


import ja.workshop.hibernate.connectors.ConnectorManager;
import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.connectors.SessionConnector;
import ja.workshop.hibernate.model.Author;
import ja.workshop.hibernate.model.Book;
import ja.workshop.hibernate.model.Genre;
import ja.workshop.hibernate.crud.CrudMethods;

import java.time.*;
import java.util.*;

/**
 * Picture with transformation java times to sql times in README.
 *
 * @author Kamil Rojek
 */
public class App {

    public static void main(String[] args) {

        /*To get the specific date with JDBC DATE Type before java.time you could use
        Calendar dateOfBirth1 = Calendar.getInstance();
        dateOfBirth1.set(1976, Calendar.MARCH, 11);

        or

        Calendar dateOfBirth2 = new Calendar.Builder().setDate(1980, Calendar.APRIL, 4).build();
         */

        LocalDate dateOfBirth1 = LocalDate.of(1976, 3, 11);

        LocalDate dateOfBirth2 = LocalDate.of(1980, 4, 4);

        /*To get current time with JDBC TIMESTAMP Type before java.time you could use java.util.Date new Date() or
        java.util.Calendar Calendar.getInstance().getTime()
         */
        Author authorWithDateOfBirth1 = new Author("Anna", "Wajda", dateOfBirth1, OffsetDateTime.now(ZoneId.systemDefault()));
        Author authorWithDateOfBirth2 = new Author("Stanisław", "Kowalski", dateOfBirth2, OffsetDateTime.now(ZoneId.systemDefault()));


        Set<Author> authors = new HashSet<>();
        authors.add(authorWithDateOfBirth1);
        authors.add(authorWithDateOfBirth2);

        LocalDate dateOfIssue = LocalDate.of(1998, 6, 10);
        Book bookWithDateOfIssue = new Book("Fantastyczna książka", authors, Genre.FANTASY, dateOfIssue);

        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .addRecord(authors)
                .addRecord(bookWithDateOfIssue)
                .commitAndClose();
    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
