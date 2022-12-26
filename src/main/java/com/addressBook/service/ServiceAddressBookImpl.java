package com.addressBook.service;

import com.addressBook.DAO.PersonDAO;
import com.addressBook.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAddressBookImpl implements ServiceAddressBook {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<Person> showAllPerson() {
        return personDAO.showAllPerson();
    }


}
