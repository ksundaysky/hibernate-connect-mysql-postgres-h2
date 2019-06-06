package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public class Fighter extends Heros {
    private int engergy;

    public int getEngergy() {
        return engergy;
    }

    public void setEngergy(int engergy) {
        this.engergy = engergy;
    }
}
