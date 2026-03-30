package com.example.demo.bean;

import org.springframework.stereotype.Component;

@Component 	
public class SingletonService {
    public void print() {
        System.out.println("[SingletonService] this = " + this);
    }
}
