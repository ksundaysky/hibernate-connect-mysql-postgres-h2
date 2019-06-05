package pl.ksundaysky.workshops.crud;

import org.hibernate.MappingException;
import org.hibernate.Session;

/**
 * @author Kamil Rojek
 */
public class CrudProvider implements ICrudMethods {
    private Session session;

    public CrudProvider(Session session) {
        this.session = session;
    }

    @Override
    public <R> void create(R record) {
        try {
            session.saveOrUpdate(record);
        } catch (MappingException e) {
            System.err.println("Adding record failed -> " + record.toString());
        }
    }

    @Override
    public <T> Object read(Class c, T id) {
        return session.find(c, id);
    }

    @Override
    public <R> void update(R record) {
        try {
            session.saveOrUpdate(record);
        } catch (MappingException e) {
            System.err.println("Updating record failed -> " + record.toString());
        }
    }

    @Override
    public <R> void delete(R record) {
        session.delete(record);
    }
}
