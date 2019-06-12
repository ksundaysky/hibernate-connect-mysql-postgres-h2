package ja.workshops.hibernate.parts;


import ja.workshops.hibernate.parts.connectors.Session.H2Connector;
import ja.workshops.hibernate.parts.connectors.Session.SessionConnectorManager;
import ja.workshops.hibernate.parts.connectors.SessionInitializationException;
import ja.workshops.hibernate.parts.crud.CrudMethods;
import ja.workshops.hibernate.parts.model.Author;

/**
 * @author krzysztof.kramarz
 */
class App {
    public static void main(String[] args) throws SessionInitializationException {
        SessionConnectorManager.connect(new H2Connector())
                            .openCrudSession(new CrudMethods())
                            .addRecord(new Author("asd", "asd"))
                            .commitAndClose();
    }
}
