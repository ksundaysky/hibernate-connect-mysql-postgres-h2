package ja.workshops.hibernate.parts.queries.query;

import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;

import java.util.List;

/**
 * Documentation:
 * Session : https://docs.jboss.org/hibernate/orm/5.4/javadocs/
 * Tip: createQuery()
 * @author krzysztof.niedzielski
 */
public class HQLQuery implements  IQuery {

    @Override
    public <T> List<T> listAll(Session session, Class T ){
       return null;
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        return null;
    }
}
