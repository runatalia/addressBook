package com.phoneBook.DAO;

import com.phoneBook.entity.Person;
import java.util.List;


public interface PersonDAO{

    public List<Person> showAllPerson();
    public Person getPerson(int id);
    public void deletePerson(int id);
}
