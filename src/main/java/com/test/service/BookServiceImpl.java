package com.test.service;

import com.test.model.Author;
import com.test.model.Book;
import com.test.model.BookStatus;
import com.test.repository.BookRepository;
import com.test.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void registerBook(Book book) {
        book.setBookStatus(BookStatus.FREE);
        bookRepository.save(book);
    }

    @Override
    public Book getBookByAuthor(Author author) throws NotFoundException {
        if(bookRepository.getBookByAuthor(author)==null){
            throw new NotFoundException();
        }
        return bookRepository.getBookByAuthor(author);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBookByName(String name) {
        return bookRepository.getBookByName(name);
    }

    @Override
    public Book getBookById(Book book) {
        return bookRepository.getBookById(book.getId());
    }


}
