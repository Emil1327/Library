package com.test.service;

import com.test.model.*;
import com.test.repository.AuthorityRepository;
import com.test.repository.BookRepository;
import com.test.repository.OrderRepository;
import com.test.repository.UserRepository;
import com.test.util.exception.NotFoundException;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private MailSender mailSender;


    @Override
    public User getByEmail(String email) throws NotFoundException {
        if (userRepository.getByEmail(email) != null) {
            User user = userRepository.getByEmail(email);
            return user;
        }
        throw new NotFoundException();
    }

    @Override
    public void take(String email, int id) throws NotFoundException {
        if (userRepository.getByEmail(email) == null) {
            throw new NotFoundException();
        }
        User user = userRepository.getByEmail(email);
        Book book1 = bookRepository.getBookById(id);
        Order order = new Order();
        book1.setUser(user);
        order.setUser(user);
        order.setBook(book1);
        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        order.setCreateDate(LocalDate.now());
        bookRepository.save(book1);
        orderRepository.save(order);

        String text = "Ete uzumeq vercnel girqe sxmeq ays hxumin http://localhost:8080/library/take_book_by_email?email="+email +
                " Ete hrajarvumeq sxmeq ays hxumin http://localhost:8080/library/decline_book?email=" +email;
        mailSender.sendSimpleMessage(email, "Book", text);
    }

    @Override
    public void takeBook(String email) {
        User user = userRepository.getByEmail(email);
        Order order = orderRepository.take(user);
        order.setOrderStatus(OrderStatus.APPROVED);

        order.setUser(user);
        order.setTakenDate(LocalDateTime.now());
        orderRepository.save(order);
    }

    @Override
    public void declineBook (String email){
        User user = userRepository.getByEmail(email);
        Order order = orderRepository.take(user);
        order.setOrderStatus(OrderStatus.DECLINED);
        order.setTakenDate(null);
        orderRepository.save(order);
    }

    @Override
    public void returnBook(String email) throws NotFoundException {
        User user = userRepository.getByEmail(email);
        if(orderRepository.take(user)==null){
            throw new NotFoundException();
        }
        Order order = orderRepository.take(user);
        order.setOrderStatus(OrderStatus.TAKEN);
        order.setTakenDate(null);
        orderRepository.save(order);
    }

    @Override
    public void register(User user) {
        user.setStatus(Status.UNVERIFIED);

        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        Authority role = authorityRepository.getRole("ROLE_USER");
        ArrayList<Authority> role1 = new ArrayList<Authority>();
        role1.add(role);

        user.setAuthority(role1);
        userRepository.save(user);
    }

    @Override
    public void registerAdmin(String email , String password) {
        User user1 =userRepository.getUserByEmailAndPassword(email, password);
        Authority role = authorityRepository.getRole("ROLE_ADMIN");
        ArrayList<Authority> role1 = new ArrayList<>();
        role1.add(role);

        user1.setAuthority(role1);
        userRepository.save(user1);
    }

    @Override
    public void sendEmail(String email) {
        String text = "Uzumes ancnel verefikaciya sxmi ays hxumin http://localhost:8080/user/verify?email=" + email;
        mailSender.sendSimpleMessage(email, "Verify", text);
    }
}

