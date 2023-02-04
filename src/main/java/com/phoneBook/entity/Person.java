package com.phoneBook.entity;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.Objects;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person implements Serializable, Comparable<Person> {

    static final long serialVersionUID = 124;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incPerson")
    @SequenceGenerator(name = "incPerson", sequenceName = "incPerson", allocationSize = 1)
    @Id
    @Column(name = "id")
    private long id;
    @Size(min = 2, message = "Не меньше 2 знаков")
    @Column(name = "surname")
    private String surname;
    @Size(min = 2, message = "Не меньше 2 знаков")
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Pattern(regexp="[\\d{11}]", message = "Телефон должен содержать 11 цифр")
    @Column(name = "phone")
    private String phone;
    @Pattern(regexp="[\\D*@\\D*.\\D*]", message = "Почта должна содержать @ и .")
    @Column(name = "email")
    private String email;
    @Column(name = "photo")
    private String photo;
    @Column(name = "comments")
    private String comments;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "city")
    private City city;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "organization")
    private Organization organization;

    public Person() {
    }

    public Person(String surname, String name, String patronymic, String phone, String email, String photo,
            String comments, City city, Organization organization) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
        this.comments = comments;
        this.city = city;
        this.organization = organization;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", surname=" + surname + ", name=" + name + ", patronymic=" + patronymic + ", phone=" + phone + ", email=" + email + ", photo=" + photo + ", comment=" + comments + ", city=" + city + ", organization=" + organization + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.surname);
        hash = 79 * hash + Objects.hashCode(this.patronymic);
        hash = 79 * hash + Objects.hashCode(this.phone);
        hash = 79 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.patronymic, other.patronymic)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public int compareTo(Person person) {
        int compareName = name.compareTo(person.getName());
        int compareSurname = surname.compareTo(person.getSurname());
        if (compareName == 0 && compareSurname == 0) {
            return patronymic.compareTo(person.getPatronymic());
        } else if (compareName == 0) {
            return compareSurname;
        } else {
            return compareName;
        }
    }
}
