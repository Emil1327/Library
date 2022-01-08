package com.test.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private User user;

    @Column(name = "createDate")
    private LocalDate createDate;

    @Column(name = "takeData")
    private LocalDateTime takenDate;

    @Column(name = "orderStatus")
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(int id, Book book, User user, LocalDate createDate, OrderStatus orderStatus) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.createDate = createDate;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(LocalDateTime takenDate) {
        this.takenDate = takenDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(book, order.book) && Objects.equals(user, order.user) && Objects.equals(createDate, order.createDate) && Objects.equals(takenDate, order.takenDate) && orderStatus == order.orderStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, user, createDate, takenDate, orderStatus);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", createDate=" + createDate +
                ", takenDate=" + takenDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
