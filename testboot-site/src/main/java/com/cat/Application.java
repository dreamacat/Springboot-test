package com.cat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
@SpringBootApplication
public class Application {


    @RequestMapping("")
    public String greeting() {
        System.out.println("love u a");
        return "Hello World!";
    }
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }
}
