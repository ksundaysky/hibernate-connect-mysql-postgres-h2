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


        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(1976,Calendar.MARCH,11);

        Calendar calendar2 = new Calendar.Builder().setDate(1980, Calendar.APRIL, 4).build();

        Author authorWithDateOfBirth1 = new Author("Anna", "Wajda", calendar1, new Date());
        Author authorWithDateOfBirth2 = new Author("Stanisław", "Kowalski", calendar2, new Date());

        Set<Author> authors = new HashSet<>();
        authors.add(authorWithDateOfBirth1);
        authors.add(authorWithDateOfBirth2);

        Book bookWithDateOfIssue = new Book("Fantastyczna książka", authors, Genre.FANTASY, LocalDate.of(1998, 6, 10));

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
