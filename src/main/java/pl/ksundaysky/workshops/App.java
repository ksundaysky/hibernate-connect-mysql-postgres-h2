package pl.ksundaysky.workshops;


import pl.ksundaysky.workshops.connectors.*;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.*;

import java.time.LocalDate;
import java.util.*;

/**
 * @author Kamil Rojek
 */
public class App {

    public static void main(String[] args) {


        Calendar dateOfBirth1 = Calendar.getInstance();
        dateOfBirth1.set(1976,Calendar.MARCH,11);

        Calendar dateOfBirth2 = new Calendar.Builder().setDate(1980, Calendar.APRIL, 4).build();

        Author authorWithDateOfBirth1 = new Author("Anna", "Wajda", dateOfBirth1, new Date());
        Author authorWithDateOfBirth2 = new Author("Stanisław", "Kowalski", dateOfBirth2, new Date());

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
