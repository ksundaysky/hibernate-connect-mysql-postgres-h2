package pl.ksundaysky.workshops.query;

import org.hibernate.Session;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public class SimpleQuery implements IQuery {

    public <T> List<T> listAll(Session session, Class T ){
        List<T> list = session.createQuery("select e.name from Author e").list();
        return list;
    }
}
