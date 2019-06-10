package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public
class Ring extends Item {
    private int magicResist;

    public Ring() {
    }

    public Ring(String name, int cost, boolean isExcelent, Champion canBeUsedBy, int magicResist) {
        super(name, cost, isExcelent, canBeUsedBy);
        this.magicResist = magicResist;
    }

    public int getMagicResist() {
        return magicResist;
    }

    public void setMagicResist(int magicResist) {
        this.magicResist = magicResist;
    }
}
