package com.phoneBook.service;

import com.phoneBook.DAO.OrganizationDAO;
import com.phoneBook.DAO.PersonDAO;
import com.phoneBook.entity.Organization;
import com.phoneBook.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePhoneBookImpl implements ServicePhoneBook {

    @Autowired
    private PersonDAO personDAO;
    @Autowired
    private OrganizationDAO organizationDAO;

    @Override
    public List<Person> showAllPerson() {
        return personDAO.showAllPerson();
    }

    @Override
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    public Organization getOrganization(int id) {
        return organizationDAO.getOrganization(id);
    }

}
