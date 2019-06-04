package pl.ksundaysky.workshops;

import pl.ksundaysky.workshops.connectors.Connector;
import pl.ksundaysky.workshops.connectors.H2Connector;

/**
 * @author krzysztof.niedzielski
 */
public class App {
    public static void main(String[] args) throws Exception {
        new H2Connector().getSession(); //komentarzyk
    }

}
