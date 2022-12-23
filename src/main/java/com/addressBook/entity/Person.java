package com.addressBook.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    static final long serialVersionUID = 123;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incPerson")
    @SequenceGenerator(name = "incPerson", sequenceName = "incPerson", allocationSize = 1)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "surname")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "homePhone")
    private String homePhone;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city")
    private City city;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization")
    private Organization organization;

    public Person() {
    }

    public Person(String surname, String name, String homePhone, String phone, String address, City city, Organization organization) {
        this.surname = surname;
        this.name = name;
        this.homePhone = homePhone;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.organization = organization;
    }

    public int getId() {
        return id;
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", surname=" + surname + ", name=" + name + ", homePhone=" + homePhone + ", phone=" + phone + ", address=" + address + ", city=" + city + ", organization=" + organization + '}';
    }

}
