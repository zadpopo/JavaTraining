
package com.example.demo.service;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class BookService {

    private final LoggerService logger;

    public BookService(LoggerService logger) {
        this.logger = logger;
    }
    
    @PostConstruct
    public void init() {
        logger.log("M8 Exercise 6 Book Service initialized!");
    }
    
}
