package pl.ksundaysky.workshops.connectors;

import org.hibernate.Session;

/**
 * @author krzysztof.niedzielski
 */
public interface Connector {

   Session getSession();

}
