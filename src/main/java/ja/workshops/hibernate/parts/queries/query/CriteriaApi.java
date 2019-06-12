package ja.workshops.hibernate.parts.queries.query;

import ja.workshops.hibernate.parts.model.Author;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Documentation :
 * - CriteriaBuilder: https://docs.oracle.com/javaee/7/api/javax/persistence/criteria/CriteriaBuilder.html
 * - Root : https://docs.oracle.com/javaee/7/api/javax/persistence/criteria/Root.html
 * - CriteriaQuery: https://docs.oracle.com/javaee/7/api/javax/persistence/criteria/CriteriaQuery.html
 * - TypedQuery : https://docs.oracle.com/javaee/7/api/javax/persistence/TypedQuery.html
 * @author krzysztof.niedzielski
 */

public class CriteriaApi implements IQuery {


    public <T> List<T> listAll(Session session, Class T ){
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(T);
        Root<T> from = criteriaQuery.from(T);
        CriteriaQuery<T> select = criteriaQuery.select(from);
        TypedQuery<T> typedQuery = session.createQuery(select);
        return typedQuery.getResultList();
    }

    @Override
    public List<Author> listAllAuthorsWithSpecifiedName(Session session, String name) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        CriteriaQuery<Author> criteriaQuery = criteriaBuilder.createQuery(Author.class);
        Root<Author> from = criteriaQuery.from(Author.class);

        criteriaQuery.where(criteriaBuilder.equal(from.get("name"),name));

        CriteriaQuery<Author> select = criteriaQuery.select(from);
        TypedQuery<Author> typedQuery = session.createQuery(select);

        return typedQuery.getResultList();
    }
}

