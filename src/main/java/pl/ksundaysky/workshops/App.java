package pl.ksundaysky.workshops;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.ksundaysky.workshops.connectors.MysqlConnector;
import pl.ksundaysky.workshops.model.Person;
import pl.ksundaysky.workshops.model.Umowa;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args) {

        try(Session session = MysqlConnector.getSessionFactory().getCurrentSession()){

            Transaction transaction = session.beginTransaction();

            Umowa umowa1 = new Umowa()

            session.save(new Person("krzysiu","sundaysky",12));
            session.save(new Person("krzysiusssss","sundayskyss",13));
            session.save(new Person("krzysiusss","sundayskysssss",14));

            transaction.commit();
        }
    }
}
