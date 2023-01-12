package com.phoneBook.DAO;

import com.phoneBook.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {

}
