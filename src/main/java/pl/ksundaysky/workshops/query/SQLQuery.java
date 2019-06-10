package pl.ksundaysky.workshops.query;

import org.hibernate.Session;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public class SQLQuery {
    public <T> List<T> listAll(Session session, Class T ){
        List<T> list = session.createSQLQuery("select name, surnname from Author").getResultList();
        return list;
    }
}
