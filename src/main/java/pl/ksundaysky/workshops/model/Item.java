package pl.ksundaysky.workshops.model;

import javax.persistence.*;

/**
 * @author Kamil Rojek
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Item {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int cost;

    private boolean isExcelent;
    @Enumerated(EnumType.STRING)
    private Champion canBeUsedBy;

    public Item() {
    }

    public Item(String name, int cost, boolean isExcelent, Champion canBeUsedBy) {
        this.name = name;
        this.cost = cost;
        this.isExcelent = isExcelent;
        this.canBeUsedBy = canBeUsedBy;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isExcelent() {
        return isExcelent;
    }

    public void setExcelent(boolean excelent) {
        isExcelent = excelent;
    }

    public Champion getCanBeUsedBy() {
        return canBeUsedBy;
    }

    public void setCanBeUsedBy(Champion canBeUsedBy) {
        this.canBeUsedBy = canBeUsedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
