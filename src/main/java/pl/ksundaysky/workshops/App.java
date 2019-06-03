package pl.ksundaysky.workshops;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.ksundaysky.workshops.connectors.Connector;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.connectors.MysqlConnector;
import pl.ksundaysky.workshops.connectors.PostgresConnector;
import pl.ksundaysky.workshops.model.Person;
import pl.ksundaysky.workshops.model.Umowa;

import java.util.Collections;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args) {
        connect(new H2Connector());
    }


    static void connect(Connector connector){
        try(Session session = connector.getSession()){

            Transaction transaction = session.beginTransaction();

            Person person = new Person("krzysiu","sundaysky",12);
            session.save(new Person("krzysiusssss","sundayskyss",13));
            session.save(new Person("krzysiusss","sundayskysssss",14));

            Umowa umowa1 = new Umowa("umowa podstawowa",person);
            session.save(person);
            session.save(umowa1);


            transaction.commit();
        }
    }
}
