package ja.workshop.hibernate.query;

import ja.workshop.hibernate.model.Author;
import org.hibernate.Session;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public class JPQLQuery implements IQuery {
    public <T> List<T> listAll(Session session, Class T ){
        List<T> list = session.createQuery("FROM Author").list();
        return list;
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {

        List<Author> list = session.createQuery("FROM Author WHERE name='"+name+"'").list();
        return list;
    }
}
