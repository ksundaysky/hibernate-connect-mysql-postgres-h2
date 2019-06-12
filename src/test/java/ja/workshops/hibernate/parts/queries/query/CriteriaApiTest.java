package ja.workshops.hibernate.parts.queries.query;


import ja.workshops.hibernate.parts.connectors.ConnectorManager;
import ja.workshops.hibernate.parts.connectors.H2Connector;
import ja.workshops.hibernate.parts.connectors.SessionInitializationException;
import ja.workshops.hibernate.parts.crud.CrudMethods;
import ja.workshops.hibernate.parts.model.Author;
import ja.workshops.hibernate.parts.model.Book;
import ja.workshops.hibernate.parts.model.Genre;
import org.hibernate.Session;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;


/**
 * @author krzysztof.niedzielski
 */
public class CriteriaApiTest {

    private Session session;
    private IQuery iQuery;

    @BeforeClass
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
        iQuery= new CriteriaApi();
    }

    @Test(priority = 0)
    public void testListAll() {
        List<Author> list = iQuery.listAll(this.session,Author.class);
        assertEquals( list.size(),3);
    }

    @Test(priority = 1)
    public void testListAllAuthorsWithSpecifiedName() {
        List<Author> list = iQuery.listAllAuthorsWithSpecifiedName(this.session,"Kamil");
        assertEquals( list.size(),1);
        session.close();
    }
}