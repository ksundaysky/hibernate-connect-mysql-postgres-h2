package ja.workshop.hibernate.query;

import ja.workshop.hibernate.model.Author;
import org.hibernate.Session;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public class CriteriaApi implements IQuery {
    @Override
    public <T> List<T> listAll(Session session, Class T ){
       return null;
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        return null;
    }
}
