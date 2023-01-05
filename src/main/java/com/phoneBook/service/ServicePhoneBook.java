package com.phoneBook.service;

import com.phoneBook.entity.City;
import com.phoneBook.entity.Organization;
import com.phoneBook.entity.Person;
import java.util.List;

public interface ServicePhoneBook {

    public Person getPerson(int id);

    public List<Person> showAllPerson();

    public Organization getOrganization(int id);

    public List<City> showAllCity();

}
