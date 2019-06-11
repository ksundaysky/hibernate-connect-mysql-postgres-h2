package pl.ksundaysky.workshops;


import pl.ksundaysky.workshops.connectors.*;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.*;

import java.util.*;

/**
 * @author Kamil Rojek
 */
public class App {

    public static void main(String[] args) {


        //TODO: Implement Calender using method getInstance():
        Calendar dateOfBirth1;

        //TODO: Implement Calender using Builder:
        Calendar dateOfBirth2;

        //TODO: Complete implementation with java.util.Date:
//        Author authorWithDateOfBirth1 = new Author("Anna", "Wajda", dateOfBirth1, );
//        Author authorWithDateOfBirth2 = new Author("Stanisław", "Kowalski", dateOfBirth2, );

        //TODO: Uncomment after completing previous tasks:
//        Set<Author> authors = new HashSet<>();
//        authors.add(authorWithDateOfBirth1);
//        authors.add(authorWithDateOfBirth2);

        //TODO: Implement date of issue using java.time:
        //?? dateOfIssue;

        //TODO: Uncomment after completing previous tasks:
//        Book bookWithDateOfIssue = new Book("Fantastyczna książka", authors, Genre.FANTASY, dateOfIssue);
//
//        connect(new H2Connector())
//                .openCrudSession(new CrudMethods())
//                .addRecord(authors)
//                .addRecord(bookWithDateOfIssue)
//                .commitAndClose();



    }

    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
