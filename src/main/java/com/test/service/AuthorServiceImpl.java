package com.test.service;

import com.test.model.Author;
import com.test.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void registerAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Author> getBookByAuthor(String name) {
        return null;
    }


}
