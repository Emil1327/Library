package com.test.config;


import com.test.model.Order;
import com.test.repository.OrderRepository;
import com.test.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@EnableScheduling
@Component
public class ScheduledTest {

    @Scheduled(fixedDelay = 36000000)
    public void SendMessage() {



    }
}
