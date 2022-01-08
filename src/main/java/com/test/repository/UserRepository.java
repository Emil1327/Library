package com.test.repository;

import com.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u from User u where u.email=:email")
    User getByEmail(String email);

    @Query(value = "select  u from User  u where u.email=:email and u.password=:password")
    User getUserByEmailAndPassword(String email , String password);
}
