package com.addressBook.DAO;


import com.addressBook.entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonDAOImpl implements PersonDAO {

@PersistenceContext  
private EntityManager entityManager;

@Transactional
    @Override 
    public List<Person> showAllPerson() {
        List<Person> list = entityManager.createQuery("from person", Person.class).getResultList();
        return list;
    }

}
