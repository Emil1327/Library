package com.test.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "author")
    private Author author;

    @Column(name = "name")
    private String name ;

    @NotNull
    @Column(name = "",unique = true)
    private String ISBN;

    @Column(name = "bookStatus")
    private BookStatus bookStatus;

    @ManyToOne
    @JoinColumn(name = "use_by")
    private User user;

    public Book() {
    }

    public Book(int id, Author author, String name, String ISBN, BookStatus bookStatus, User user) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.ISBN = ISBN;
        this.bookStatus = bookStatus;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && Objects.equals(author, book.author) && Objects.equals(name, book.name) && Objects.equals(ISBN, book.ISBN) && bookStatus == book.bookStatus && Objects.equals(user, book.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, name, ISBN, bookStatus, user);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", name='" + name + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", bookStatus=" + bookStatus +
                ", user=" + user +
                '}';
    }
}
