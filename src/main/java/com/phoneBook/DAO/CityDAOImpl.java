package com.phoneBook.DAO;

import com.phoneBook.entity.City;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDAOImpl implements CityDAO {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<City> showAllCity() {
        List<City> list = entityManager.createQuery("from City").getResultList();
        return list;
    }
}
