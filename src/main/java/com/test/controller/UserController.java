package com.test.controller;

import com.test.model.Author;
import com.test.model.Book;
import com.test.model.User;
import com.test.service.AuthorService;
import com.test.service.BookService;
import com.test.service.OrderService;
import com.test.service.UserService;
import com.test.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/library")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;

    @PostMapping("/register")
    public void register(@RequestBody() User user) {
        userService.register(user);
    }

    @PostMapping("/create_author")
    @RolesAllowed(value = "ROLE_ADMIN")
    public void create_new_author(@RequestBody() Author author) {
        authorService.registerAuthor(author);
    }

    @PostMapping("/create_book")
    @RolesAllowed(value = "ROLE_ADMIN")
    public void create_new_book(@RequestBody() Book book) {
        bookService.registerBook(book);
    }

    @PostMapping("/register_admin")
    @RolesAllowed(value = "ROLE_USER")
    public void register_admin(@RequestParam String email, String password) {
        userService.registerAdmin(email, password);
    }

    @GetMapping("/get_all_book")
    @RolesAllowed(value = "ROLE_USER")
    public List<Book> get_all() {
        return bookService.getAll();
    }

    @RequestMapping("/get_book_by_author")
    @RolesAllowed(value = "ROLE_USER")
    public Book get_book_by_author(@RequestParam(value = "author") Author author) throws NotFoundException {
        return bookService.getBookByAuthor(author);
    }

    @GetMapping("/take_book_by_email")
    @RolesAllowed(value = "ROLE_USER")
    public void take_book(@RequestParam String email) {
        userService.takeBook(email);
    }

    @GetMapping("/decline_book")
    @RolesAllowed(value = "ROLE_USER")
    public void decline_book(@RequestParam String email) {
        userService.declineBook(email);
    }

    @GetMapping("/get_book_by_name")
    @RolesAllowed(value = "ROLE_USER")
    public List<Book> get_book_by_name(@RequestParam String name) {
        return bookService.getBookByName(name);
    }

    @GetMapping("/register_order")
    @RolesAllowed(value = "ROLE_USER")
    public void take_book(@RequestParam String email, int id) throws NotFoundException {
        userService.take(email, id);
    }

    @GetMapping("/return_book")
    @RolesAllowed(value = "ROLE_USER")
    public void return_book(String email) throws NotFoundException {
        userService.returnBook(email);
    }

}
