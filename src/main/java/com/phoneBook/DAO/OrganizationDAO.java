package com.phoneBook.DAO;

import com.phoneBook.entity.Organization;
import jakarta.transaction.Transactional;



public interface OrganizationDAO {

    @Transactional
    public Organization getOrganization(int id);
}
