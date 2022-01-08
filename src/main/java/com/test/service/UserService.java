package com.test.service;

import com.test.model.Book;
import com.test.model.User;
import com.test.util.exception.NotFoundException;

public interface UserService {

    void register(User user);

    void sendEmail(String toEmail);

    void registerAdmin(String email, String password);

    User getByEmail(String email) throws NotFoundException;

    void take(String email, int id) throws NotFoundException;

    void takeBook(String email);

    void declineBook(String email);

    void returnBook (String email) throws NotFoundException;
}
