package com.ach.calendfi.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
@MapperScan("com.ach.calendfi.mybatis.dao")
public class CalendfiWebApplication {

    public static void main(String[] args) {
        //solve      The valid characters are defined in RFC 7230 and RFC 3986
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","[]");
        SpringApplication.run(CalendfiWebApplication.class, args);
    }

}
