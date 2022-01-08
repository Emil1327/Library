package com.test.service;

import com.test.model.Author;
import com.test.model.Book;
import com.test.util.exception.NotFoundException;

import java.util.List;

public interface BookService {
    void registerBook(Book book);

    List<Book> getAll();

    List<Book> getBookByName(String name);

    Book getBookByAuthor(Author author) throws NotFoundException;

    Book getBookById (Book book);
}
