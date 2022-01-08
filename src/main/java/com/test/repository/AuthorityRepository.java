package com.test.repository;

import com.test.model.Author;
import com.test.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Author,String> {

    @Query("SELECT a from Authority a where a.name=:name")
    Authority getRole(String name);
}
