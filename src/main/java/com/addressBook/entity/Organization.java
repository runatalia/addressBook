package com.addressBook.entity;


import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.OneToMany;

@Entity
@Table(name = "organizations")
public class Organization implements Serializable {
    static final long serialVersionUID = 123;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incOrganizationse")
    @SequenceGenerator(name = "incOrganizationse", sequenceName = "incOrganizationse", allocationSize = 1)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "organization", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Person> person;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city")
    private City city;

    public Organization() {
    }

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }
    

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Person> getPeople() {
        return person;
    }

    public void setPeople(List<Person> people) {
        this.person = people;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", name=" + name + ", address=" + address + ", person=" + person + ", city=" + city + '}';
    }

}
