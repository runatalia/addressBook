
package com.addressBook.DAO;

import com.addressBook.entity.Person;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 @Repository
public class PersonDAOImpl implements PersonDAO{
     
@Autowired
private EntityManager entityManager;

    @Override
    public List<Person> showAllPerson() {
       Session session = entityManager.unwrap(Session.class);
    return session.createQuery(from Person, Person.class).getResult();
    
    }
    
}
