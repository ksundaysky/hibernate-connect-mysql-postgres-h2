package ja.workshop.hibernate.query;

import org.hibernate.Session;
import ja.workshop.hibernate.model.Author;

import java.util.ArrayList;
import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public class SQLQuery implements  IQuery{
    public <T> List<T> listAll(Session session, Class T ){
        List<T> list = session.createSQLQuery("select name, surnname from Author").getResultList();
        return list;
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        String query = "select name, surnname from Author where name='"+name+"'";
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
