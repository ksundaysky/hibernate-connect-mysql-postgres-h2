package ja.workshops.hibernate.parts.queries.query;

import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Documentation:
 * Session : https://docs.jboss.org/hibernate/orm/5.4/javadocs/
 * Tip: createSqlQuery()
 * createSqlQuery returns List<Object[]> so we have to parse Object[] to Author object.
 * @author krzysztof.niedzielski
 */
public class SQLQuery {

    public  List<Author> listAll(Session session ){
        List<Author> list = session.createSQLQuery("select name, surname from Author").getResultList();
        return list;
    }

    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        String query = "select name, surname from Author where name='"+name+"'";
        List<Author> authors = new ArrayList<>();
        List<Object[]> list = session.createSQLQuery(query).getResultList();
        list.forEach(a -> {
            Author author = new Author();
            author.setName(a[0].toString());
            author.setSurname(a[1].toString());
            authors.add(author);
        });
        return authors;
    }
}