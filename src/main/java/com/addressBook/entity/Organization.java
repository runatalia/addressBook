package com.addressBook.entity;


import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;


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

    public Organization(String name, String address,City city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
