package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@SpringBootApplication Spring Boot 애플리케이션의 시작 클래스를 정의할 때 사용하는 어노테이션

*/
@SpringBootApplication
public class TodoServerApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TodoServerApplication.class, args);
    }
}
