package com.ach.calendfi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableRetry
public class CalendfiApplication {

    public static void main(String[] args) {
        //solve      The valid characters are defined in RFC 7230 and RFC 3986
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","[]");
        SpringApplication.run(CalendfiApplication.class, args);
    }

}
