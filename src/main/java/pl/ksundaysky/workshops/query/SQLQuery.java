package pl.ksundaysky.workshops.query;

import org.hibernate.Session;
import pl.ksundaysky.workshops.model.Author;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public class SQLQuery implements IQuery {
    @Override
    public <T> List<T> listAll(Session session, Class T) {
        return null;
    }
    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        return null;
    }

}
