package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public
class Wand extends Weapon {
    private int abilityPower;

    public Wand() {
    }

    public Wand(String name, int cost, boolean isExcelent, Champion canBeUsedBy, boolean isOneHanded, int abilityPower) {
        super(name, cost, isExcelent, canBeUsedBy, isOneHanded);
        this.abilityPower = abilityPower;
    }

    public int getAbilityPower() {
        return abilityPower;
    }

    public void setAbilityPower(int abilityPower) {
        this.abilityPower = abilityPower;
    }
}
