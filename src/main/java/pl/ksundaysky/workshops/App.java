package pl.ksundaysky.workshops;
import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.connectors.SessionConnector;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.Fighter;
import pl.ksundaysky.workshops.model.Heros;
import pl.ksundaysky.workshops.model.Sex;
import java.util.Set;
/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args)
    {
        Fighter fighter = new Fighter();
        fighter.setName("Żołnież");
        fighter.setSex(Sex.MALE);
        fighter.setEngergy(100);
//        connect(new H2Connector())
//                .openCrudSession(new CrudMethods())
//                .addRecord(fighter)
//                .commitAndClose();
        Fighter record = (Fighter) connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .readRecord(Fighter.class, 1L);
        System.out.println(record.getName() + " " + record.getEngergy());
    }
    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
