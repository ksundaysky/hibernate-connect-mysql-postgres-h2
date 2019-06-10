package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public
class Bow extends Weapon {
    private int attackSpeed;

    public Bow() {
    }

    public Bow(String name, int cost, boolean isExcelent, Champion canBeUsedBy, boolean isOneHanded, int attackSpeed) {
        super(name, cost, isExcelent, canBeUsedBy, isOneHanded);
        this.attackSpeed = attackSpeed;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}
