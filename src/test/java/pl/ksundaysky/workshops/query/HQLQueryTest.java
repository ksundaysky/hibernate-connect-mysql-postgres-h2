package pl.ksundaysky.workshops.query;

import org.hibernate.Session;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.connectors.SessionInitializationException;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.Author;
import pl.ksundaysky.workshops.model.Book;
import pl.ksundaysky.workshops.model.Genre;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * @author krzysztof.niedzielski
 */
public class HQLQueryTest {


    private Session session;
    private IQuery iQuery;

    @BeforeSuite
    public void before() throws SessionInitializationException {
        Author author = new Author("Kamil", "R");
        Set<Author> authors = Set.of(new Author("Jan", "Brzechwa"), new Author("OLA", "POD"));
        Book book = new Book("BOOK", authors, Genre.CLASSIC);
        ConnectorManager.connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .updateRecord(author)
                .updateRecord(authors)
                .updateRecord(book)
                .commitAndClose();
        this.session = ConnectorManager.connect(new H2Connector("update")).getSession();
        iQuery= new HQLQuery();
    }

    @Test
    public void testListAll() {
        List<Author> list = iQuery.listAll(this.session,Author.class);
        System.out.println(list);
        assertEquals( list.size(),3);
    }

    @Test
    public void testListAllAuthorsWithSpecifiedName() {
        List<Author> list = iQuery.listAllAuthorsWithSpecifiedName(this.session,"Kamil");
        assertEquals( list.size(),1);
    }
}