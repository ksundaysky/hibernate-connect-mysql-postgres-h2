package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public class Armor extends Item {
    private int defense;

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public Armor() {
    }

    public Armor(String name, int cost, boolean isExcelent, Champion canBeUsedBy, int defense) {
        super(name, cost, isExcelent, canBeUsedBy);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

}


