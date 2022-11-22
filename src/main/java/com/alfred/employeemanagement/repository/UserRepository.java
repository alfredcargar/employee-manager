package com.alfred.employeemanagement.repository;

import com.alfred.employeemanagement.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
