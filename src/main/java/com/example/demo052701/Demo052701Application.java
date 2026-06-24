package com.example.demo052701;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo052701.mapper")
public class Demo052701Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo052701Application.class, args);
        System.out.println("系统已启动：http://localhost:8080/");
    }
}
