package pl.ksundaysky.workshops.model;

import javax.persistence.Entity;

/**
 * @author Kamil Rojek
 */
@Entity
public
class Shoes extends Item{
    private int speed;

    public Shoes() {
    }

    public Shoes(String name, int cost, boolean isExcelent, Champion canBeUsedBy, int speed) {
        super(name, cost, isExcelent, canBeUsedBy);
        this.speed = speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
