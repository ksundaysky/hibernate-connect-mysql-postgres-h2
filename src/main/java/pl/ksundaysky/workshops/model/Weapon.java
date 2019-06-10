package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public abstract class Weapon extends Item{
    private boolean isOneHanded;

    public Weapon() {
    }

    public Weapon(String name, int cost, boolean isExcelent, Champion canBeUsedBy, boolean isOneHanded) {
        super(name, cost, isExcelent, canBeUsedBy);
        this.isOneHanded = isOneHanded;
    }

    public boolean isOneHanded() {
        return isOneHanded;
    }

    public void setOneHanded(boolean oneHanded) {
        isOneHanded = oneHanded;
    }
}
