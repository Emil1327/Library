package com.test.service;

import com.test.model.Author;
import com.test.model.Book;

import java.util.List;

public interface AuthorService {
    void registerAuthor(Author author);
    List<Author> getBookByAuthor(String name);
}
