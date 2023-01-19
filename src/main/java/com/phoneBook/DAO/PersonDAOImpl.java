package com.phoneBook.DAO;



import com.phoneBook.entity.City;
import com.phoneBook.entity.Organization;
import com.phoneBook.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Person> showAllPerson() {
//        City city = new City("Москва", "Московская область");
//        City newcity = entityManager.merge(city);
//        city.setId(newcity.getId());
//        Organization organization = new Organization("Малявка","563421","Куприянова 5", entityManager.find(City.class, 2));
//        Organization newOrganization = entityManager.merge(organization);
//        organization.setId(newOrganization.getId());
//        Person person = new Person("Пушкин", "Александр", "Сергеевич", "83455322244", 
//                "Pyshkin@mail.ru", null,null,entityManager.find(City.class, 2),
//                entityManager.find(Organization.class, 1));
//        Person newPerson = entityManager.merge(person);
//        person.setId(newPerson.getId());
//        Person person1 = new Person("Толстой", "Лев","Николаевич", "81452345812", 
//                "tolstiy@mail.ru", null,null, entityManager.find(City.class, 2),
//                entityManager.find(Organization.class, 1));
//        Person newPerson1 = entityManager.merge(person1);
//        person1.setId(newPerson1.getId());
        List<Person> allPerson = entityManager.createQuery("from Person", Person.class).getResultList();
        return allPerson;
    }

    @Transactional
    @Override
    public Person getPerson(int id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }
 
    

}
