package com.addressBook.entity;

import jakarta.persistence.CascadeType;
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
public class Organization {

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
    private List<People> people;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city")
    private City city;

    public Organization() {
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

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Organization{" + "id=" + id + ", name=" + name + ", address=" + address + ", people=" + people + ", city=" + city + '}';
    }

}
