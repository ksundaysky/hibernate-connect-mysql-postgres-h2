package pl.ksundaysky.workshops.query;

import org.hibernate.Session;
import pl.ksundaysky.workshops.model.Author;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public interface IQuery {
     <T> List<T> listAll(Session session, Class T );

     List<Author> listAllAuthorsWithSpecifiedName(Session session, String name);
}
