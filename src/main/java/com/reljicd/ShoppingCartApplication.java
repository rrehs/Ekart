package com.reljicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingCartApplication {

    public static void main(String[] args) {
        System.out.println("code is now running");
        SpringApplication.run(ShoppingCartApplication.class, args);
    }
}
