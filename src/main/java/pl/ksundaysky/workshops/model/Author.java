package pl.ksundaysky.workshops.model;

import  javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Bartosz Kupajski
 */
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surnname", nullable = false)
    private String surname;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Calendar dateOfBirth;

    @Column(name = "date_of_addition")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfAddition;

    public Author() {

    }

    public Author(String name, String surname, Calendar dateOfBirth, Date dateOfAddition) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAddition = dateOfAddition;
    }

    public Date getDateOfAddition() {
        return dateOfAddition;
    }

    public void setDateOfAddition(Date dateOfAddition) {
        this.dateOfAddition = dateOfAddition;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
