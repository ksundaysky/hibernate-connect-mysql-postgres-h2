package pl.ksundaysky.workshops.query;

import org.hibernate.Session;

import java.util.List;

/**
 * @author krzysztof.niedzielski
 */
public interface IQuery {
     <T> List<T> listAll(Session session, Class T );
}
