package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public
class Sword extends Weapon {
    private int attack;

    public Sword() {
    }

    public Sword(String name, int cost, boolean isExcelent, Champion canBeUsedBy, boolean isOneHanded, int attack) {
        super(name, cost, isExcelent, canBeUsedBy, isOneHanded);
        this.attack = attack;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }
}
