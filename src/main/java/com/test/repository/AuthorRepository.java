package com.test.repository;

import com.test.model.Author;
import com.test.model.Authority;
import com.test.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,String> {

    @Query(value = "SELECT a from Author a where a.name=:name")
    List<Authority> getAuthor(String name);
}
