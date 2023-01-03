package com.phoneBook.entity;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "city")
public class City implements Serializable {

    static final long serialVersionUID = 123;
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "incCity")
    @SequenceGenerator(name = "incCity", sequenceName = "incCity", allocationSize = 1)
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "city")
    private String nameCity;
    @Column(name = "region")
    private String region;

    @OneToMany(mappedBy = "city", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Person> person;

    @OneToMany(mappedBy = "city", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Organization> organization;

    public City() {
    }

    public City(String nameCity, String region) { 
        this.nameCity = nameCity;
        this.region = region;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<Person> getPeople() {
        return person;
    }

    public void setPeople(List<Person> person) {
        this.person = person;
    }

    public List<Organization> getOrganization() {
        return organization;
    }

    public void setOrganization(List<Organization> organization) {
        this.organization = organization;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.nameCity);
        hash = 19 * hash + Objects.hashCode(this.region);
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
        final City other = (City) obj;
        if (!Objects.equals(this.nameCity, other.nameCity)) {
            return false;
        }
        return Objects.equals(this.region, other.region);
    }


    @Override
    public String toString() {
        return "City{" + "id=" + id + ", nameCity=" + nameCity + ", region=" + region + ", person=" + person + ", organization=" + organization + '}';
    }

}
