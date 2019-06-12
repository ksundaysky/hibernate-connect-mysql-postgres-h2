package ja.workshops.hibernate.parts.queries.query;

import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Documentation:
 * Session : https://docs.jboss.org/hibernate/orm/5.4/javadocs/
 * Tip: createNamedQuery()
 * @author krzysztof.niedzielski
 */
public class NamedQuery implements IQuery {

    @Override
    public <T> List<T> listAll(Session session, Class T ){
        Query<T> query = session.createNamedQuery("SelectAllAuthors",T);
        return query.getResultList();
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {

        Query<Author> query = session.createNamedQuery("SelectAuthorsWhereName",Author.class);
        query.setParameter("authorName",name);
        return query.getResultList();
    }
}
