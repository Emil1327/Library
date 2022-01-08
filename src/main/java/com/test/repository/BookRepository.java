package com.test.repository;

import com.test.model.Author;
import com.test.model.Book;
import com.test.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    @Query(value = "SELECT b from Book b where b.author=:author")
    Book getBookByAuthor(Author author);

    @Query(value = "SELECT b from Book b where b.name=:name")
    List<Book> getBookByName(String name);

    @Query (value = "select b from Book b where b.id=:id")
    Book getBookById(int id);
}
