package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public class Mags extends Heros {
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    private int mana;
}
