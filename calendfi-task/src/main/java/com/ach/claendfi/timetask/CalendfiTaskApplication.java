package com.ach.claendfi.timetask;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
@EnableRetry
@MapperScan("com.ach.calendfi.mybatis.dao")
public class CalendfiTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendfiTaskApplication.class, args);
    }

}
