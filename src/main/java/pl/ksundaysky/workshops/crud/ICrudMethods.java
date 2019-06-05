package pl.ksundaysky.workshops.crud;

/**
 * @author Kamil Rojek
 */
public interface ICrudMethods {
    <R> void create(R record);

    <T> Object read(Class c, T Id);

    <R> void update(R record);

    <R> void delete(R record);
}
