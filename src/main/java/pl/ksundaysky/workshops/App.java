package pl.ksundaysky.workshops;

import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.EntityManager.EntityManagerConnectorManager;
import pl.ksundaysky.workshops.connectors.EntityManager.H2Connector;
import pl.ksundaysky.workshops.connectors.EntityManager.MysqlConnector;
import pl.ksundaysky.workshops.connectors.EntityManager.PostgreSQLConnector;
import pl.ksundaysky.workshops.connectors.SessionCloseException;
import pl.ksundaysky.workshops.connectors.SessionInitializationException;
import pl.ksundaysky.workshops.model.Author;
import pl.ksundaysky.workshops.model.Book;
import pl.ksundaysky.workshops.model.Genre;

import java.util.Set;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args) {

        ConnectorManager<MysqlConnector> connectorManagerMySQL = EntityManagerConnectorManager.of(new MysqlConnector());
        ConnectorManager<PostgreSQLConnector> connectorManagerPostgreSQL = EntityManagerConnectorManager.of(new PostgreSQLConnector());
        ConnectorManager<H2Connector> connectorManagerH2 = EntityManagerConnectorManager.of(new H2Connector());

        Author author = new Author("Proba", "Finalna3");
        Set<Author> authors = Set.of(new Author("Jan", "Samoradzik"));
        Book book = new Book("asd", authors, Genre.CLASSIC);

        connectorManagerMySQL.addRecords(author);
        connectorManagerMySQL.addRecords(authors);
        connectorManagerMySQL.addRecords(book);

        connectorManagerPostgreSQL.addRecords(author);
        connectorManagerPostgreSQL.addRecords(authors);
        connectorManagerPostgreSQL.addRecords(book);

        connectorManagerH2.addRecords(author);
        connectorManagerH2.addRecords(authors);
        connectorManagerH2.addRecords(book);


        try {
            connectorManagerMySQL.commitAndClose();
            connectorManagerPostgreSQL.commitAndClose();
            connectorManagerH2.commitAndClose();
        } catch (SessionInitializationException e) {
            e.getMessage();
        } catch (SessionCloseException e) {
            e.getMessage();
        }
    }
}
