package ja.workshop.hibernate.model;

import javax.persistence.*;

/**
 * @author krzysztof.niedzielski
 */
@Entity
public class Umowa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String nazwa;

    public Umowa() {
    }

    public Umowa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Umowa(String nazwa, Person person) {
        this.nazwa = nazwa;
        this.person = person;
    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
