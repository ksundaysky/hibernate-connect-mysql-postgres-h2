package pl.ksundaysky.workshops.query;

import org.hibernate.Session;
import pl.ksundaysky.workshops.model.Author;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public class HQLQuery {

    public <T> List<T> listAll(Session session, Class T ){
        List<T> list = session.createQuery("FROM Author").list();
        return list;
    }
}
