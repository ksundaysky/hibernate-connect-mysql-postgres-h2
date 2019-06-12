package ja.workshops.hibernate.parts.queries.query;

import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;

import java.util.List;

/**
 * Documentation:
 * Session : https://docs.jboss.org/hibernate/orm/5.4/javadocs/
 * Tip: createQuery()
 *
 * @author krzysztof.niedzielski
 */
public class HQLQuery implements IQuery {


    public <T> List<T> listAll(Session session, Class T) {
        return session.createQuery("FROM " + T.getName()).list();
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        return (List<Author>) session.createQuery("FROM Author WHERE name='" + name + "'").list();
    }
}
