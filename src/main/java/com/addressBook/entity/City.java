package com.addressBook.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;

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
    @Column(name = "cod")
    private String codeRegion;

    @OneToMany(mappedBy = "city", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<People> people;

    @OneToMany(mappedBy = "city", cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Organization> organization;

    public City() {
    }

    public int getId() {
        return id;
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

    public String getCodeRegion() {
        return codeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        this.codeRegion = codeRegion;
    }

    public List<People> getPeople() {
        return people;
    }

    public void setPeople(List<People> people) {
        this.people = people;
    }

    public List<Organization> getOrganization() {
        return organization;
    }

    public void setOrganization(List<Organization> organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "City{" + "id=" + id + ", nameCity=" + nameCity + ", region=" + region + ", codeRegion=" + codeRegion + ", people=" + people + ", organization=" + organization + '}';
    }
    

}
