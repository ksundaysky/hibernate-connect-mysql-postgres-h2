package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.H2Connector;
import ja.workshop.hibernate.model.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

/**
 * @author bartosz.kupajski
 */
public class App {
    public static void main(String[] args) throws Exception {

        Author authorJuliusz = new Author("Juliusz", "Słowacki");
        Book kordian = new Book("Kordian", Set.of(authorJuliusz), Genre.CLASSIC);
        Transaction tx = null;

        try (Session sess = new H2Connector().getSession()) {
            tx = sess.beginTransaction();

            sess.save(kordian);
            BookstoreBook summary = new BookstoreBook(new Bookstore("Ksiegarnia"), kordian, 12);
            sess.save(summary);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }

        Long personId = 1L;

        Thread t1 = new Thread(new Runnable() {
            Session session1 = new H2Connector().getSession();
            Transaction tx = null;

            @Override
            public void run() {
                BookstoreBook summary = session1.get(BookstoreBook.class, personId);
                if (summary != null) {
                    tx = session1.beginTransaction();

                    try {
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
