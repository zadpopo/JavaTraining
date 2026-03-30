package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.example.demo.bean.PrototypeService;
import com.example.demo.bean.SingletonService;

@Service
public class DemoService {

    private final ApplicationContext context;

    public DemoService(ApplicationContext context) {
        this.context = context;
    }

    public void run() {
        SingletonService s1 = context.getBean(SingletonService.class);
        SingletonService s2 = context.getBean(SingletonService.class);
        System.out.println("s1 == s2 Singleton Same? " + (s1 == s2));
        s1.print();
        s2.print();

        PrototypeService p1 = context.getBean(PrototypeService.class);
        PrototypeService p2 = context.getBean(PrototypeService.class);
        System.out.println("p1 == p2 Prototype Same? " + (p1 == p2));
        p1.print();
        p2.print();
    }
}
