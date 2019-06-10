package pl.ksundaysky.workshops;
import pl.ksundaysky.workshops.connectors.ConnectorManager;
import pl.ksundaysky.workshops.connectors.H2Connector;
import pl.ksundaysky.workshops.connectors.SessionConnector;
import pl.ksundaysky.workshops.crud.CrudMethods;
import pl.ksundaysky.workshops.model.*;

/**
 * @author Kamil Rojek
 */
public class App {
    public static void main(String[] args)
    {
        Armor armor = new Armor("Dark Armor", 2400, false, Champion.WARRIOR, 50);
        Shoes shoes = new Shoes("Speedy shoes", 1000, false, Champion.ELF, 15);
        Ring ring = new Ring("Speedy shoes", 1000, false, Champion.ELF, 15);
        Sword sword = new Sword("Sharp blade", 2655, true, Champion.WARRIOR, false, 60);
        Wand wand = new Wand("Kundun stuff", 2655, true, Champion.WIZZARD, true, 50);
        Bow bow = new Bow("Mandarin Bow", 4500, false, Champion.ELF,false, 90);

        connect(new H2Connector())
                .openCrudSession(new CrudMethods())
                .addRecord(armor)
                .addRecord(shoes)
                .addRecord(ring)
                .addRecord(sword)
                .addRecord(wand)
                .addRecord(bow)
                .commitAndClose();
    }
    private static ConnectorManager connect(SessionConnector connector) {
        return ConnectorManager.connect(connector);
    }
}
