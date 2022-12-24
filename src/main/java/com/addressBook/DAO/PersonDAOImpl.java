package com.addressBook.DAO;

import com.addressBook.entity.City;
import com.addressBook.entity.Organization;
import com.addressBook.entity.Person;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transaction
    public List<Person> showAllPerson() {
        Session session = entityManager.unwrap(Session.class);
//        session.save(new Person("DD","dd","d","w","q",
//                new City("Moscow","MO","dd"),new Organization("r","e")));
        return session.createQuery("from person", Person.class).getResultList();
    }

}
