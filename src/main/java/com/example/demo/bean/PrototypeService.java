package com.example.demo.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototypeService {
    public void print() {
        System.out.println("[PrototypeService] this = " + this);
    }
}
