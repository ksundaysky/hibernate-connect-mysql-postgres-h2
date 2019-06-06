package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author bartosz.kupajski
 */
public class App {
    public static void main(String[] args) throws Exception {

        Author authorJuliusz = new Author("Juliusz", "Słowacki");
        Book kordian = new Book("Kordian", Set.of(authorJuliusz), Genre.CLASSIC);
        Transaction transaction = null;

        try (Session session = new H2Connector().getSession()) {
            transaction = session.beginTransaction();

            session.save(kordian);
            //TODO: new Bookstore jako zmienna
            BookstoreBook summary = new BookstoreBook(new Bookstore("Ksiegarnia"), kordian, 12);
            session.save(summary);

            transaction.commit();
            //TODO: co to za Exception? nie ma nic konkretniejszego?
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            //TODO: łapiesz i rzucasz?!
            throw e;
        }

        Long personId = 1L;

        //TODO: można zaimplementować klaskę od Runnable, która przyjmuje czas spania, bo reszta jest taka sama w run()
        //TODO: nazwy dla wąteczków
        Thread t1 = new Thread(new Runnable() {
            Session session1 = new H2Connector().getSession();
            Transaction tx = null;

            @Override
            public void run() {
                BookstoreBook summary = session1.get(BookstoreBook.class, personId);
                if (summary != null) {
                    tx = session1.beginTransaction();

                    try {
                        //TODO: nowsza wersja sleepa - TimeUnit.SECONDS.sleep(5000);
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    summary.setPrice(18);
                    session1.update(summary);
                    tx.commit();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            Session session2 = new H2Connector().getSession();
            Transaction tx = null;

            @Override
            public void run() {
                BookstoreBook summary = session2.get(BookstoreBook.class, personId);
                if (summary != null) {
                    tx = session2.beginTransaction();
                    summary.setPrice(25);
                    session2.update(summary);
                    tx.commit();
                }
            }
        });
//        t1.start();
//        t2.start();

    }
}
