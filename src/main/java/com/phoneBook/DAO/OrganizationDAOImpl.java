package com.phoneBook.DAO;

import com.phoneBook.entity.Organization;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public Organization getOrganization(int id) {
        Organization organization = entityManager.find(Organization.class, id);
        return organization;
    }

}
