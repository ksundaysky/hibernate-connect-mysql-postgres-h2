package ja.workshop.hibernate;

import ja.workshop.hibernate.connectors.H2Connector;

/**
 * //TODO: 1. Create field version with @Version annotation in BookstoreBook entity
 *         2. Add random object to BookStoreBook.
 *         3. Update record, check the version.
 *         4. Create two parallel session which will try to update recently added record.
 *
 */
public class App {
    public static void main(String[] args) throws Exception {
        new H2Connector().getSession(); //
    }

}
